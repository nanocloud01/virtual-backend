package bo.gob.asfi.virtual.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.asfi.virtual.model.entiies.Usuario;
import bo.gob.asfi.virtual.model.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getAllUsuarios() {
		List<Usuario> abogados = new ArrayList<>();
		usuarioRepository.findAll().forEach(abogados ::add);
		return abogados;
	}
	
	public Usuario getUsuario(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

}
