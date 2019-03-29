package bo.gob.asfi.digital.model.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;
import bo.gob.asfi.digital.model.repositories.ConsumidorFinancieroRepository;
import bo.gob.asfi.digital.model.services.ConsumidorFinancieroService;

@Service
public class ConsumidorFinancieroServiceImpl implements ConsumidorFinancieroService {
	
	@Autowired
	private ConsumidorFinancieroRepository consumidorFinancieroRepository;
	
	@Override
	public List<ConsumidorFinanciero> getAllConsumidoresFinancieros() {
		List<ConsumidorFinanciero> lstConsumidoresFinancieros = new ArrayList<>();
		consumidorFinancieroRepository.findAll().forEach(lstConsumidoresFinancieros ::add);
		return lstConsumidoresFinancieros;
	}
	
	@Override
	public Page<ConsumidorFinanciero> getAllConsumidoresFinancierosPageable(Pageable pageable) {
		return consumidorFinancieroRepository.findAll(pageable);
	}
	
	@Override
	public ConsumidorFinanciero getConsumidorFinanciero(Integer id) {
		return consumidorFinancieroRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional("digitalTransactionManager")
	public ConsumidorFinanciero AddConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero) {
		consumidorFinanciero.getUsuarioConsumidorFinanciero().setIdConsumidorFinanciero(consumidorFinanciero);
		return consumidorFinancieroRepository.save(consumidorFinanciero);
	}
	
	@Override
	@Transactional("digitalTransactionManager")
	public ConsumidorFinanciero updateConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero) {
		consumidorFinanciero.getUsuarioConsumidorFinanciero().setIdConsumidorFinanciero(consumidorFinanciero);
		return consumidorFinancieroRepository.save(consumidorFinanciero);
	}
	
	@Override
	public void deleteConsumidorFinanciero(Integer id) {
		consumidorFinancieroRepository.deleteById(id);
	}
	
}
