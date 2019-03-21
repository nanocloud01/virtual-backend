package bo.gob.asfi.virtual.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.asfi.virtual.model.entities.Usuario;
import bo.gob.asfi.virtual.model.services.UsuarioService;
import bo.gob.asfi.virtual.modelfoo.entities.FooUsuario;
import bo.gob.asfi.virtual.modelfoo.services.FooUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FooUsuarioService fooUsuarioService;
	
	@RequestMapping("/usuarios1")
	public List<Usuario> getUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@RequestMapping("/usuarios")
	public List<FooUsuario> getUsuarios2() {
		return fooUsuarioService.getAllUsuarios();
	}
		
	
	@RequestMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return usuarioService.getUsuario(id);
	}

}
