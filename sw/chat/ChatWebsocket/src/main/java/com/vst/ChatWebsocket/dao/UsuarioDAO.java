package com.vst.ChatWebsocket.dao;

import com.vst.ChatWebsocket.Entitys.Usuario;
import com.vst.ChatWebsocket.util.IDAO;

public interface UsuarioDAO extends IDAO<Usuario> {

	Usuario buscarUsuario(Usuario usuario);
	Usuario buscarUsuario(String usuario);

}
