package com.demo.geolocalizacion.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.demo.geolocalizacion.ws.WebServiceGeolocalizacion;

@WebService(endpointInterface = "com.demo.geolocalizacion.ws.WebServiceGeolocalizacion")
public class WebServiceGeolocalizacionImpl implements WebServiceGeolocalizacion {

	@WebMethod
	public String sayHello(String msj) {
		System.out.println("Hello World!!!");
		return " respuesta msj: " + msj;
	}

	@WebMethod
	public Integer registrarGeolocalizacion(String numero, String latitud,
			String longitud) {
		
		return null;
	}

}
