package com.mem.matricula.service.serviceImpl;

import com.mem.matricula.dto.CursoDto;
import com.mem.matricula.dto.DetalleMatriculaDTO;
import com.mem.matricula.dto.MatriculaDTO;
import com.mem.matricula.feign.CursoFeign;
import com.mem.matricula.models.DetalleMatricula;
import com.mem.matricula.models.Matricula;
import com.mem.matricula.repository.DetalleMatriculaRepository;
import com.mem.matricula.repository.MatriculaRepository;
import com.mem.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final DetalleMatriculaRepository detalleMatriculaRepository;
    private final CursoFeign cursoFeign;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, DetalleMatriculaRepository detalleMatriculaRepository, CursoFeign cursoFeign) {
        this.matriculaRepository = matriculaRepository;
        this.detalleMatriculaRepository = detalleMatriculaRepository;
        this.cursoFeign = cursoFeign;
    }

    @Override
    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula update(Long id, Matricula matricula) {
        return matriculaRepository.save(matricula);

    }

    @Override
    public void delete(Long id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se puede eliminar, matrícula con id " + id + " no existe");
        }
    }

    @Override
    public MatriculaDTO findById(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matrícula con id " + id + " no encontrada"));

        // Obtener los detalles asociados
        List<DetalleMatricula> detalles = detalleMatriculaRepository.findByMatriculaIdMatricula(id);

        // Convertir a DTO con los datos del curso desde Feign
        List<DetalleMatriculaDTO> detallesDTO = detalles.stream().map(det -> {
            DetalleMatriculaDTO dto = new DetalleMatriculaDTO();
            dto.setIdDetalleMatricula(det.getIdDetalleMatricula());
            dto.setIdMatricula(det.getMatricula().getIdMatricula());
            dto.setIdCurso(det.getIdCurso());

            // 🔹 Llamada al ms-curso
            CursoDto curso = cursoFeign.buscarPorId(det.getIdCurso()).getBody();
            dto.setCurso(curso);

            return dto;
        }).toList();

        // Retornar un DTO general
        return MatriculaDTO.builder()
                .idMatricula(matricula.getIdMatricula())
                .nombreAlumno(matricula.getNombreAlumno())
                .numeroMatricula(matricula.getNumeroMatricula())
                .detalles(detallesDTO)
                .build();
    }

    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }
}