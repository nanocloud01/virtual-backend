package bo.gob.asfi.virtual.model.repository;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.virtual.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
