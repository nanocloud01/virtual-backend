package bo.gob.asfi.virtual.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.virtual.model.entities.Usuario;
import bo.gob.asfi.virtual.model.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarioRepository.findAll().forEach(usuarios ::add);
		return usuarios;
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}
