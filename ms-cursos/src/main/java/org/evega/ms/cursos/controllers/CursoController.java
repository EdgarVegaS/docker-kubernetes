package org.evega.ms.cursos.controllers;

import lombok.AllArgsConstructor;
import org.evega.ms.cursos.entities.Curso;
import org.evega.ms.cursos.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping
    public ResponseEntity<?> listaCursos(){
        return ResponseEntity.ok().body(cursoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> cursoPorId(@PathVariable Long id){
        Optional<Curso> curso = cursoService.porId(id);
        if (curso.isPresent()){
            return ResponseEntity.ok().body(curso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crearCurso(@RequestBody Curso curso){
        Curso cursoGuardado = cursoService.guardar(curso);
        return ResponseEntity.ok().body(cursoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Curso curso, @PathVariable Long id){
        Optional<Curso> cursoOptional = cursoService.porId(id);
        if (cursoOptional.isPresent()){
            Curso cursoDB = new Curso();
            cursoDB.setName(curso.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.guardar(cursoDB));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> cursoOptional = cursoService.porId(id);
        if (cursoOptional.isPresent()){
            cursoService.eliminar(cursoOptional.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
