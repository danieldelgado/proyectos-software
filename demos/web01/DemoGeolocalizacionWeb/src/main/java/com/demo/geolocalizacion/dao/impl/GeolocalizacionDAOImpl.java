package com.demo.geolocalizacion.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.geolocalizacion.dao.GeolocalizacionDAO;
import com.demo.geolocalizacion.dominio.Geolocalizacion;
import com.demo.geolocalizacion.util.DAO;

@Repository("GeolocalizacionDAO")
public class GeolocalizacionDAOImpl extends DAO<Geolocalizacion> implements GeolocalizacionDAO {

}
