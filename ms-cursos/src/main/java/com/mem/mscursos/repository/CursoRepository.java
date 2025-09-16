package com.mem.mscursos.repository;

import com.mem.mscursos.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}