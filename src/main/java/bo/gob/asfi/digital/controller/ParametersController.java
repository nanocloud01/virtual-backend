package bo.gob.asfi.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.digital.params.entities.Clasificador;
import bo.gob.asfi.digital.params.services.ClasificadorService;

@RestController
public class ParametersController {
	
	@Autowired
	private ClasificadorService clasificadorService;
	
	@RequestMapping("/clasificador")
	public List<Clasificador> getUsuarios2() {
		System.out.println("rest");
		return clasificadorService.getClasificador();
	}

}
