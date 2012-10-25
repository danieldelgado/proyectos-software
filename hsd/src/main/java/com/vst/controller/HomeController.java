package com.vst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.dominio.Usuario;
import com.vst.service.LoginSevice;
import com.vst.service.MantenimientoUsuarioService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	LoginSevice loginSevice;
	
	@Autowired
	MantenimientoUsuarioService mantenimientoUsuarioService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)	
	//@Transactional
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String home() {
		logger.info("Welcome home! the client locale is ");	
		Usuario u = new Usuario();
		u.setNombre("dan");
		mantenimientoUsuarioService.guardar(u);		
		System.out.println("u:"+u.getId());
		System.out.println(loginSevice);	
		return "home";
	}
	
}
