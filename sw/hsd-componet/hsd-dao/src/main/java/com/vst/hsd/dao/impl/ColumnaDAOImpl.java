package com.vst.hsd.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ColumnaDAO;
import com.vst.hsd.dominio.Columna;
import com.vst.util.DAO;

@Repository("ColumnaDAO")
public class ColumnaDAOImpl extends DAO<Columna> implements ColumnaDAO {

	public List<Columna> buscarPorLista(Integer id) {
		sqlQuery = "select new Columna(c.id, c.addColumn, c.ancho, c.atributo, c.cabecera, c.codigo, c.tabla, " +
				" c.alineacion, c.formato_tipo, c.mapping,c.visible, c.orden, c.estado, c.activo)  " +
				" from Columna c  fetch join  c.listas l where l.id=:lista";
		q=em.createQuery(sqlQuery);
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
