package com.vst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vst.dominio.Perfil;

public interface LoginService {

	public int iniciarSession(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request);

	public int buscarUsuarioLogueado(HttpSession session);

	public List<Perfil> obtenerPerfiles();

	
}
