package com.vst.deocecu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.deocecu.dao.DocumentoDAO;
import com.vst.deocecu.dominio.Documento;
import com.vst.deocecu.dominio.Seccion_Documento;
import com.vst.deocecu.util.DAO;

@Repository("DocumentoDAO")
public class DocumentoDAOImpl extends DAO<Documento> implements DocumentoDAO {

	@SuppressWarnings("unchecked")
	public List<Documento> obtenetDocumentosPorSeccionDocumento(Seccion_Documento sd) {		
		sqlQuery = " select d from Documento d where d.seccion_documento.id = :id " ;
		q = em.createQuery(sqlQuery);
		q.setParameter("id", sd.getId() );
		try {
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}

}
