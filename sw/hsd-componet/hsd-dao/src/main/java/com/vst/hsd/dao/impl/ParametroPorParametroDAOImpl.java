package com.vst.hsd.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ParametroPorParametroDAO;
import com.vst.hsd.dominio.ParametroPorParametro;

// TODO: Auto-generated Javadoc
/**
 * The Class ParametroPorParametroDAOImpl.
 */
@Repository("ParametroPorParametroDAO")
public class ParametroPorParametroDAOImpl implements ParametroPorParametroDAO {

	/** The log. */
	private static Logger log = LoggerFactory
			.getLogger(ParametroPorParametroDAOImpl.class);

	/** The em. */
	@PersistenceContext
	protected EntityManager em;

	/** The sql query. */
	protected String sqlQuery = null;

	/** The q. */
	protected Query q = null;

	/* (non-Javadoc)
	 * @see com.vst.hsd.dao.ParametroPorParametroDAO#guardar(com.vst.hsd.dominio.ParametroPorParametro)
	 */
	public void guardar(ParametroPorParametro objeto) {
		try {
			log.info(" Entro al metodo guardar de Entidad ParametroPorParametro");
			if (objeto.getId() != null)
				em.merge(objeto);
			else
				em.persist(objeto);
			log.info(" Transaction terminada  ParametroPorParametro con id :"
					+ objeto.getId());
		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
			log.error(" Transaction rollback  ParametroPorParametro"
					+ e.getMessage());
			e.printStackTrace();
		} finally {
			log.info(" Transaction cerrada finally ParametroPorParametro");
		}

	}

	/*
	 * 
	 * public List<ParametroPorParametro>
	 * obtenerParametrosPorParametrosPorParametro(Parametro
	 * entidadParametrorules) {
	 * 
	 * sqlQuery=
	 * " select pp from ParametroPorParametro pp where pp.id.parametroIdParametroPadre in ( :idparametro )"
	 * ; q=em.createQuery(sqlQuery); //System.out.println(
	 * Util.generateCollection("id", entidadParametrorules.getParametros()));
	 * q.setParameter("idparametro", Util.generateCollection("id",
	 * entidadParametrorules.getParametros())); return q.getResultList(); }
	 */

	// public List<ParametroPorParametro>
	// obtenerParametrosPorParametrosPorParametro(List<Parametro>
	// obtenerParametrosHijos) {
	// sqlQuery=" select pp from ParametroPorParametro pp where pp.id.parametroIdParametroPadre in ( :idparametro )";
	// q=em.createQuery(sqlQuery);
	// q.setParameter("idparametro", Util.generateCollection("id",
	// obtenerParametrosHijos));
	// return q.getResultList();
	// }
	//
	// public List<ParametroPorParametro>
	// obtenerParametroPorParametroPorParametroHijo(Parametro pH) {
	// sqlQuery=" select pp from ParametroPorParametro pp where pp.id.parametroIdParametroPadre = :idparametro order by pp.orden";
	// q=em.createQuery(sqlQuery);
	// q.setParameter("idparametro", pH.getId());
	// return q.getResultList();
	// }

}
