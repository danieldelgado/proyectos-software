package com.vst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);
		
	@RequestMapping(method = RequestMethod.GET)	
	public String home() {		
		return "home";
	}
	
}
