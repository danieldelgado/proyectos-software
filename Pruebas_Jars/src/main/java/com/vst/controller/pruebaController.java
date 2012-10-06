package com.vst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.PersonaDAO;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Persona;
import com.vst.dominio.Usuario;


@Controller
public class pruebaController {

	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public String prueba ( String pruebaTXT ){
		Usuario usuario = new Usuario();
		usuario.setNombre("Daniel");
		usuario.setApellidos(pruebaTXT);
		usuarioDAO.guardar(usuario);		
		return "prueba concreta";
	}
	
	
}
