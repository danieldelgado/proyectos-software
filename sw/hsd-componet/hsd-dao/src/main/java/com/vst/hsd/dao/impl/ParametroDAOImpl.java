package com.vst.hsd.dao.impl;

import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ParametroDAO;
import com.vst.hsd.dominio.Parametro;
import com.vst.util.DAO;

/**
 * The Class ParametroDAOImpl.
 */
@Repository("ParametroDAO")
public class ParametroDAOImpl extends DAO<Parametro> implements ParametroDAO {
	//
	// public List<Parametro> obtenerPorTipo(String tipoEstado) {
	// sqlQuery =
	// "select new  Parametro(p.id, p.codigo, p.valor) from Parametro p where p.tipo = :tipo ";
	// q=em.createQuery(sqlQuery);
	// q.setParameter("tipo", tipoEstado);
	// return q.getResultList();
	// }
	//
	// public List<Parametro> obtenerParametrosPadre() {
	// sqlQuery = "select p from Parametro p " +
	// " where " +
	// " p.parametro = null and p.valor = null and p.activo = true ";
	// q=em.createQuery(sqlQuery);
	// return q.getResultList();
	// }
	//
	// public Parametro parametroPorParametroDAO(String entidad) {
	// sqlQuery = "select p  " +// new Parametro(p.id, p.codigo, p.estado,
	// p.activo, p.entidad, p.campo, p.tipo, p.atributo, p.valor, p.descripcion)
	// " +
	// " from Parametro p "+ //left join fetch p.parametros ps " +
	// " where " +
	// " p.entidad = :entidad and p.tipo = :tipo  and p.atributo = null and p.parametro = null and p.activo = true  ";
	// q=em.createQuery(sqlQuery);
	// q.setParameter("entidad", entidad);
	// q.setParameter("tipo", Constantes.JS_RULES);
	// List<Parametro> p = q.getResultList();
	// if(p!=null){
	// if(p.size()>0){
	// return p.get(0);
	// }
	// }
	// return null;
	// }
	//
	// public List<Parametro> obtenerParametrosHijos(Integer id) {
	//
	// sqlQuery = "select p from Parametro p " +
	// " where " +
	// "p.parametro.id = :id   ";
	// q=em.createQuery(sqlQuery);
	// q.setParameter("id", id);
	// List<Parametro> p = q.getResultList();
	// return p;
	// }
	//
	// public List<Parametro> obtenerParametros() {
	// sqlQuery = "select new Parametro(p.id, p.nombre)  from Parametro p " +
	// " where " +
	// " p.activo = true and " +
	// " p.tipovariable is not null and " +
	// " p.tipo is not null and " +
	// " p.valor is not null  and  " +
	// " p.parametro.id is null ";
	//
	// q=em.createQuery(sqlQuery);
	// List<Parametro> p = q.getResultList();
	// return p;
	// }

}
