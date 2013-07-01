package com.vst.hsd.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.BotonPorPaginaDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class BotonPorPaginaDAOImpl.
 */
@Repository("BotonPorPaginaDAO")
public class BotonPorPaginaDAOImpl implements BotonPorPaginaDAO {

	/** The Constant log. */
	static final Logger log = LoggerFactory.getLogger(BotonPorPaginaDAOImpl.class);

	/** The em. */
	@PersistenceContext
	protected EntityManager em;

	/** The sql query. */
	protected String sqlQuery = null;

	/** The q. */
	protected Query q = null;

}
