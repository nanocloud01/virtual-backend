package bo.gob.asfi.digital.model.repositories;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.digital.model.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
