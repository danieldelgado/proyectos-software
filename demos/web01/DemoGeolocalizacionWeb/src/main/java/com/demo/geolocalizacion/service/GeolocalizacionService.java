package com.demo.geolocalizacion.service;


public interface GeolocalizacionService {

	int registrarPuntoGeolocalizacion(boolean flagPuntoInicial, String numero, String latitud,
			String longitud);

}
