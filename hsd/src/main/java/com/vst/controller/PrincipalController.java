package com.vst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vst.util.Constantes;
import com.vst.util.Util;
import com.vst.ws.CamposValidar;
import com.vst.ws.ServicioValidar;
import com.vst.ws.ServicioValidarLocator;
import com.vst.ws.Validador;
import com.vst.ws.WsValidarEndPointProxy;


@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	private static final Logger log = LoggerFactory.getLogger(PrincipalController.class);
	
	@RequestMapping(method = RequestMethod.GET)	
	public String get(HttpServletRequest request,Model model) throws ServiceException {
		log.info("Ingreso a PrincipalController - get");
		
		WsValidarEndPointProxy ws = new WsValidarEndPointProxy();
		CamposValidar[] lstCamposValidar = new CamposValidar[1];
		try {
			lstCamposValidar[0] = new CamposValidar();
			lstCamposValidar[0].setNombreCampo(Constantes.CAMPO_LOGIN_USUARIO);
			lstCamposValidar[0].setCadena("daniel");
			
			ServicioValidarLocator locator = new ServicioValidarLocator();
			ServicioValidar service = null;
			service = locator;
			
			
			Validador v = ws.validarParametros(lstCamposValidar);
			System.out.println(Util.getJson(v));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "principal";
	}
	
}
