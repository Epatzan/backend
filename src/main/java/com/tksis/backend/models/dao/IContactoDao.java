package com.tksis.backend.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.tksis.backend.models.entities.Contacto;

public interface IContactoDao extends CrudRepository<Contacto, Integer> { 

}
