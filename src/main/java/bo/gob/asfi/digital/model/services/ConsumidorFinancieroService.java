package bo.gob.asfi.digital.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;
import bo.gob.asfi.digital.model.repositories.ConsumidorFinancieroRepository;

@Service
public class ConsumidorFinancieroService {
	
	@Autowired
	private ConsumidorFinancieroRepository consumidorFinancieroRepository;
	
	public List<ConsumidorFinanciero> getAllUsuarios() {
		List<ConsumidorFinanciero> usuarios = new ArrayList<>();
		consumidorFinancieroRepository.findAll().forEach(usuarios ::add);
		return usuarios;
	}
	
	public ConsumidorFinanciero AddConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero) {
		consumidorFinanciero.getUsuarioConsumidorFinanciero().setIdConsumidorFinanciero(consumidorFinanciero);
		return consumidorFinancieroRepository.save(consumidorFinanciero);
	}
	
	public ConsumidorFinanciero getUsuario(Integer id) {
		return consumidorFinancieroRepository.findById(id).orElse(null);
	}

}
