package com.vst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vst.dominio.Menu;
import com.vst.dominio.Perfil;
import com.vst.dominio.Usuario;

public interface LoginService {

	public Usuario iniciarSession(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request);

	public int buscarUsuarioLogueado(HttpSession session);

	public List<Perfil> obtenerPerfiles();

	public List<Menu> obtenerMenusPorPerfil(Usuario u);

	
}
