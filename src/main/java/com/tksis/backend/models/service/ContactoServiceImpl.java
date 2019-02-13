package com.tksis.backend.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tksis.backend.models.dao.IContactoDao;
import com.tksis.backend.models.entities.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService {
	
	@Autowired
	private IContactoDao contactoDao;

	@Override
	public List<Contacto> findAll() {
		// TODO Auto-generated method stub
		return (List<Contacto>) contactoDao.findAll();
	}
	

}
