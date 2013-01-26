package com.vst.hsd.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.hsd.dao.PerfilDAO;
import com.vst.hsd.dao.UsuarioDAO;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Perfil;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.LoginService;
import com.vst.util.Constantes;

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

	public List<Menu> obtenerMenusPorPerfil(Usuario u) {
		List<Menu> ms = new ArrayList<Menu>();
		Menu m = new Menu();
		m.setId(1);
		m.setNombre("Mantenimiento");
		m.setUrl(null);
		m.setTipo("interno");
		m.setOrden(0);
		m.setFunction(null);
		ms.add(m);

		List<Menu> mss = new ArrayList<Menu>();
		Menu mm = new Menu();
		mm.setId(1);
		mm.setNombre("Parametro");
		mm.setUrl("Parametro");
		mm.setTipo("interno");
		mm.setOrden(0);
		mm.setFunction(null);
		mss.add(mm);

		Menu mm2 = new Menu();
		mm2.setId(1);
		mm2.setNombre("Perfil");
		mm2.setUrl("Perfil");
		mm2.setTipo("interno");
		mm2.setOrden(0);
		mm2.setFunction(null);
		mss.add(mm2);

		Menu mm3 = new Menu();
		mm3.setId(1);
		mm3.setNombre("Lista");
		mm3.setUrl("Lista");
		mm3.setTipo("interno");
		mm3.setOrden(0);
		mm3.setFunction(null);
		mss.add(mm3);

		Menu mm4 = new Menu();
		mm4.setId(1);
		mm4.setNombre("Columna");
		mm4.setUrl("Columna");
		mm4.setTipo("interno");
		mm4.setOrden(0);
		mm4.setFunction(null);
		mss.add(mm4);

		m.setMenus(mss);

		return ms;
	}

	
}
