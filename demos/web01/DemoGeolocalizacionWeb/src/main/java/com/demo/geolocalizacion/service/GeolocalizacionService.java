package com.demo.geolocalizacion.service;

import java.util.List;

import com.demo.geolocalizacion.dominio.Geolocalizacion;
import com.demo.geolocalizacion.dominio.PuntoGeolocalizacion;
import com.demo.geolocalizacion.dominio.Telefono;


public interface GeolocalizacionService {

	int registrarPuntoGeolocalizacion(boolean flagPuntoInicial, String numero, String latitud,
			String longitud);

	Telefono obtenerTelefono(String numero);

	List<Geolocalizacion> obtenerListaGeolocalizacionPorTelefono(
			Telefono telefono);

	List<PuntoGeolocalizacion> obtenerPuntosGeolocalizacion(Integer id);

}
