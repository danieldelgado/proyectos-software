package com.vst.hsd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.PerfilDAO;
import com.vst.hsd.dominio.Perfil;
import com.vst.util.Constantes;
import com.vst.util.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class PerfilDAOImpl.
 */
@Repository("PerfilDAO")
public class PerfilDAOImpl extends DAO<Perfil> implements PerfilDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.hsd.dao.PerfilDAO#obtenerTodosActivos()
	 */
	@SuppressWarnings("unchecked")
	public List<Perfil> obtenerTodosActivos() {
		sqlQuery = "select new Perfil(p.id,p.codigo,p.nombre) from Perfil p " + "where p.activo = true and p.estado = :estado ";
		q = em.createQuery(sqlQuery);
		q.setParameter("estado", Constantes.ACTIVO);
		return q.getResultList();
	}

}
