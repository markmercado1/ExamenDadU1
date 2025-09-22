package com.mem.matricula.mappers;

import com.mem.matricula.dto.DetalleMatriculaDTO;
import com.mem.matricula.dto.MatriculaDTO;
import com.mem.matricula.models.DetalleMatricula;
import com.mem.matricula.models.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    @Mapping(target = "numeroMatricula", expression = "java(\"Matrícula \" + matricula.getNumeroMatricula())")
    @Mapping(target = "detalles", ignore = true) // se llenará aparte
    MatriculaDTO toDto(Matricula matricula);

    @Mapping(target = "curso", ignore = true) // se llenará con Feign
    DetalleMatriculaDTO toDto(DetalleMatricula detalle);
}