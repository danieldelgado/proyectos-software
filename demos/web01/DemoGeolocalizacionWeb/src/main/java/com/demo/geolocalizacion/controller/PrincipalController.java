package com.demo.geolocalizacion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.geolocalizacion.service.PrincipalService;
import com.demo.geolocalizacion.util.Constantes;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "principal")
public class PrincipalController {

	private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);

	@Autowired
	private PrincipalService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String principal(Model model,HttpServletRequest httpServletRequest) {
		logger.info("UsuarioController Ingreso al principal");
		HttpSession httpSession = httpServletRequest.getSession();
		model.addAttribute("mensaje",httpSession.getAttribute("mensaje"));
		return "principal";
	}

	@RequestMapping(value = "validarNumero", method = RequestMethod.POST)
	public String validarNumero(Model model, String numero, HttpServletRequest httpServletRequest) {
		logger.info("UsuarioController validarNumero numero : " + numero);
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.setAttribute("mensaje", "");
		int vlNum = usuarioService.validarUsuarioPorNumeroRegistrado(numero);
		switch (vlNum) {
			case Constantes.USUARIO_EXISTE: {
				httpSession.setAttribute("numero", numero);
				return "redirect:/geolocalizacion/geolocalizacion";
			}
			case Constantes.USUARIO_NO_EXISTE: {
				httpSession.setAttribute("numero", numero);
				return "redirect:/geolocalizacion/registrarNumero";
			}
			case Constantes.NO_CUMPLE_CON_FORMATO: {
				httpSession.setAttribute("mensaje", "El formato no es el correcto");
				return "redirect:/";
			}
		}
		httpSession.setAttribute("mensaje", "Problema con el servidor");
		return "redirect:/";
	}

}
