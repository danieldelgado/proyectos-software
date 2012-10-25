package com.vst.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.controller.LoginController;
import com.vst.dao.PerfilDAO;
import com.vst.dao.UsuarioDAO;
import com.vst.dominio.Perfil;
import com.vst.dominio.Usuario;
import com.vst.service.LoginService;
import com.vst.service.RegistrarHistorialService;
import com.vst.util.Constantes;

@Service("LoginSevice")
public class LoginServiceImpl implements LoginService {
	
	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private PerfilDAO perfilDAO;

	@Autowired
	private RegistrarHistorialService historialService;
	
	public int buscarUsuario(String usuario, String clave, Integer perfil, HttpSession session, HttpServletRequest request) {
		log.info("LoginSevice buscarUsuario "+ usuario + " ip:"+request.getRemoteAddr());
		historialService.guardarHistorial(this,"buscarUsuario",request);
		try {
			Usuario u = usuarioDAO.buscarUsuario(usuario, perfil);
			Perfil p = null;
			historialService.guardarObjetoHIstorial(" resultado buscarUsuario " , u );
			if (u != null) {
				if (u.getClave().equals(clave)) {
					p = perfilDAO.get(perfil);
					u.setPerfilLogueado(p);
					session.setAttribute(Constantes.SESION_USUARIO, u);
					log.info(" Usuario ingreso correctamente Usuario "+ usuario+" perfil:"+p.getNombre());
					historialService.guardarObjetoHIstorial(" registrado en session" , u );
					return Constantes.USUARIO_LOGEADO;
				}else{
					log.info(" Usuario clave incorrecta "+ usuario+" perfil:"+p.getNombre());
					historialService.guardarObjetoHIstorial(" remove en session" , u );
					session.removeAttribute(Constantes.SESION_USUARIO);
				}
			}else{
				log.info(" Usuario ingreso incorrectamente Usuario "+ usuario+" perfil:"+p.getNombre());
				session.removeAttribute(Constantes.SESION_USUARIO);
			}
		} catch (Exception e) {
			
		}
		return Constantes.ERROR_AL_LOGUEARSE;
	}

}
