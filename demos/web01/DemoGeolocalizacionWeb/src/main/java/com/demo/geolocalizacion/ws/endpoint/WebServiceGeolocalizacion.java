package com.demo.geolocalizacion.ws.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
@Service("WebServiceGeolocalizacion")
@WebService(serviceName = "WebServiceGeolocalizacion")
public class WebServiceGeolocalizacion {
	//http://localhost:9998/WebServiceGeolocalizacion?wsdl	
	private static final Logger logger = LoggerFactory.getLogger(WebServiceGeolocalizacion.class);
	
	@WebMethod	
	public String sayHello(@WebParam(name="msj")  String msj) {
		logger.info(" msj: "+msj);
		return " respuesta msj: " + msj;
	}

	@WebMethod
	public Integer registrarGeolocalizacion(@WebParam(name="numero") String numero,@WebParam(name="latitud")  String latitud,
			@WebParam(name="longitud") String longitud) {
		logger.info(" numero: "+numero);
		logger.info(" latitud: "+latitud);
		logger.info(" longitud: "+longitud);
		
		
		
		return 0;
	}

}
