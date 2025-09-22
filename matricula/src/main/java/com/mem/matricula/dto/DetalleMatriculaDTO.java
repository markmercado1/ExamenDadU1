package com.mem.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class DetalleMatriculaDTO {
    private Long idMatricula;
    private Long idCurso;
    private Long idDetalleMatricula;
    private CursoDto curso;
}
