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

import com.vst.dao.PerfilDAO;
import com.vst.dao.UsuarioDAO;
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

	public int iniciarSession(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request) {
		log.info("[ metodo:iniciarSession - usuario:" + usuario + " clave:" + clave + " perfil:" + perfil + " ip:" + request.getRemoteAddr() + " ]");
		historialService.registrarHistorial("LoginServiceImpl", "buscarUsuario", "usuario:" + usuario + " clave:" + clave + " perfil:" + perfil, request);
		Validador v=ServicioWebValidacion.obtenerValidadorServiceLogin(usuario, clave, perfil);
		if(v!=null){
			if (v.getRespuesta() == Constantes.RESPUESTA_CORRECTA) {
				Usuario u = usuarioDAO.buscarUsuario(usuario, perfil);
				Perfil p = null;
				historialService.registrarHistorial("Usuario buscado :", u);
				if (u != null) {
					if (u.getClave().equals(clave)) {
						p = perfilDAO.get(perfil);
						u.setPerfilLogueado(p);
						historialService.registrarHistorial("Usuario y perfil logueado ", u, p);
						session.setAttribute(Constantes.SESION_USUARIO, u);
						return Constantes.USUARIO_LOGEADO;
					} else {
						historialService.registrarHistorial("Usuario y perfil incorrectos ", u, p);
						session.removeAttribute(Constantes.SESION_USUARIO);
					}
				} else {
					historialService.registrarHistorial("Usuario y perfil no encontrados ", u, p);
					session.removeAttribute(Constantes.SESION_USUARIO);
				}
			}
			return Constantes.ERROR_SERVICIO_WEB;
		}		
		return Constantes.ERROR_AL_LOGUEARSE;
	}

	// @Transactional
	public int buscarUsuarioLogueado(HttpSession session) {
		log.info("[ metodo:buscarUsuarioLogueado - buscar el usuario en session ]");
		Usuario u = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);
		// System.out.println("insert usuario y perfil");
		// temp();
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

}
