package bo.gob.asfi.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;
import bo.gob.asfi.digital.model.services.ConsumidorFinancieroService;
import bo.gob.asfi.digital.modelfoo.entities.FooUsuario;
import bo.gob.asfi.digital.modelfoo.services.FooUsuarioService;

@RestController
public class ConsumidorFinancieroController {
	
	@Autowired
	private ConsumidorFinancieroService consumidorFinancieroService;
	
	@Autowired
	private FooUsuarioService fooUsuarioService;
	
	@RequestMapping("/consumidoresfinancieros")
	public List<ConsumidorFinanciero> getUsuarios() {
		return consumidorFinancieroService.getAllUsuarios();
	}
	
	@RequestMapping("/consumidoresfinancieros/{id}")
	public ConsumidorFinanciero getUsuario(@PathVariable Integer id) {
		return consumidorFinancieroService.getUsuario(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/consumidoresfinancieros")
	public ConsumidorFinanciero addConsumidorFinanciero(@RequestBody ConsumidorFinanciero consumidorFinanciero) {
		ConsumidorFinanciero c = consumidorFinancieroService.AddConsumidorFinanciero(consumidorFinanciero);
		return c;
	}
	
	@RequestMapping("/consumidoresfinancieros2")
	public List<FooUsuario> getUsuarios2() {
		return fooUsuarioService.getAllUsuarios();
	}

}
