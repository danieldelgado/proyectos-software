package com.vst.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface LoginService {

	public int iniciarSession(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request);
	
}
