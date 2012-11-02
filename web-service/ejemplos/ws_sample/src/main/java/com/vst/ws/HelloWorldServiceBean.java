package com.vst.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.vst.ws.HelloWorldService")
public class HelloWorldServiceBean implements HelloWorldService {

	@WebMethod
	public String sayHello(String msj) {
		System.out.println("Hello World!!!");
		return " respuesta : " + msj;
	}

}
