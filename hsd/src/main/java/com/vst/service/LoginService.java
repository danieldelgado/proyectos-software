package com.vst.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {

	public int buscarUsuario(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request);
	
}
