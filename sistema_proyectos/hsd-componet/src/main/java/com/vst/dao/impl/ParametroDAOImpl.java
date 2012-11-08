package com.vst.dao.impl;

import java.util.List;

import javax.persistence.Column;

import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.DAO;

@Repository("ParametroDAO")
public class ParametroDAOImpl extends DAO<Parametro> implements ParametroDAO {

	public List<Parametro> obtenerPorTipo(String tipoEstado) {		
		sqlQuery = "select new  Parametro(p.id, p.codigo, p.valor) from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", tipoEstado);		
		return q.getResultList();
	}

	public List<Parametro> obtenerParametrosPadre() {
		sqlQuery = "select p from Parametro p " +
				" where " +
				" p.parametro = null and p.valor = null and p.activo = true ";
		q=em.createQuery(sqlQuery);			
		return q.getResultList();
	}

	
}
