package com.tksis.backend.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tksis.backend.models.dao.IUsuarioDao;
import com.tksis.backend.models.entities.Usuario;
import com.tksis.backend.models.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(String id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);

	}

}
