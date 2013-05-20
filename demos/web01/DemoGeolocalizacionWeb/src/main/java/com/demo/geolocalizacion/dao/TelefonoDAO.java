package com.demo.geolocalizacion.dao;

import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.util.IDAO;

public interface TelefonoDAO   extends IDAO<Telefono>{

	Telefono existeTelefonoRegistrado(String numero);

}
