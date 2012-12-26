package com.vst.hsd.dao;

import com.vst.hsd.dominio.Usuario;
import com.vst.util.IDAO;





public interface UsuarioDAO extends IDAO<Usuario> {

	Usuario buscarUsuario(String usuario, Integer perfil);


}
