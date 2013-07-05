package com.vst.hsd.controller.mantenimiento;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Formulario;
import com.vst.hsd.dominio.Parametro;
import com.vst.hsd.service.mantenimiento.MantenimientoParametroService;


@Controller
public class MantenimientoParametroController {

	private static final Logger log = LoggerFactory.getLogger(MantenimientoParametroController.class);

	@Autowired
	private MantenimientoParametroService mantenimientoParametroService;
	
	@RequestMapping(value = "mantenimiento/registrarParametro/{codigoFormulario}", method = RequestMethod.GET)
	public String get(@PathVariable String codigoFormulario, Integer rand, Model model) {
		log.info("Codigo Fomulario :"+codigoFormulario + " rand:"+rand);
		List<Boton> lstBotones = mantenimientoParametroService.obtenerBotonesPorFormulario(codigoFormulario);
		Formulario formulario = mantenimientoParametroService.obtenerFormulario(codigoFormulario);
		model.addAttribute("formulario", formulario);
		model.addAttribute("codigoFormulario", codigoFormulario);
		model.addAttribute("rand", rand);
		model.addAttribute("lstBotones", lstBotones);				
		return "mantenimiento/parametros/parametro";
	}


	@RequestMapping(value = "valacion/parametros/{codigoFormulario}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> validarFormulario(@PathVariable String codigoFormulario,Model model , Parametro parametro) {
		Map<String, Object> ms = null;
		log.info("Codigo Fomulario :"+codigoFormulario);		
		return ms;
	}
	
	@RequestMapping(value = "mantenimiento/editar/Parametro/{codigoFormulario}", method = RequestMethod.GET)
	public String editar(@PathVariable String codigoFormulario,Model model , Integer id) {		
		Parametro parametro = mantenimientoParametroService.obtenerParametro(id);
		Formulario formulario = mantenimientoParametroService.obtenerFormulario(codigoFormulario);
		List<Boton> lstBotones = mantenimientoParametroService.obtenerBotonesPorFormulario(formulario.getCodigo());
		model.addAttribute("codigoFormulario", codigoFormulario);	
		model.addAttribute("formulario", formulario);	
		model.addAttribute("rand", id);		
		model.addAttribute("parametro", parametro);	
		model.addAttribute("lstBotones", lstBotones);
		return "mantenimiento/parametros/parametro";
	}

	@RequestMapping(value = "mantenimiento/guardarParametro", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> guardar(Model model , Parametro parametro) {
		Map<String, Object> ms = null;
		
		
		
		return ms;
	}
	
	
	
	
}
