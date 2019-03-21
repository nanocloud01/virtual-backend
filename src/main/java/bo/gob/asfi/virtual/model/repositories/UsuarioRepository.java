package bo.gob.asfi.virtual.model.repositories;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.virtual.model.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
