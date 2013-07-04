package com.vst.hsd.controller.mantenimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.hsd.dominio.Parametro;

// TODO: Auto-generated Javadoc
/**
 * The Class MantenimientoMenuController.
 */
@Controller
public class MantenimientoMenuController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoMenuController.class);

	@RequestMapping(value = "mantenimiento/menu", method = RequestMethod.GET)
	public String get() {
		return "mantenimiento/menu/mantenimientoMenu";
	}
	
	@RequestMapping(value = "	mantenimiento/editar/Menu", method = RequestMethod.GET)
	public @ResponseBody Parametro editar(Model model , Integer id) {		
		System.out.println(" editar :"+id);		
		return null;
	}

}
