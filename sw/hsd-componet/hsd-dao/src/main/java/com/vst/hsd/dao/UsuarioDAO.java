package com.vst.hsd.dao;

import com.vst.hsd.dominio.Usuario;
import com.vst.util.IDAO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioDAO.
 */
public interface UsuarioDAO extends IDAO<Usuario> {

	/**
	 * Buscar usuario.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param perfil
	 *            the perfil
	 * @return the usuario
	 */
	Usuario buscarUsuario(String usuario, Integer perfil);

}
