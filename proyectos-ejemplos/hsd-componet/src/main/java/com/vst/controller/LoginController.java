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

import com.vst.dominio.Usuario;
import com.vst.service.LoginService;
import com.vst.util.Util;

@Controller
@RequestMapping("login")
public class LoginController {
	
private static final Logger log = LoggerFactory.getLogger(LoginController.class);
		
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request,Model model) {
		model.addAttribute("perfiles", loginService.obtenerPerfiles());		
		return "login/login";
	}
	
	@RequestMapping( value="iniciarSession", method = RequestMethod.POST)	
	public String iniciarSession(String usuario,String clave,Integer perfil,HttpServletRequest request ,HttpSession session,Model model) {
		Usuario u = loginService.iniciarSession(usuario, clave, perfil, session, request);
		if(Util.isNotNull(u)){
			return "redirect:/principal";		
		}
		return "redirect:/login";		
	}
	
	@RequestMapping( value="terminarSession", method = RequestMethod.GET)	
	public String terminarSession(HttpSession session,Model model) {
		int i = loginService.terminarSession(session);	
		return "redirect:/login";		
	}
	
	
	
//	@RequestMapping(value="principal",method = RequestMethod.GET)	
//	public String principal(HttpServletRequest request,Model model) {	
//		return "principal";
//	}
	
}
