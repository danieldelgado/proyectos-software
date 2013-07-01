package com.vst.hsd.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.BotonDAO;
import com.vst.hsd.dominio.Boton;
import com.vst.util.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class BotonDAOImpl.
 */
@Repository("BotonDAO")
public class BotonDAOImpl extends DAO<Boton> implements BotonDAO {

	/** The Constant log. */
	private static final Logger log = LoggerFactory.getLogger(BotonDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vst.hsd.dao.BotonDAO#obtenerBotonesPorMenu(com.vst.hsd.dominio.Menu)
	 */
	@SuppressWarnings("unchecked")
	public List<Boton> obtenerBotonesPorMenu(Integer idmenu) {
		log.info("obtener por menu");
		sqlQuery = " SELECT new Boton( b.id, b.codigo, b.icono, b.orden, b.parametrosJson, b.tipo,b.url) from Boton b "
				+ " where b.id in ( select bpm.pk.boton.id ftom BotonPorMenu bpm where  bpm.pk.menu.id =: menu )  ";
		log.debug(" sqlQuery  : " + sqlQuery);
		try {
			q = em.createQuery(sqlQuery);
			q.setParameter("menu", idmenu);
			List<Boton> lbs = q.getResultList();
			return lbs;
		} catch (Exception e) {
			log.error(" error al obtener la lista por la idmenu :" + idmenu + " error : " + e.getMessage());			
		}
		return null;
	}

}
