package com.mem.matricula.repository;

import com.mem.matricula.models.DetalleMatricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleMatriculaRepository extends JpaRepository<DetalleMatricula, Long> {
    List<DetalleMatricula> findByMatriculaIdMatricula(Long id);
}