package com.vst.hsd.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ColumnaDAO;
import com.vst.hsd.dominio.Columna;
import com.vst.util.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class ColumnaDAOImpl.
 */
@Repository("ColumnaDAO")
public class ColumnaDAOImpl extends DAO<Columna> implements ColumnaDAO {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(ColumnaDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.hsd.dao.ColumnaDAO#buscarPorLista(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<Columna> buscarPorLista(Integer id) {
		log.debug(" buscarPorLista id:" + id);
		sqlQuery = "select  new Columna(c.id, c.addColumn, c.ancho, c.atributo, c.cabecera, c.codigo, c.tabla,  c.alineacion, c.formato_tipo, c.mapping,c.visible, c.orden, c.estado, c.activo)  "
				+ " from ColumnaPorLista cl , Columna c where cl.id.lista.id = :lista  and cl.id.columna = c ";

		// sqlQuery =
		// "select  new Columna( cl.id.columna.id, cl.id.columna.addColumn, cl.id.columna.ancho, cl.id.columna.atributo, cl.id.columna.cabecera, cl.id.columna.codigo, cl.id.columna.tabla,  cl.id.columna.alineacion, cl.id.columna.formato_tipo, cl.id.columna..visible, cl.id.columna.orden, cl.id.columna.estado, cl.id.columna.activo) "
		// +

		log.debug(" buscarPorLista  sqlQuery :  " + sqlQuery);
		q = em.createQuery(sqlQuery);
		q.setParameter("lista", id);
		try {
			List<Columna> columnas = q.getResultList();
			return columnas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
