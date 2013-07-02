package com.vst.hsd.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.hsd.dao.PerfilDAO;
import com.vst.hsd.dao.UsuarioDAO;
import com.vst.hsd.dominio.Perfil;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.LoginService;

@Service("LoginSevice")
public class LoginServiceImpl implements LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PerfilDAO perfilDAO;

	public Usuario iniciarSession(String usuario, String clave, Integer perfil) {
		Usuario u = usuarioDAO.buscarUsuario(usuario, perfil);
		Perfil p = null;
		if (u != null) {
			if (u.getClave().equals(clave)) {
				p = perfilDAO.get(perfil);
				u.setPerfilLogueado(p);
				log.info("usuario logeado es :" + usuario + "  perfil : " + perfil);
				return u;
			} else {
				log.info("usuario clave incorrecta es :" + usuario + "  perfil : " + perfil);
				return null;
			}
		}
		log.info("usuario no encontrado es :" + usuario + "  perfil : " + perfil);
		return null;
	}

	public List<Perfil> obtenerPerfiles() {
		List<Perfil> lst = perfilDAO.obtenerTodosActivos();
		log.info(" perfiles activos count :" + lst.size());
		return lst;
	}

}
