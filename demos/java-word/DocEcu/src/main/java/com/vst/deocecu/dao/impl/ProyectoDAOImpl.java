package com.vst.deocecu.dao.impl;

import org.springframework.stereotype.Repository;
import com.vst.deocecu.dao.ProyectoDAO;
import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.util.DAO;

@Repository("ProyectoDAO")
public class ProyectoDAOImpl extends DAO<Proyecto> implements ProyectoDAO {

	public Proyecto existeProyectoPorFolder(String folder, String titulo) {
		sqlQuery = " Select p from Proyecto p where p.folder like :folder and p.titulo like :titulo ";
		q = em.createQuery(sqlQuery);
		q.setParameter("folder", "%"+folder+"%");
		q.setParameter("titulo", "%"+titulo+"%");
		q.setFirstResult(1);
		try {
			return (Proyecto) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
