package com.mem.matricula.dto;

import lombok.Data;

@Data
public class DetalleMatriculaDTO {
    private Long idMatricula;
    private Long idCurso;
    private Long idDetalleMatricula;
    private CursoDto curso;
}
