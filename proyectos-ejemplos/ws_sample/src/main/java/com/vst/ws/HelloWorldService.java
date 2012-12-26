package com.vst.ws;

import javax.jws.WebService;

@WebService
public interface HelloWorldService {
	
	public String sayHello(String msj) ;
}
