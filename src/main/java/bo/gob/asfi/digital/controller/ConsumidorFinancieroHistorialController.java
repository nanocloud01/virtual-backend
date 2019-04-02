package bo.gob.asfi.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.digital.cic.entities.ConsumidorFinancieroHistorico;
import bo.gob.asfi.digital.cic.services.ConsumidorFinancieroHistorialService;

@RestController
@RequestMapping("/consumidoresfinancieros")
public class ConsumidorFinancieroHistorialController {
	
	@Autowired
	private ConsumidorFinancieroHistorialService historicoServio;
	
	@RequestMapping("/historial/{ci}")
	public List<ConsumidorFinancieroHistorico> getConsumidoresHistorico(@PathVariable("ci") String ci) {
		return historicoServio.getConsumidoresHistoricos(ci);
	}

}
