package com.vst.hsd.controller.mantenimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.hsd.dominio.Parametro;


@Controller
public class MantenimientoPerfilController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoPerfilController.class);

	@RequestMapping(value = "mantenimiento/perfil", method = RequestMethod.GET)
	public String get() {
		return "mantenimiento/perfil/mantenimientoPerfil";
	}
	
	@RequestMapping(value = "	mantenimiento/editar/Perfil/{codigoFormulario}", method = RequestMethod.GET)
	public @ResponseBody Parametro editar(@PathVariable String codigoFormulario, Model model , Integer id) {		
		System.out.println(" editar :"+id);		
		return null;
	}
	
}
