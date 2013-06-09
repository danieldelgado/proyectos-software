package com.demo.geolocalizacion.dao;

import java.util.List;

import com.demo.geolocalizacion.dominio.Geolocalizacion;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.util.IDAO;

public interface GeolocalizacionDAO  extends IDAO<Geolocalizacion> {

	Geolocalizacion obtenerGeolocalizacionPorTelefono(Telefono telefono);

	List<Geolocalizacion> obtenerLstGeolocalizacionPorTelefono(Telefono telefono);

}
