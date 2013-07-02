package com.vst.hsd.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ColumnaPorListaDAO;

@Repository("ColumnaPorListaDAO")
public class ColumnaPorListaDAOImpl implements ColumnaPorListaDAO {

	static final Logger log = LoggerFactory.getLogger(ColumnaPorListaDAOImpl.class);

	@PersistenceContext
	protected EntityManager em;

	protected String sqlQuery = null;

	protected Query q = null;

}
