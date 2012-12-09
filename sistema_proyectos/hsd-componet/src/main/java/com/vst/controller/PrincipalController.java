package com.vst.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;
import com.vst.service.LoginService;
import com.vst.service.PrincipalService;
import com.vst.util.Constantes;
import com.vst.util.Util;


@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	private static final Logger log = LoggerFactory.getLogger(PrincipalController.class);
		
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PrincipalService principalService;
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request, HttpSession session  ,Model model) {
		log.info("[ metodo : get - ingreso a principal - buscar usuario en session]");	
		int i = loginService.buscarUsuarioLogueado(session);
		if(i == Constantes.USUARIO_DESLOGUEADO){
			log.info("[ metodo : get - Usuario no esta en session redirec a login]");	
			return "redirect:/login";			
		}else		
			return "principal";
	}	

	@RequestMapping( value="obtenerLista/{entidad}" , method = RequestMethod.GET)	
	public @ResponseBody Lista obtenerData(@PathVariable String entidad,HttpSession sesion){
		
		return null;
	}
	
	@RequestMapping(value="/obtenerDataLista/{entidad}")
	public @ResponseBody Map<String,Object> obtenerDataGrid(@PathVariable String entidad,Model model,HttpSession sesion,@RequestParam(required=false) String sidx,@RequestParam(required=false) String sord,@RequestParam(required=false) int page,@RequestParam(required=false) int rows,@RequestParam(required=false) boolean _search,@RequestParam(required=false) String searchField,@RequestParam(required=false) String searchOper,@RequestParam(required=false) String searchString){
//		log.info(" metodo : obtenerDataGrid -  obtener los datos del grid :"+entidad);
//		Usuario usuario=(Usuario) sesion.getAttribute(Constantes.SESION_USUARIO);
//		if(usuario != null){
//			Map<String,Object> tmp=principalService.obtenerData(usuario,entidad,sidx,sord,page,rows,_search,searchField,searchOper,searchString);
//			model.addAttribute("size",tmp.size());			
//			return tmp;
//		}
		return null;
	}

}
