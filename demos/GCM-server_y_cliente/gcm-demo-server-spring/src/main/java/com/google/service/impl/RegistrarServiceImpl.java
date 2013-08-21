package com.google.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.bean.Usuario;
import com.google.dao.UsuarioDAO;
import com.google.service.RegistrarService;

@Service("RegistrarService")
public class RegistrarServiceImpl implements RegistrarService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Transactional
	public void guardarUsuairo(Usuario usuario) {
		usuarioDAO.guardar(usuario);		
	}

	

}
