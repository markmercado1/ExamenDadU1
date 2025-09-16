package com.mem.matricula.service.serviceImpl;


import com.mem.matricula.models.DetalleMatricula;
import com.mem.matricula.repository.DetalleMatriculaRepository;
import com.mem.matricula.service.DetalleMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleMatriculaServiceImpl implements DetalleMatriculaService {

    private final DetalleMatriculaRepository repository;

    @Override
    public List<DetalleMatricula> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<DetalleMatricula> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetalleMatricula guardar(DetalleMatricula detalle) {
        return repository.save(detalle);
    }

    @Override
    public DetalleMatricula actualizar(Long id, DetalleMatricula detalle) {
        detalle.setIdDetalleMatricula(id);
        return repository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
