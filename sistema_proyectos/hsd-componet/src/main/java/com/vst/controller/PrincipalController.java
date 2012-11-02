package com.vst.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.ws.WsValidarEndPointProxy;


@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	private static final Logger log = LoggerFactory.getLogger(PrincipalController.class);
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request,Model model) {
		log.info("[ metodo : get - ingreso a principal ]");	
		
		try {
			
			WsValidarEndPointProxy ws = new WsValidarEndPointProxy();
			System.out.println(ws.msj("mesnaje enviado haber q resivo"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "principal";
	}
	
}
