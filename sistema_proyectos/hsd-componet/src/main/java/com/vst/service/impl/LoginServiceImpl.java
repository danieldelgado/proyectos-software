package com.vst.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.PerfilDAO;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Menu;
import com.vst.dominio.Perfil;
import com.vst.dominio.Usuario;
import com.vst.service.LoginService;
import com.vst.service.RegistrarHistorialService;
import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.ws.Validador;
import com.vst.ws.service.ServicioWebValidacion;

@Service("LoginSevice")
public class LoginServiceImpl implements LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PerfilDAO perfilDAO;

	@Autowired
	private RegistrarHistorialService historialService;

	public Usuario iniciarSession(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request) {
		Validador v=ServicioWebValidacion.obtenerValidadorServiceLogin(usuario, clave, perfil);
		if(v!=null){
			if (v.getRespuesta() == Constantes.RESPUESTA_CORRECTA) {
				Usuario u = usuarioDAO.buscarUsuario(usuario, perfil);		
				System.out.println(u);
				Perfil p = null;
				
//				u=new Usuario();
//				u.setId(1);
//				u.setNombre("admin");
//				u.setLogin("admin");
//				u.setClave("123456");
								
				if (u != null) {
					if (u.getClave().equals(clave)) {
						p = perfilDAO.get(perfil);
						
//						p=new Perfil();
//						p.setId(1);
//						p.setNombre("Administrador");
//						p.setEstado(Constantes.ACTIVO);
						
						
						u.setPerfilLogueado(p);
						session.setAttribute(Constantes.SESION_USUARIO, u);
						return u;
					} else {
						session.removeAttribute(Constantes.SESION_USUARIO);
					}
				}
			}
			return null;
		}		
		return null;
	}

	//@Transactional
	public int buscarUsuarioLogueado(HttpSession session) {
		log.info("[ metodo:buscarUsuarioLogueado - buscar el usuario en session ]");
		Usuario u = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);
		//System.out.println("insert usuario y perfil");
		 //temp();
		System.out.println(u);
		if (u != null) {
			return Constantes.USUARIO_LOGEADO;
		} else
			return Constantes.USUARIO_DESLOGUEADO;
	}

	@SuppressWarnings("unused")
	private void temp() {
		Perfil p = new Perfil();
		p.setCodigo(Util.getCodigo(p));
		p.setDescripcion("perfil del administrador");
		p.setEstado(Constantes.ACTIVO);
		p.setNombre("ADMINISTRADOR");
		p.setActivo(true);
		p.setFechaActualizacion(new Date());
		p.setFechaCreacion(new Date());
		perfilDAO.guardar(p);

		List<Perfil> lstP = new ArrayList<Perfil>();
		lstP.add(p);

		Usuario u = new Usuario();
		u.setActivo(true);
		u.setApellidos("admin");
		u.setClave("123456");
		u.setCodigo(Util.getCodigo(u));
		u.setEstado(Constantes.ACTIVO);
		u.setEstadoCivil(1);
		u.setFechaActualizacion(new Date());
		u.setFechaCreacion(new Date());
		u.setFechaNacimiento(new Date());
		u.setLogin("admin1");
		u.setNombre("admin1");
		u.setNumero_documento("123456789");
		u.setPerfiles(lstP);
		u.setTipo_documento(1);
		usuarioDAO.guardar(u);

	}

	public List<Perfil> obtenerPerfiles() {		
		return perfilDAO.obtenerTodosActivos();				
	}

	public List<Menu> obtenerMenusPorPerfil(Usuario u) {
		List<Menu> ms=new ArrayList<Menu>();
		Menu m = new Menu();
		m.setId(1);
		m.setNombre("Mantenimiento");
		m.setUrl(null);
		m.setTipo("interno");
		m.setOrden(0);
		m.setFunction(null);
		ms.add(m);
		
		List<Menu> mss=new ArrayList<Menu>();
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

	public int terminarSession(HttpSession session) {
		try {
			session.setAttribute(Constantes.SESION_USUARIO, null);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
