package com.vst.hsd.controller;

import java.util.List;
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

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;
import com.vst.hsd.service.LoginService;
import com.vst.hsd.service.PrincipalService;
import com.vst.hsd.service.RegistrarHistorialService;
import com.vst.util.Constantes;

@Controller
@RequestMapping("principal")
public class PrincipalController {

	private static final Logger log = LoggerFactory.getLogger(PrincipalController.class);

//	@Autowired
//	private RegistrarHistorialService historialService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private PrincipalService principalService;

	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, HttpSession session, Model model) {
		log.info("[ metodo : get - ingreso a principal - buscar usuario en session]");
		Usuario u = (Usuario) session.getAttribute(Constantes.SESION_USUARIO);
		System.out.println("usuario en session");
		System.out.println(u);
		if (u == null) {
			log.info("Redireccion a login ip:" + request.getRemoteAddr());
//			historialService.registrarHistorial("Redireccion a login ip:" + request.getRemoteAddr());
			return "redirect:/login";
		} else {
			List<Menu> lstMenus = principalService.obtenerMenusPorPerfil((Usuario) session.getAttribute(Constantes.SESION_USUARIO));
			model.addAttribute("lstMenus", lstMenus);
			List<Boton> lstBotones = principalService.obtenerBotonesPorMenuDefault(lstMenus);
			model.addAttribute("lstBotones", lstBotones);
			System.out.println(lstBotones);
			log.info("Redireccion a principal ip:" + request.getRemoteAddr());
//			historialService.registrarHistorial("PrincipalController", "Usuario se dirige a principal  ip: " + request.getRemoteAddr(), u);
//			historialService.registrarHistorial("PrincipalController", "Usuario se dirige a principal  con la lista de menus", lstMenus);
			return "principal";
		}
	}

	@RequestMapping(value = "obtenerLista/{entidad}", method = RequestMethod.GET)
	public @ResponseBody 	Lista obtenerData(@PathVariable String entidad, HttpSession sesion) {
		log.info("obtenerData obtener @PathVariable  entidad : "+entidad);
		return principalService.obtenerListaEntidad(entidad, sesion);
	}

	@RequestMapping(value = "/obtenerDataLista/{entidad}")
	public @ResponseBody
	Map<String, Object> obtenerDataGrid(@PathVariable String entidad, Model model, HttpSession sesion, @RequestParam(required = false) String sidx, @RequestParam(required = false) String sord,
			@RequestParam(required = false) int page, @RequestParam(required = false) int rows, @RequestParam(required = false) boolean _search, @RequestParam(required = false) String searchField,
			@RequestParam(required = false) String searchOper, @RequestParam(required = false) String searchString) {
		log.info(" metodo : obtenerDataGrid -  obtener los datos del grid :" + entidad);
		Usuario usuario = (Usuario) sesion.getAttribute(Constantes.SESION_USUARIO);
		if (usuario != null) {
			Map<String, Object> tmp = principalService.obtenerData(usuario, entidad, sidx, sord, page, rows, _search, searchField, searchOper, searchString);
			model.addAttribute("size", tmp.size());
			log.info(" obtenerDataGrid -  tmp datos "+ tmp);
			log.info(" obtenerDataGrid -  tmp.size() : "+ tmp.size());
			return tmp;
		}
		return null;
	}

}
