package com.vst.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.util.Util;
import com.vst.validar.CamposValidar;
import com.vst.validar.Validador;
import com.vst.ws.service.WSValidadorService;
//http://localhost:9998/ServicioValidar?wsdl
@Service("wsValidarEndPoint")
@WebService(serviceName="ServicioValidar")
public class wsValidarEndPoint {

	@Autowired
	private WSValidadorService wsValidadorService;
	
	@WebMethod
	public Validador validarParametros( @WebParam(name="lstCamposValidar") List<CamposValidar> lstCamposValidar){
		System.out.println(Util.getJson(lstCamposValidar));
		return null;//wsValidadorService.validarObjetos(lstCamposValidar);				
	}
	
	@WebMethod
	public String msj(@WebParam(name="msjPrueba") String msjPrueba){
		return "msjPrueba:"+msjPrueba;
	}
	
}
