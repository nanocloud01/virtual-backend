package bo.gob.asfi.virtual.model.repositories;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.virtual.model.entiies.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}