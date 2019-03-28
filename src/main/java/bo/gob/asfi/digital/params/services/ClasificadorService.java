package bo.gob.asfi.digital.params.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.digital.params.entities.Clasificador;
import bo.gob.asfi.digital.params.repositories.ClasificadorRepository;

@Service
public class ClasificadorService {
	
	@Autowired
	private ClasificadorRepository clasificadorRepository;
	
	public List<Clasificador> getAllClasificador() {
		List<Clasificador> ltsClasificador = new ArrayList<>();
		clasificadorRepository.findAll().forEach(ltsClasificador ::add);
		return ltsClasificador;
	}
	
	public List<Clasificador> getClasificador() {
		List<Clasificador> ltsClasificador = new ArrayList<>();
		clasificadorRepository.findByDominioAndEstadoRegistro("departamento", "A") .forEach(ltsClasificador ::add);
		return ltsClasificador;
	}

}
