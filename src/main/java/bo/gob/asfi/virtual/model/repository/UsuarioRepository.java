package bo.gob.asfi.virtual.model.repository;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.virtual.model.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
