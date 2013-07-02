package com.vst.hsd.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.MenuDAO;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.DAO;

/**
 * The Class MenuDAOImpl.
 */
@Repository("MenuDAO")
public class MenuDAOImpl extends DAO<Menu> implements MenuDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MenuDAOImpl.class);

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerMenusPorPerfil(Usuario u) {
		sqlQuery = "select new Menu(m.id,m.codigo,m.nombre,m.orden,m.tipo,m.defaultMenu,m.todos,m.url) from Menu m " +
				   " where " +
				   " m.menu is null and" +
				   " m.id in ( select rpp.id.recurso.id from RecursoPorPerfil rpp where rpp.id.perfil.id = :perfil )  ";
				 		
		log.debug(" sqlQuery  : " + sqlQuery);
		q = em.createQuery(sqlQuery);
		try {
			q.setParameter("perfil", u.getPerfilLogueado().getId());
			System.out.println("getParameters:" + q.getParameters());
			List<Menu> l =  q.getResultList();
			return l;
		} catch (Exception e) {
			log.error(" error al obtener la lista por la perfil :" + u.getPerfilLogueado().getId() + " error : " + e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Menu> obtenerSubMenus(Integer id) {
		sqlQuery = "select new Menu(m.id,m.codigo,m.nombre,m.orden,m.tipo,m.defaultMenu,m.todos,m.url) from Menu m " +
				   " where m.menu.id = :id ";		
		log.debug(" sqlQuery  : " + sqlQuery);
		q = em.createQuery(sqlQuery);
		try {
			q.setParameter("id", id );
			System.out.println("getParameters:" + q.getParameters());
			List<Menu> l =  q.getResultList();
			return l;
		} catch (Exception e) {
			log.error(" error al obtener la lista por menu id :" + id + " error : " + e.getMessage());
			return null;
		}
	}

}
