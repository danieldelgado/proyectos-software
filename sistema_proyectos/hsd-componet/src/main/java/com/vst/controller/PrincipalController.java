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
@RequestMapping("principal")
public class PrincipalController {
	
	private static final Logger log = LoggerFactory.getLogger(PrincipalController.class);
		
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request, HttpSession session  ,Model model) {
		log.info("[ metodo : get - ingreso a principal - buscar usuario en session]");	
		int i = loginService.buscarUsuarioLogueado(session);
		if(i == Constantes.USUARIO_DESLOGUEADO){
			log.info("[ metodo : get - Usuario no esta en session redirec a login]");	
			return "redirect:/login";			
		}else		
			return "principal";
	}
	
}
