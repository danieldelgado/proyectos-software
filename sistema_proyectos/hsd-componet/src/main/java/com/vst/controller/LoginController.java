package com.vst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.service.LoginService;
import com.vst.util.Constantes;

@Controller
@RequestMapping("login")
public class LoginController {
	
private static final Logger log = LoggerFactory.getLogger(LoginController.class);
		
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request,Model model) {
		log.info("[ metodo : get - ingreso a login ]");			
		model.addAttribute("perfiles", loginService.obtenerPerfiles());	
		return "login/login";
	}
	
	@RequestMapping( value="iniciarSession", method = RequestMethod.POST)	
	public String iniciarSession(String usuario,String clave,Integer perfil,HttpServletRequest request ,HttpSession session) {
		log.info("[  metodo:iniciarSession - usuario:"+usuario+" clave:"+clave+" perfil:"+perfil+" - validar usuario ingresado ]");
		int l = loginService.iniciarSession(usuario, clave, perfil, session, request);
		if(l==Constantes.USUARIO_LOGEADO){
			return "redirect:/principal";		
		}
		return "redirect:/login";		
	}
	
	@RequestMapping(value="principal",method = RequestMethod.GET)	
	public String principal(HttpServletRequest request,Model model) {	
		return "principal";
	}
	
}
