package bo.gob.asfi.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.digital.params.entities.Clasificador;
import bo.gob.asfi.digital.params.services.ClasificadorService;

@RestController
@RequestMapping("/clasificador")
public class ParametersController {
	
	@Autowired
	private ClasificadorService clasificadorService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clasificador> getClasificador() {
		return clasificadorService.getClasificador();
	}

}
