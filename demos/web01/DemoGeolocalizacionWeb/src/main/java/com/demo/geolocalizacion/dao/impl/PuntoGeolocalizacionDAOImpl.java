package com.demo.geolocalizacion.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.geolocalizacion.dao.PuntoGeolocalizacionDAO;
import com.demo.geolocalizacion.dominio.PuntoGeolocalizacion;
import com.demo.geolocalizacion.util.DAO;


@SuppressWarnings("unchecked")
@Repository("PuntoGeolocalizacionDAO")
public class PuntoGeolocalizacionDAOImpl  extends DAO<PuntoGeolocalizacion>  implements PuntoGeolocalizacionDAO {

	@Override
	public List<PuntoGeolocalizacion> obtenerPuntosGeolocalizacion(Integer id) {
		sqlQuery = "select p from PuntoGeolocalizacion p where  geolocalizacion.id = :id ";
		q = em.createQuery(sqlQuery);
		q.setParameter("id", id);
		List<PuntoGeolocalizacion> lst = q.getResultList();
		return lst;
	}

}
