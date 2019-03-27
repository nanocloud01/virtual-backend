package bo.gob.asfi.digital.modelfoo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.digital.modelfoo.entities.FooUsuario;
import bo.gob.asfi.digital.modelfoo.repositories.FooUsuarioRepository;

@Service
public class FooUsuarioService {
	
	@Autowired
	private FooUsuarioRepository fooUsuarioRepository;
	
	public List<FooUsuario> getAllUsuarios() {
		List<FooUsuario> usuarios = new ArrayList<>();
		fooUsuarioRepository.findAll().forEach(usuarios ::add);
		return usuarios;
	}

}
