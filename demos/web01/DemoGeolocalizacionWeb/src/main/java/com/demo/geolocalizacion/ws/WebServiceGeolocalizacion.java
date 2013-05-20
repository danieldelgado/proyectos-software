package com.demo.geolocalizacion.ws;

import javax.jws.WebService;

@WebService
public interface WebServiceGeolocalizacion {
	public String sayHello(String msj) ;	
	public Integer registrarGeolocalizacion(String numero,String latitud , String longitud) ;
}
