package com.vst.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.Constantes;
import com.vst.util.DAO;

@Repository("ParametroDAO")
public class ParametroDAOImpl extends DAO<Parametro> implements ParametroDAO {

	public Integer getRangoEnteroMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_ENTERO_MININO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Integer getRangoEnteroMax() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_ENTERO_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	
	
	
	
	public Integer getValorEnteroMax() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.VALOR_ENTERO_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Integer getValorEnteroMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.VALOR_ENTERO_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Integer getCantidadDecimales() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.CANTIDAD_DECIMALES);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Double getRangoDecimalMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValorString());
	}

	public Double getRangoDecimalMax() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_DECIMAL_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValorString());
	}

	public Double getValorDecimalMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.VALOR_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValorString());
	}

	public Integer getValorDecimalMax() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.VALOR_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Integer getRangoCadenaMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_CADENA_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public Integer getRangoCadenaMax() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.RANGO_CADENA_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	public String[] getCadenasRestringidas() {
		sqlQuery = "select p.valorString from Parametro p where p.parametro.id = ( select p2.id from Parametro p2 where p2.nombre = :nombre ) ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.CADENAS_RESTRINGIDAS);
		List<String> str = q.getResultList();
		return str.toArray( new String[str.size()] );
	}

	public String[] getCadenasRestringidasSelector() {
		sqlQuery = "select p.valorString from Parametro p where p.parametro.id = ( select p2.id from Parametro p2 where p2.nombre = :nombre ) ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.CADENAS_RESTRINGIDAS_SELECTOR);
		List<String> str = q.getResultList();
		return str.toArray( new String[str.size()] );
	}

	public Integer getValorSelectorMin() {
		sqlQuery = "select p from Parametro p where p.nombre = :nombre ";
		q=em.createQuery(sqlQuery);
		q.setParameter("nombre", Constantes.VALOR_SELECT_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValorString());
	}

	
}
