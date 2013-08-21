package com.vst.hsd.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.ListaDAO;
import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.persistence.impl.DAO;

@Repository("ListaDAO")
public class ListaDAOImpl extends DAO<Lista> implements ListaDAO {

	private static final Logger log = LoggerFactory.getLogger(ListaDAOImpl.class);

	public Lista obtenerListaPorUsuario(String codigoentidad, Usuario u) {
		log.debug(" obtenerListaPorUsuario codigoentidad : " + codigoentidad);
		sqlQuery = " SELECT new Lista( ls.id, ls.codigo, ls.nombre, ls.tabla, ls.idMenu, ls.rowClick) FROM Lista ls where ls.codigo = :codigoentidad " + " and "
				+ " ls.id in ( select rpp.id.recurso.id from RecursoPorPerfil rpp where rpp.id.perfil.id = :perfil )   ";
		log.debug(" sqlQuery  : " + sqlQuery);
		q = em.createQuery(sqlQuery);
		try {
			q.setParameter("codigoentidad", codigoentidad);
			q.setParameter("perfil", u.getPerfilLogueado().getId());
			System.out.println("getParameters:" + q.getParameters());
			Lista l = (Lista) q.getSingleResult();
			log.debug(" lista obtenida " + l.getCodigo());
			return l;
		} catch (Exception e) {
			log.error(" error al obtener la lista por la entidad :" + codigoentidad + " error : " + e.getMessage());
			return null;
		}
	}

	public Lista obtenerListaPorEntidad(String entidad) {
		log.debug(" obtenerListaPorEntidad entidad : " + entidad);
//		sqlQuery = " SELECT new Lista( ls.id, ls.codigo, ls.nombre, ls.tabla,ls.idMenu) FROM Lista ls where ls.tabla = :entidad";

		sqlQuery = " SELECT new Lista( ls.id, ls.codigo, ls.nombre, ls.tabla,ls.idMenu, ls.rowClick) FROM Lista ls where ls.codigo = :entidad";
		q = em.createQuery(sqlQuery);
		try {
			q.setMaxResults(1);
			q.setParameter("entidad", entidad);
			Lista l = (Lista) q.getSingleResult();
			log.debug(" lista obtenida " + l.getCodigo());
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(" error al obtener la lista por la entidad :" + entidad + " error : " + e.getMessage());
			return null;
		}
	}

}
