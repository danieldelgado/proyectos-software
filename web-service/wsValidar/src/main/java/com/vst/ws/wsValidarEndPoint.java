package com.vst.ws;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Validador validarParametros(List<CamposValidar> lstCamposValidar){
		return wsValidadorService.validarObjetos(lstCamposValidar);		
		
	}
	
	@WebMethod
	public String msj(){
		return "";
	}
	
}
