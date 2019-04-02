package bo.gob.asfi.digital.cic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.digital.cic.entities.ConsumidorFinancieroHistorico;
import bo.gob.asfi.digital.cic.repositories.ConsumidorFinancieroHistorialRepository;

@Service
public class ConsumidorFinancieroHistorialService {
	
	@Autowired
	private ConsumidorFinancieroHistorialRepository historicoRepositorio;
	
	public List<ConsumidorFinancieroHistorico> getConsumidoresHistoricos(String ci) {
		return historicoRepositorio.getConsumidoresHistoricos(ci);
	}

}
