package com.tksis.backend.models.service;

import java.util.List;

import com.tksis.backend.models.entities.Contacto;

public interface IContactoService {
	
	public List<Contacto> findAll();
}
