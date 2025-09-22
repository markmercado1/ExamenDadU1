package com.mem.matricula.service.serviceImpl;

import com.mem.matricula.dto.CursoDto;
import com.mem.matricula.dto.DetalleMatriculaDTO;
import com.mem.matricula.dto.MatriculaDTO;
import com.mem.matricula.feign.CursoFeign;
import com.mem.matricula.mappers.MatriculaMapper;
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
    private final MatriculaMapper matriculaMapper;

    @Autowired
    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, DetalleMatriculaRepository detalleMatriculaRepository, CursoFeign cursoFeign, MatriculaMapper matriculaMapper) {
        this.matriculaRepository = matriculaRepository;
        this.detalleMatriculaRepository = detalleMatriculaRepository;
        this.cursoFeign = cursoFeign;
        this.matriculaMapper = matriculaMapper;
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
                .orElseThrow(() -> new RuntimeException("Matrícula con id " + id + " no encontrada"));;

        List<DetalleMatricula> detalles = detalleMatriculaRepository.findByMatriculaIdMatricula(id);

        List<DetalleMatriculaDTO> detallesDTO = detalles.stream().map(det -> {
            DetalleMatriculaDTO dto = matriculaMapper.toDto(det);

            CursoDto curso = cursoFeign.buscarPorId(det.getIdCurso()).getBody();
            dto.setCurso(curso);

            return dto;
        }).toList();

        MatriculaDTO dto = matriculaMapper.toDto(matricula);
        dto.setDetalles(detallesDTO);

        return dto;
    }


    @Override
    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }
}