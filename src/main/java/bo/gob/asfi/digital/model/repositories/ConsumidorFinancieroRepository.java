package bo.gob.asfi.digital.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;

public interface ConsumidorFinancieroRepository extends JpaRepository<ConsumidorFinanciero, Integer> {
	
	Page<ConsumidorFinanciero> findByCedulaIdentidadContaining(String cedulaIdentidad, Pageable pageable);

}
