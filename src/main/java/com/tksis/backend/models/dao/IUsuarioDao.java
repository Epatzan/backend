package com.tksis.backend.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.tksis.backend.models.entities.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, String> { 

}

