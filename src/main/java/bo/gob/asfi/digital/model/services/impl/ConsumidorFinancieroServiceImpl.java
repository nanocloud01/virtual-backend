package bo.gob.asfi.digital.model.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bo.gob.asfi.digital.model.entities.ConsumidorFinanciero;
import bo.gob.asfi.digital.model.entities.Rol;
import bo.gob.asfi.digital.model.repositories.ConsumidorFinancieroRepository;
import bo.gob.asfi.digital.model.services.ConsumidorFinancieroService;
import bo.gob.asfi.mail.MailClient;

@Service
public class ConsumidorFinancieroServiceImpl implements ConsumidorFinancieroService {
	
	@Autowired
	private ConsumidorFinancieroRepository consumidorFinancieroRepository;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
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
	public Page<ConsumidorFinanciero> getFindByDocumentoIdentificacionContaining(String documentoIdentificacion, Pageable pageable){
		return consumidorFinancieroRepository.findByDocumentoIdentificacionContaining(documentoIdentificacion, pageable);
	}
	
	@Override
	public ConsumidorFinanciero getConsumidorFinanciero(Integer id) {
		return consumidorFinancieroRepository.findById(id).orElse(null);
	}
	
	@Override
	@Transactional("digitalTransactionManager")
	public ConsumidorFinanciero AddConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero) {
		ConsumidorFinanciero cf = new ConsumidorFinanciero();
		consumidorFinanciero.getUser().setUsername(consumidorFinanciero.getCorreoElectronico());
		String plainPassword = generatePassword();
		consumidorFinanciero.getUser().setPassword(passEncoder.encode(plainPassword));
		consumidorFinanciero.getUser().setEnabled(true);
		
		consumidorFinanciero.getUser().setIdConsumidorFinanciero(consumidorFinanciero);
		cf = consumidorFinancieroRepository.save(consumidorFinanciero);
		
		consumidorFinancieroRepository.registralRol(cf.getUser().getId().longValue(), 1L);
		enviarCorreoInicial(consumidorFinanciero.getCorreoElectronico(), plainPassword);
		return cf;
	}
	
	@Override
	@Transactional("digitalTransactionManager")
	public ConsumidorFinanciero updateConsumidorFinanciero(ConsumidorFinanciero consumidorFinanciero) {
		consumidorFinanciero.getUser().setIdConsumidorFinanciero(consumidorFinanciero);
		return consumidorFinancieroRepository.save(consumidorFinanciero);
	}
	
	@Override
	public void deleteConsumidorFinanciero(Integer id) {
		consumidorFinancieroRepository.deleteById(id);
	}
	
	private String generatePassword() {
		String password = UUID.randomUUID().toString().substring(0, 8);
		System.out.println(password);
        return password;
    }
	
	private int enviarCorreoInicial(String destino, String password) {
		MailClient mailClient = new MailClient();
		StringBuilder sb = new StringBuilder();
		sb.append("Señor usuario bla bla... <br/>");
		sb.append("segunda linea <br/>");
		sb.append("mas lineas <br/>");
		sb.append("su contraseña es: " + password);
		int result = mailClient.correo(sb.toString(), destino, 
				"hyujra@asfi.gob.bo", "Contrseña ASFI Digital");
		return result;
	}
	
}
