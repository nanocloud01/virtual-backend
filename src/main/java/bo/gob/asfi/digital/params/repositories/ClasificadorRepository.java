package bo.gob.asfi.digital.params.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import bo.gob.asfi.digital.params.entities.Clasificador;

public interface ClasificadorRepository extends CrudRepository<Clasificador, Integer> {
	
	public List<Clasificador> findByDominioAndEstadoRegistro(String dominio, String estadoRegistro);

}
