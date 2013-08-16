package com.vst.dao;

import com.vst.dominio.Usuario;
import com.vst.util.IDAO;

public interface UsuarioDAO extends IDAO<Usuario> {

	Usuario buscarUsuario(Usuario usuario);
	Usuario buscarUsuario(String usuario);

}
