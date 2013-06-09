package com.demo.geolocalizacion.dao;

import java.util.List;

import com.demo.geolocalizacion.dominio.PuntoGeolocalizacion;
import com.demo.geolocalizacion.util.IDAO;

public interface PuntoGeolocalizacionDAO  extends IDAO<PuntoGeolocalizacion>{

	List<PuntoGeolocalizacion> obtenerPuntosGeolocalizacion(Integer id);

}
