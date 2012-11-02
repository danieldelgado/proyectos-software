package com.vst.service.impl;

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
		log.info("[ metodo:iniciarSession - usuario:"+usuario+" clave:"+clave+" perfil:"+perfil+" ip:"+request.getRemoteAddr()+" ]");
		historialService.registrarHistorial("LoginServiceImpl", "buscarUsuario",  "usuario:"+usuario+" clave:"+clave+" perfil:"+perfil, request);
		try {
						
			Usuario u = usuarioDAO.buscarUsuario(usuario, perfil);
			Perfil p = null;
			historialService.registrarHistorial("Usuario buscado :", u);
			if (u != null) {
				if (u.getClave().equals(clave)) {
					p = perfilDAO.get(perfil);
					u.setPerfilLogueado(p);
					historialService.registrarHistorial("Usuario y perfil logueado ", u,p);
					session.setAttribute(Constantes.SESION_USUARIO, u);
					return Constantes.USUARIO_LOGEADO;
				}else{
					historialService.registrarHistorial("Usuario y perfil incorrectos ", u,p);
					session.removeAttribute(Constantes.SESION_USUARIO);
				}
			}else{
				historialService.registrarHistorial("Usuario y perfil no encontrados ", u,p);
				session.removeAttribute(Constantes.SESION_USUARIO);
			}		
		} catch (Exception e) {
			
		}
		return Constantes.ERROR_AL_LOGUEARSE;
	}

}
