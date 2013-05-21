package com.demo.geolocalizacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Constantes;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "principal")
public class UsuarioController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String principal(Model model) {
		logger.info("UsuarioController Ingreso al principal");				
		return "principal";
	}
	
	@RequestMapping( value="validarNumero" , method = RequestMethod.POST)
	public String validarNumero(Model model,String numero) {
		logger.info("UsuarioController validarNumero numero : "+numero);	
		int vlNum = usuarioService.validarUsuarioPorNumeroRegistrado(numero);
		switch (vlNum) {
		case Constantes.USUARIO_EXISTE:
			return "geolocalizacion";	
		case Constantes.USUARIO_NO_EXISTE:
			return "registrarNumero";				
		case Constantes.NO_CUMPLE_CON_FORMATO:{
			model.addAttribute("msjError", "El formato no es el correcto");
			return "redirect:/";			
			}
		}
		model.addAttribute("msjError", "Problema con el servidor");
		return "redirect:/";
	}
	
	
}
