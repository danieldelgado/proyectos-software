package com.vst.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.dao.ParametroDAO;
import com.vst.dominio.Parametro;
import com.vst.util.Constantes;
import com.vst.util.DAO;
import com.vst.util.Util;
import com.vst.ws.service.impl.RegistrarHistorialServiceImpl;

@Repository("ParametroDAO")
public class ParametroDAOImpl extends DAO<Parametro> implements ParametroDAO {
	private static Logger log = LoggerFactory.getLogger(ParametroDAOImpl.class);

	public Integer getRangoEnteroMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_ENTERO_MININO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoEnteroMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValor());
	}

	public Integer getRangoEnteroMax() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_ENTERO_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoEnteroMax sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValor());
	}

	
	
	
	
	public Integer getValorEnteroMax() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.VALOR_ENTERO_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getValorEnteroMax sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValor());
	}

	public Integer getValorEnteroMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.VALOR_ENTERO_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getValorEnteroMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValor());
	}

	public Integer getCantidadDecimales() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.CANTIDAD_DECIMALES);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getCantidadDecimales sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Integer.parseInt(p.getValor());
	}

	public Double getRangoDecimalMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoDecimalMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValor());
	}

	public Double getRangoDecimalMax() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_DECIMAL_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoDecimalMax sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValor());
	}

	public Double getValorDecimalMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.VALOR_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getValorDecimalMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		return Double.parseDouble(p.getValor());
	}

	public Integer getValorDecimalMax() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.VALOR_DECIMAL_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getValorDecimalMax sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();	
		log.debug(" [getValorDecimalMax p : " + Util.getJson(p) + " ]");		
		return Integer.parseInt(p.getValor());
	}

	public Integer getRangoCadenaMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_CADENA_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoCadenaMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();	
		log.debug(" [getRangoCadenaMin p : " + Util.getJson(p) + " ]");		
		return Integer.parseInt(p.getValor());
	}

	public Integer getRangoCadenaMax() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.RANGO_CADENA_MAXIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getRangoCadenaMax sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		log.debug(" [getRangoCadenaMax p : " + Util.getJson(p) + " ]");		
		return Integer.parseInt(p.getValor());
	}

	public String[] getCadenasRestringidas() {
		sqlQuery = "select p.valor from Parametro p where p.parametro.id = ( select p2.id from Parametro p2 where p2.tipo = :tipo ) ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.CADENAS_RESTRINGIDAS);
		log.debug(" [getCadenasRestringidas sqlQuery : " + sqlQuery + " ]");
		List<String> str = q.getResultList();
		log.debug(" [getCadenasRestringidas str : " + Util.getJson(str) + " ]");	
		return str.toArray( new String[str.size()] );
	}

	public String[] getCadenasRestringidasSelector() {
		sqlQuery = "select p.valor from Parametro p where p.parametro.id = ( select p2.id from Parametro p2 where p2.tipo = :tipo ) ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.CADENAS_RESTRINGIDAS_SELECTOR);
		log.debug(" [getCadenasRestringidasSelector sqlQuery : " + sqlQuery + " ]");
		List<String> str = q.getResultList();
		log.debug(" [getCadenasRestringidasSelector str : " + Util.getJson(str) + " ]");		
		return str.toArray( new String[str.size()] );
	}

	public Integer getValorSelectorMin() {
		sqlQuery = "select p from Parametro p where p.tipo = :tipo ";
		q=em.createQuery(sqlQuery);
		q.setParameter("tipo", Constantes.VALOR_SELECT_MINIMO);
		q.setMaxResults(1);
		//q.setFirstResult(1);
		log.debug(" [getValorSelectorMin sqlQuery : " + sqlQuery + " ]");
		Parametro p = (Parametro) q.getSingleResult();		
		log.debug(" [getValorSelectorMin Parametro : " + Util.getJson(p) + " ]");		
		return Integer.parseInt(p.getValor());
	}

	public String getFormatoCampo(String entidad, String campo, String tipo){
		System.out.println(entidad);
		System.out.println(campo);
		System.out.println(tipo);
		
		sqlQuery = "select p from Parametro p where p.tipo = :tipo and p.entidad = :entidad and p.campo = :campo";
		q=em.createQuery(sqlQuery);
		q.setMaxResults(1);
		q.setParameter("entidad", entidad);
		q.setParameter("campo", campo);
		q.setParameter("tipo", tipo);
		log.debug(" [getFormatoCampo sqlQuery : " + sqlQuery + " ]");
		Parametro p = null;	
		List<Parametro> lstParam = q.getResultList();
		if(lstParam.size()>0){
			p = lstParam.get(0);
			log.debug(" [getFormatoCampo Parametro : " + Util.getJson(p) + " ]");			
			return p.getValor();
		}		
		return null;
	}


	
}
