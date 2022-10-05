package org.evega.ms.cursos.services;

import org.evega.ms.cursos.entities.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listar();
    Optional<Curso> porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
