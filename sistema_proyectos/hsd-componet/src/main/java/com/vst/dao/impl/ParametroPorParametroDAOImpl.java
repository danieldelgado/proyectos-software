package com.vst.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroPorParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.dominio.ParametroPorParametro;
import com.vst.util.Util;

@Repository("ParametroPorParametroDAO")
public class ParametroPorParametroDAOImpl implements ParametroPorParametroDAO {

	private static Logger log = LoggerFactory.getLogger(ParametroPorParametroDAOImpl.class);
	
	@PersistenceContext
	protected EntityManager em;

	protected String sqlQuery = null;

	protected Query q = null;
	
	
	
	public void guardar(ParametroPorParametro objeto) {
		try {
			log.info(" Entro al metodo guardar de Entidad ParametroPorParametro" );
			if (objeto.getId() != null)
				em.merge(objeto);
			else
				em.persist(objeto);
			log.info(" Transaction terminada  ParametroPorParametro con id :" + objeto.getId());
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			log.error(" Transaction rollback  ParametroPorParametro" + e.getMessage());
			e.printStackTrace();
		} finally {
			log.info(" Transaction cerrada finally ParametroPorParametro");
		}

	}



	public List<ParametroPorParametro> obtenerParametrosPorParametrosPorParametro(Parametro entidadParametrorules) {
		
		sqlQuery=" select pp from ParametroPorParametro pp where pp.id.parametroIdParametroPadre in ( :idparametro )";
		q=em.createQuery(sqlQuery);		
		//System.out.println( Util.generateCollection("id", entidadParametrorules.getParametros()));
		q.setParameter("idparametro", Util.generateCollection("id", entidadParametrorules.getParametros()));	
		return q.getResultList();
	}
	
}
