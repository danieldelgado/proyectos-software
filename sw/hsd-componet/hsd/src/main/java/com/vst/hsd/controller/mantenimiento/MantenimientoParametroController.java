package com.vst.hsd.controller.mantenimiento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.hsd.service.mantenimiento.MantenimientoParametroService;


// TODO: Auto-generated Javadoc
/**
 * The Class MantenimientoParametroController.
 */
@Controller
public class MantenimientoParametroController {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroController.class);
	
	/** The mantenimiento parametro service. */
	@Autowired
	private MantenimientoParametroService mantenimientoParametroService;
	
	
	/**
	 * Gets the.
	 *
	 * @return the string
	 */
	@RequestMapping( value="mantenimiento/registrarParametro" , method = RequestMethod.GET)	
	public String get(){
		log.info("[ metodo : get - ingreso a mantenimientoParametro ]");
		System.out.println("#get html");
		
		
		
		return "mantenimiento/parametros/parametro";
	}	

	
}






