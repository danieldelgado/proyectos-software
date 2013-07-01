package com.vst.hsd.controller.mantenimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class MantenimientoUsuarioController.
 */
@Controller
public class MantenimientoUsuarioController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(MantenimientoUsuarioController.class);

	/**
	 * Gets the.
	 * 
	 * @return the string
	 */
	@RequestMapping(value = "mantenimiento/usuario", method = RequestMethod.GET)
	public String get() {
		log.info("[ metodo : get - ingreso a mantenimientoParametro ]");
		return "mantenimiento/usuario/mantenimientoUsuario";
	}

}
