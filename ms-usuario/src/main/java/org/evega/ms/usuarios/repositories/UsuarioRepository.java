package org.evega.ms.usuarios.repositories;

import org.evega.ms.usuarios.models.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
