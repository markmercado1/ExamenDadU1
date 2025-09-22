package com.mem.mscursos.controller;


import com.mem.mscursos.models.Curso;
import com.mem.mscursos.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar(){

        return ResponseEntity.ok().body(cursoService.listar());
    }

    @PostMapping()
    public ResponseEntity <Curso> save(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.guardar(curso));

    }
    @PutMapping()
    public ResponseEntity<Curso> listById(@PathVariable (required = true) Long id){
        return ResponseEntity.ok().body(cursoService.listarPorId(id).get());


    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        return ResponseEntity.ok(curso);
    }
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Long id){
        cursoService.eliminarPorId(id);
        return "Se elimino Correctamente";
    }

}