package com.vst.controller.mantenimiento;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.dominio.Lista;
import com.vst.dominio.Parametro;
import com.vst.service.mantenimiento.MantenimientoParametroService;


@Controller
public class MantenimientoParametroController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroController.class);
	
	@Autowired
	private MantenimientoParametroService mantenimientoParametroService;
	
	
	@RequestMapping( value="mantenimiento/parametro" , method = RequestMethod.GET)	
	public String get(){
		log.info("[ metodo : get - ingreso a mantenimientoParametro ]");		
		return "mantenimiento/parametros/mantenimientoParametro";
	}	

	@RequestMapping( value="mantenimiento/parametro/nuevo" , method = RequestMethod.GET)	
	public String irParametroNuevo(Model model){
		log.info("[ metodo : get - ingreso a irPaginaNuevo ]");	
		List<Parametro> lstEstados = mantenimientoParametroService.obtenerEstados();
		List<Parametro> lstParametrosPadre = mantenimientoParametroService.obtenerParametrosPadre();
		model.addAttribute("lstEstados", lstEstados);
		model.addAttribute("lstParametrosPadre", lstParametrosPadre);		
		return "mantenimiento/parametros/parametro";
	}
	
	@RequestMapping( value="mantenimiento/parametro/editar/{param}" , method = RequestMethod.GET)	
	public String irParametroEditar(Model model,@PathVariable("param") int param){
		Parametro parametro  = mantenimientoParametroService.obtenerParametro(param);
		return "mantenimiento/parametros/parametro";
	}

	@RequestMapping( value="mantenimiento/parametro/guardar" , method = RequestMethod.POST)	
	public int irPaginaNuevo(Model model,Parametro parametro){
		int r = mantenimientoParametroService.guardarParametro(parametro);		
		return r;
	}
	
}
