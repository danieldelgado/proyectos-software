package com.demo.geolocalizacion.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.geolocalizacion.dao.GeolocalizacionDAO;
import com.demo.geolocalizacion.dominio.Geolocalizacion;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.util.DAO;

@SuppressWarnings("unchecked")
@Repository("GeolocalizacionDAO")
public class GeolocalizacionDAOImpl extends DAO<Geolocalizacion> implements GeolocalizacionDAO {

	@Override
	public Geolocalizacion obtenerGeolocalizacionPorTelefono(Telefono telefono) {
		sqlQuery = "select new Geolocalizacion(g.id , g.fechaRegistro) from Geolocalizacion g where g.telefono = :telefono order by g.fechaRegistro desc";
		q = em.createQuery(sqlQuery);
		q.setParameter("telefono", telefono);
		List<Geolocalizacion> glst = q.getResultList();
		if(glst.size()>0){
			Geolocalizacion g = glst.get(0);
			return g;
		}
		return null;
	}

	@Override
	public List<Geolocalizacion> obtenerLstGeolocalizacionPorTelefono(
			Telefono telefono) {
		sqlQuery = "select new Geolocalizacion(g.id , g.fechaRegistro , g.telefono) from Geolocalizacion g where g.telefono = :telefono";
		q = em.createQuery(sqlQuery);
		q.setParameter("telefono", telefono);
		List<Geolocalizacion> glst = q.getResultList();	
		return glst;
	}

}
