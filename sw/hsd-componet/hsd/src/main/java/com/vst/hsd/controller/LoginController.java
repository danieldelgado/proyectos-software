package com.vst.hsd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.hsd.dominio.Perfil;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.LoginService;
import com.vst.util.Constantes;
import com.vst.util.Util;

@Controller
@RequestMapping("login")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		log.info(" metodo get - ingreso  a login ");
		List<Perfil> lst = loginService.obtenerPerfiles();
		model.addAttribute("perfiles", lst);
		return "login/login";
	}
	
	@RequestMapping(value = "iniciarSession", method = RequestMethod.POST)
	public String iniciarSession(String usuario, String clave, Integer perfil, HttpServletRequest request, HttpSession session, Model model) {
		log.info(" metodo iniciarSession -   dato usuario : " + usuario + "  clave : " + clave + " perfil : " + perfil + "  ip :  " + request.getRemoteAddr());
		Usuario u = loginService.iniciarSession(usuario, clave, perfil);
		if (Util.isNotNull(u)) {
			log.info(" metodo iniciarSession  - ingreso correcto se redirecciona   a principal ");
			session.setAttribute(Constantes.SESION_USUARIO, u);
			return "redirect:/principal";
		}
		log.info(" metodo iniciarSession  - ingreso incorrecto se redirecciona   a login ");
		session.removeAttribute(Constantes.SESION_USUARIO);
		return "redirect:/login";
	}

	@RequestMapping(value = "terminarSession", method = RequestMethod.GET)
	public String terminarSession(HttpSession session, Model model) {
		try {
			session.setAttribute(Constantes.SESION_USUARIO, null);
		} catch (Exception e) {
			log.info(" ocurrio un error al terminar la sesion del usuario ");
		}
		log.info(" terminar la session del usuario ");
		return "redirect:/login";
	}

}
