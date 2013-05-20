package com.demo.geolocalizacion.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.geolocalizacion.dao.PuntoGeolocalizacionDAO;
import com.demo.geolocalizacion.dominio.PuntoGeolocalizacion;
import com.demo.geolocalizacion.util.DAO;


@Repository("PuntoGeolocalizacionDAO")
public class PuntoGeolocalizacionDAOImpl  extends DAO<PuntoGeolocalizacion>  implements PuntoGeolocalizacionDAO {

}
