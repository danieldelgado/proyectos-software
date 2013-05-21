package com.demo.geolocalizacion.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.GeolocalizacionService;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Constantes;

@Controller
@RequestMapping(value = "geolocalizacion")
public class GeolocalizacionController {

	private static final Logger logger = LoggerFactory.getLogger(GeolocalizacionController.class);
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private GeolocalizacionService geolocalizacionService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String geolocalizacion(Model model,HttpServletRequest httpServletRequest) {
		logger.info("GeolocalizacionController Ingreso al geolocalizacion");		
		return "geolocalizacion";
	}
	
	@RequestMapping(value = "registrarNumero", method = RequestMethod.GET)
	public String registrarNumero(HttpServletRequest httpServletRequest , Telefono telefono) {		
		logger.info("GeolocalizacionController Ingreso al registrarNumero");		
		return "registrarNumero";
	}
	
	@RequestMapping(value = "registrarUsuarioTelefono", method = RequestMethod.POST)
	public String registrarUsuarioTelefono(HttpServletRequest httpServletRequest , Telefono telefono,Model model) {			
		logger.info("GeolocalizacionController Ingreso al registrarUsuarioTelefono");	
		HttpSession httpSession = httpServletRequest.getSession();
		httpSession.removeAttribute("mensaje");		
		Map<String, Object> rst = usuarioService.registrarUsuario_Telefono(telefono);
		Integer resgistr = Integer.parseInt(String.valueOf(rst.get("registro")));
		if(resgistr == Constantes.REGISTRADO){
			model.addAttribute("mensaje", "Se registro usuario con exito.");	
		}else
		if(resgistr == Constantes.NO_REGISTRADO){
			model.addAttribute("mensaje", "No se registro el usuario, el numero ya existe");			
		}else			
		if(resgistr == Constantes.USUARIO_NO_EXISTE){
			model.addAttribute("mensaje", " Ningun dato a sido ingresado ");	
		}else
		if(resgistr == Constantes.NO_CUMPLE_CON_FORMATO){
			model.addAttribute("mensaje", "Los datos ingresados no son correctos");	
			model.addAttribute("rst", rst);	
		}else
		if(resgistr == Constantes.ERROR_SERVER){
			model.addAttribute("mensaje", "Error en el servidor");	
		}		
		return "registrarNumero";
	}
	
	
	
}
