package com.vst.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.vst.dao.ColumnaDAO;
import com.vst.dominio.Columna;
import com.vst.dominio.Lista;
import com.vst.util.Constantes;
import com.vst.util.DAO;

@Repository("ColumnaDAO")
public class ColumnaDAOImpl extends DAO<Columna> implements ColumnaDAO {

	public List<Columna> buscarPorLista(Integer id) {
		sqlQuery = "select new Columna(c.id, c.addColumn, c.ancho,				c.atributo, c.cabecera, c.codigo, c.tabla,		" +
				"		c.alineacion, String formato_tipo, c.mapping,				c.visible, c.orden, c.estado, c.activo)  " +
				" from Columna c left join fetch c.listas l where l.id=:lista";
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
