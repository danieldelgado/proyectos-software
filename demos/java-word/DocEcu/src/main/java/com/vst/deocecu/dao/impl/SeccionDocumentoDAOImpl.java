package com.vst.deocecu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.deocecu.dao.SeccionDocumentoDAO;
import com.vst.deocecu.dominio.Proyecto;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.util.DAO;

@Repository("SeccionDocumentoDAO")
public class SeccionDocumentoDAOImpl extends DAO<Seccion_Documento> implements SeccionDocumentoDAO {

	public List<Seccion_Documento> obtenerSeccionesDocumentos(Proyecto p) {
		sqlQuery = "Select sd from Seccion_Documento sd where sd.proyecto.id=:proyecto ";
		q = em.createQuery(sqlQuery);
		q.setFirstResult(1);
		q.setParameter("proyecto", p.getId());
		try {
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}



}
