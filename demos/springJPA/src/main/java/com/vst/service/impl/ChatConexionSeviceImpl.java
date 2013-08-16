package com.vst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Usuario;
import com.vst.service.ChatConexionSevice;


@Service("ChatConexionSevice")
public class ChatConexionSeviceImpl implements ChatConexionSevice {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	@Transactional
	@Override
	public void guardar(Usuario u) {
		Usuario uu = new Usuario("chat1", "chat1", "chat1", "chat1");
		usuarioDAO.guardar(uu);
		System.out.println(uu.getId());
		System.out.println(usuarioDAO.getTodos().size());		
	}

	
	
}
