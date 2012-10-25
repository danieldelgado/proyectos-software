package com.vst.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {
	
private static final Logger log = LoggerFactory.getLogger(LoginController.class);
		
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request,Model model) {
		log.info("Ingreso a LoginController - get");
		return "login/login";
	}
	
	
	
}
