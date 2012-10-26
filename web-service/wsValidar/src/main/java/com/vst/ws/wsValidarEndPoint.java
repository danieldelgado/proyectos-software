package com.vst.ws;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

@Service("wsValidarEndPoint")
@WebService(serviceName="ServicioValidar")
public class wsValidarEndPoint {

	public String msj(String msj){
		return "msj:"+msj ;
		
	}
	
	
}
