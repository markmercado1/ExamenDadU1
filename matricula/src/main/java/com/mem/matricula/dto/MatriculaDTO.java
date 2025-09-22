package com.mem.matricula.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MatriculaDTO {
    private Long idMatricula;
    private String nombreAlumno;
    private String numeroMatricula;
    private List<DetalleMatriculaDTO> detalles;
}