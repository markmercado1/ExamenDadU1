package com.mem.matricula.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoDto {
    @JsonProperty("id")   // 👈 le dice que tome el campo "id" del JSON
    private Long idCurso;
    private String nombre;
    private String codigo;
}
