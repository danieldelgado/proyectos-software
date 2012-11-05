package com.vst.controller.mantenimiento;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.dominio.Lista;
import com.vst.dominio.Parametro;
import com.vst.service.mantenimiento.MantenimientoParametroService;


@Controller
public class MantenimientoParametroController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroController.class);
	
	
	@RequestMapping( value="mantenimiento/parametro" , method = RequestMethod.GET)	
	public String get(){
		log.info("[ metodo : get - ingreso a mantenimientoParametro ]");		
		return "mantenimiento/parametros/mantenimientoParametro";
	}
	
	
	
}
