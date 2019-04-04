package bo.gob.asfi.digital.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;

public interface ConsumidorFinancieroRepository extends JpaRepository<ConsumidorFinanciero, Integer> {
	
	Page<ConsumidorFinanciero> findByDocumentoIdentificacionContaining(String documentoIdentificacion, Pageable pageable);
	
	@Modifying
	@Query(value = "INSERT INTO digital.users_roles(user_id, roles_id) VALUES(:user_id, :roles_id)", nativeQuery = true)
	int registralRol(Long user_id, Long roles_id);

}
