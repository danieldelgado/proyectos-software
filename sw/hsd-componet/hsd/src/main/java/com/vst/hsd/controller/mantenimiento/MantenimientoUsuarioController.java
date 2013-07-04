package com.vst.hsd.controller.mantenimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.hsd.dominio.Parametro;

@Controller
public class MantenimientoUsuarioController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoUsuarioController.class);

	@RequestMapping(value = "mantenimiento/usuario", method = RequestMethod.GET)
	public String get() {
		log.info("[ metodo : get - ingreso a mantenimientoParametro ]");
		return "mantenimiento/usuario/mantenimientoUsuario";
	}

	@RequestMapping(value = "	mantenimiento/editar/Usuario", method = RequestMethod.GET)
	public @ResponseBody Parametro editar(Model model , Integer id) {		
		System.out.println(" editar :"+id);		
		return null;
	}
	
}
