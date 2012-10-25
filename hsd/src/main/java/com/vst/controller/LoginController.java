package com.vst.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.service.LoginService;
import com.vst.util.Validate;

@Controller
@RequestMapping("login")
public class LoginController {
	
private static final Logger log = LoggerFactory.getLogger(LoginController.class);
		
	@Autowired
	private LoginService loginService;

	
	@RequestMapping(method = RequestMethod.GET)	
	public String get() {
		log.info("Ingreso a LoginController - get");
		return "login/login";
	}
	
	@RequestMapping( value="iniciarSession", method = RequestMethod.POST)	
	public String iniciarSession(String usuario,String clave,Integer perfil,HttpServletRequest request ,HttpSession session) {
		log.info("Ingreso a LoginController - iniciarSession usuario:"+usuario+" clave:"+clave+" perfil:"+perfil);
		Map<String,Object> objValidate = new HashMap<String,Object>();
		objValidate.put("usuario", usuario);
		objValidate.put("clave", clave);
		objValidate.put("perfil", perfil);		
		Validate v= new Validate(objValidate);		
		
		List<Integer> lv = v.obtenerRepuesta();		
		if(lv.get(0)>0){
			int l = loginService.buscarUsuario(usuario,clave,perfil,session,request);	
			
		}		
		return "redirect:/principal";
	}
	
	
}
