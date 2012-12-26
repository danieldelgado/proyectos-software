package com.vst.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroPorParametroDAO;
import com.vst.dominio.ParametroPorParametro;
import com.vst.ws.service.impl.RegistrarHistorialServiceImpl;

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
	
}
