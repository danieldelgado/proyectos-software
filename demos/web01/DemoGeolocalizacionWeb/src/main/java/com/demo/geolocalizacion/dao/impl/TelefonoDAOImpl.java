package com.demo.geolocalizacion.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.geolocalizacion.dao.TelefonoDAO;
import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.util.DAO;
@Repository("TelefonoDAO")
public class TelefonoDAOImpl extends DAO<Telefono>   implements TelefonoDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Telefono existeTelefonoRegistrado(String numero) {
		sqlQuery = "select t from Telefono t where t.numero = :numero";
		q = em.createQuery(sqlQuery);
		q.setParameter("numero", numero);
		List<Telefono> tels = q.getResultList();
		if(tels.size()>0){
			Telefono telefono = tels.get(0);
			return telefono;
		}
		return null;
	}

}
