package bo.gob.asfi.digital.model.services;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;

public interface ConsumidorFinancieroService {
	
	public List<ConsumidorFinanciero> getAllConsumidoresFinancieros();	
	
	public Page<ConsumidorFinanciero> getAllConsumidoresFinancierosPageable(Pageable pageable);
	
	public ConsumidorFinanciero getConsumidorFinanciero(Integer id);
	
	public ConsumidorFinanciero AddConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero);
	
	public ConsumidorFinanciero updateConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero);
	
	public void deleteConsumidorFinanciero(Integer id);

}
