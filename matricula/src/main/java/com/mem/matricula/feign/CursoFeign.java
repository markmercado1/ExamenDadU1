package com.mem.matricula.feign;

import com.mem.matricula.dto.CursoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-curso", path = "/cursos")
public interface CursoFeign {

    @GetMapping("/{id}")
    ResponseEntity<CursoDto> buscarPorId(@PathVariable Long id);

}