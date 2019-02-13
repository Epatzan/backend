package com.tksis.backend.models.service;

import java.util.List;

import com.tksis.backend.models.entities.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findById(String id);
	
	public void delete(Usuario usuario);

}

