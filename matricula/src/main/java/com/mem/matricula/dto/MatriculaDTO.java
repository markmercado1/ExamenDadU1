package com.mem.matricula.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MatriculaDTO {
    private Long idMatricula;
    private String nombreAlumno;
    private String numeroMatricula;
    private List<DetalleMatriculaDTO> detalles;
}