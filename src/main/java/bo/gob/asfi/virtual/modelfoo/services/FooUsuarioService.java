package bo.gob.asfi.virtual.modelfoo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.virtual.modelfoo.entities.FooUsuario;
import bo.gob.asfi.virtual.modelfoo.repositories.FooUsuarioRepository;

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
