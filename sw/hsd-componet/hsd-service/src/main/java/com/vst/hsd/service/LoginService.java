package com.vst.hsd.service;

import java.util.List;

import com.vst.hsd.dominio.Perfil;
import com.vst.hsd.dominio.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginService.
 */
public interface LoginService {

	/**
	 * Iniciar session.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param clave
	 *            the clave
	 * @param perfil
	 *            the perfil
	 * @return the usuario
	 */
	public Usuario iniciarSession(String usuario, String clave, Integer perfil);

	/**
	 * Obtener perfiles.
	 * 
	 * @return the list
	 */
	public List<Perfil> obtenerPerfiles();

}
