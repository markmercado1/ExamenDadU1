package com.mem.mscursos.service;

import com.mem.mscursos.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listar();

    Curso guardar(Curso curso);
    Curso buscarPorId(Long id); // ← agregado

    Curso actualizar(Curso persona);
    Optional<Curso> listarPorId(Long id);
    void eliminarPorId(Long id);
}