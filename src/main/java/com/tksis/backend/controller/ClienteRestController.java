package com.tksis.backend.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tksis.backend.models.entities.Contacto;
import com.tksis.backend.models.entities.Usuario;
import com.tksis.backend.models.service.IContactoService;
import com.tksis.backend.models.service.IUsuarioService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IContactoService contactoService;
	
	@GetMapping("/saludar")
	public String saludar(){
		return "Hola";
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> index(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuariosTotal")
	public com.tksis.backend.util.Response indexResponde(){
		
		return (new com.tksis.backend.util.Response(true, "Registros", usuarioService.findAll(), 0));
	}
	
	@GetMapping("/usuariosString")
	public String indexString() {
		return "{\"success\":true,\"msg\":\"Registros\",\"data\":[{\"usuario\":\"cgomez\",\"clave\":\"1234\",\"email\":\"claudiayamilegomez@gmail.com\",\"nombre\":\"Claudia Yamile Gomez Llanez\",\"contactos\":[{\"id\":24,\"apellido\":\"Angarita\",\"email\":\"elian@gmail.com\",\"nombre\":\"Elian\"},{\"id\":26,\"apellido\":\"deArco\",\"email\":\"juana@gmail.com\",\"nombre\":\"Juana\"},{\"id\":27,\"apellido\":\"Andres\",\"email\":\"hola@gmail.com\",\"nombre\":\"Hola\"},{\"id\":29,\"apellido\":\"Llanez\",\"email\":\"crangarita@gmail.com\",\"nombre\":\"Claudia Yamile\"}]},{\"usuario\":\"crangarita\",\"clave\":\"1234\",\"email\":\"crangarita@gmail.com\",\"nombre\":\"Carlos Rene Angarita Sanguino\",\"contactos\":[{\"id\":17,\"apellido\":\"\",\"email\":\"margoll@gmail.com\",\"nombre\":\"Maribel Gomez\"},{\"id\":18,\"apellido\":\"Dia\",\"email\":\"jorge@dddd.com\",\"nombre\":\"Jorge\"},{\"id\":19,\"apellido\":\"UFPS\",\"email\":\"carlosreneas@ufps.edu.co\",\"nombre\":\"Carlos Rene\"},{\"id\":22,\"apellido\":\"Angarita Sanguino\",\"email\":\"yancarlo1206@gmail.com\",\"nombre\":\"Yan Carlo\"},{\"id\":33,\"apellido\":\"z\",\"email\":\"crangarita@gmail.com\",\"nombre\":\"y\"}]}],\"total\":0}";
	}
	
	@GetMapping("/usuariosJSON")
	public String indexStringJ() {
		return "{success:true, msg:\"Registros\"}";
	}
	
	@GetMapping("/contactos")
	public List<Contacto> indexContactos(){
		return contactoService.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Usuario show(@PathVariable String id) {
		return this.usuarioService.findById(id);
	}

	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@RequestBody Usuario usuario) {
		this.usuarioService.save(usuario);
		return usuario;
	}

	@PutMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable String id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		currentUsuario.setNombre(usuario.getNombre());
		currentUsuario.setEmail(usuario.getEmail());
		currentUsuario.setClave(usuario.getClave());
		this.usuarioService.save(currentUsuario);
		return currentUsuario;
	}

	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		Usuario currentUsuario = this.usuarioService.findById(id);
		this.usuarioService.delete(currentUsuario);
	}
	


}
