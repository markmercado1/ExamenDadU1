package com.mem.matricula.service;

import com.mem.matricula.dto.MatriculaDTO;
import com.mem.matricula.models.Matricula;

import java.util.List;

public interface MatriculaService {
    Matricula save(Matricula matricula);
    Matricula update(Long id, Matricula matricula);
    void delete(Long id);
    MatriculaDTO findById(Long id);
    List<Matricula> findAll();
}