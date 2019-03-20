package bo.gob.asfi.virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.virtual.model.entity.Usuario;
import bo.gob.asfi.virtual.model.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@RequestMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioService.getUsuario(id);
	}

}
