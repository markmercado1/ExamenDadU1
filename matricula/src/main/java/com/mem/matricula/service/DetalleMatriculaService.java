package com.mem.matricula.service;

import com.mem.matricula.models.DetalleMatricula;

import java.util.List;
import java.util.Optional;

public interface DetalleMatriculaService {

    List<DetalleMatricula> listar();

    Optional<DetalleMatricula> obtenerPorId(Long id);

    DetalleMatricula guardar(DetalleMatricula detalle);

    DetalleMatricula actualizar(Long id, DetalleMatricula detalle);

    void eliminar(Long id);
}
