package com.vst.hsd.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Perfil;
import com.vst.hsd.dominio.Usuario;

public interface LoginService {

	public Usuario iniciarSession(String usuario, String clave, Integer perfil  );

	public List<Perfil> obtenerPerfiles();
	
}
