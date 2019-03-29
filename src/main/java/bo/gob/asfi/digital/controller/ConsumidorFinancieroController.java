package bo.gob.asfi.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;
import bo.gob.asfi.digital.model.services.ConsumidorFinancieroService;

@RestController
@RequestMapping("/consumidoresfinancieros")
public class ConsumidorFinancieroController {
	
	@Autowired
	private ConsumidorFinancieroService consumidorFinancieroService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ConsumidorFinanciero> getConsumidoresFinancieros() {
		return consumidorFinancieroService.getAllConsumidoresFinancieros();
	}
	
	@GetMapping(value = "/pageable", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ConsumidorFinanciero>> getConsumidoresFinancieros(Pageable pageable) {
		Page<ConsumidorFinanciero> con = null;
		try {
			con = consumidorFinancieroService.getAllConsumidoresFinancierosPageable(pageable);
		} catch (Exception e) {
			System.out.println("listarPageable "+e.getMessage());
			return new ResponseEntity<Page<ConsumidorFinanciero>>(con, HttpStatus.INTERNAL_SERVER_ERROR);			
		}
		return new ResponseEntity<Page<ConsumidorFinanciero>>(con, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsumidorFinanciero getConsumidorFinanciero(@PathVariable Integer id) {
		return consumidorFinancieroService.getConsumidorFinanciero(id);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsumidorFinanciero addConsumidorFinanciero(@RequestBody ConsumidorFinanciero consumidorFinanciero) {
		ConsumidorFinanciero c = consumidorFinancieroService.AddConsumidorFinanciero(consumidorFinanciero);
		return c;
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ConsumidorFinanciero updateConsumidorFinanciero(@RequestBody ConsumidorFinanciero consumidorFinanciero) {
		return consumidorFinancieroService.updateConsumidorFinanciero(consumidorFinanciero);		
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteConsumidorFinanciero(@PathVariable Integer id) {
		consumidorFinancieroService.deleteConsumidorFinanciero(id);
	}

}
