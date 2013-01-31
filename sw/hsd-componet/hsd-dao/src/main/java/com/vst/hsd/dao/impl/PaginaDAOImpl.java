package com.vst.hsd.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.PaginaDAO;
import com.vst.hsd.dominio.Pagina;
import com.vst.util.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class PaginaDAOImpl.
 */
@Repository("PaginaDAO")
public class PaginaDAOImpl extends DAO<Pagina> implements PaginaDAO {

	/** The Constant log. */
	static final Logger log = LoggerFactory.getLogger(PaginaDAOImpl.class);

	/** The em. */
	@PersistenceContext
	protected EntityManager em;

	/** The sql query. */
	protected String sqlQuery = null;

	/** The q. */
	protected Query q = null;

}
