package com.google.dao;

import com.google.bean.Usuario;
import com.google.gcm.util.IDAO;

public interface UsuarioDAO extends IDAO<Usuario> {

	Usuario buscarUsuario(Usuario usuario);
	Usuario buscarUsuario(String usuario);
//	boolean buscarUsuarioRegIdDevie(String regId);
//	Usuario buscarUsuarioPorDevie(String regId);
	Usuario existeUsuarioPorEmail(String email);

}
