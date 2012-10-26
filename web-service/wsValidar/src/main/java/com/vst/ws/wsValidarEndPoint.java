package com.vst.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Service;
//http://localhost:9998/ServicioValidar?wsdl
@Service("wsValidarEndPoint")
@WebService(serviceName="ServicioValidar")
public class wsValidarEndPoint {


	@WebMethod
	public String msj(String msj){
		return "msj:"+msj ;
		
	}
	
	
}
