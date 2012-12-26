package com.vst.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.dao.impl.ParametroDAOImpl;
import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.MantenimientoParametroService;
import com.vst.ws.service.WSValidadorService;


@WebService
public class wsValidarEndPoint {

	private static Logger log = LoggerFactory.getLogger(wsValidarEndPoint.class);
	
	@Autowired
	private WSValidadorService wsValidadorService;
		
	@Autowired
	private MantenimientoParametroService mantenimientoParametroService;
	
	@WebMethod
	public Validador validarParametros( @WebParam(name="lstCamposValidar") List<CamposValidar> lstCamposValidar){
		log.debug("[ metodo: validarParametros - lstCamposValidar: " + Util.getJson(lstCamposValidar) + "  ]");
		Validador v = wsValidadorService.validarObjetos(lstCamposValidar);	
		log.debug("[ metodo: validarParametros - respuesta Validador: " + Util.getJson(v) + "  ]");
		return v;			
	}
	
	@WebMethod
	public String msj(@WebParam(name="msjPrueba") String msjPrueba){
		System.out.println(" mensaje de prueba es correcta ");
		return "msjPrueba correcto!  : "+msjPrueba;
	}
	
	@WebMethod
	public String parametros(@WebParam(name="registrar") Boolean registrar){
		if(registrar){
			mantenimientoParametroService.registrarParametrosIniciales();
		}
		return "registrar:"+registrar;		
	}
	
	
}
