package com.vst.hsd.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.BotonDAO;
import com.vst.hsd.dominio.Boton;
import com.vst.util.DAO;

@Repository("BotonDAO")
public class BotonDAOImpl extends DAO<Boton> implements BotonDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BotonDAOImpl.class);

	@SuppressWarnings("unchecked")
	public List<Boton> obtenerBotonesPorMenu(Integer idmenu) {
		log.info("obtener por menu");
		sqlQuery = " SELECT new Boton( b.id, b.codigo, b.icono, b.orden, b.parametrosJson, b.tipo,b.url,b.nombre) from Boton b "
				+ " where b.id in ( select bpm.id.boton.id from BotonPorMenu bpm where  bpm.id.menu.id = :menu )  ";
		log.debug(" sqlQuery  : " + sqlQuery);
		try {
			q = em.createQuery(sqlQuery);
			q.setParameter("menu", idmenu);
			List<Boton> lbs = q.getResultList();
			return lbs;
		} catch (Exception e) {
			log.error(" error al obtener la lista por la idmenu :" + idmenu
					+ " error : " + e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Boton> obtenerBotonesPorFormulario(String codigoFormulario) {
		sqlQuery = " select new Boton( b.id, b.codigo, b.icono, b.orden, b.parametrosJson, b.tipo,b.url,b.nombre) from Boton b"
				+ " where "
				+ "  b.id in ( select bpm.id.boton.id from BotonPorFormulario bpm where  bpm.id.formulario.codigo = :codigoFormulario )  ";
		try {
			q = em.createQuery(sqlQuery);
			q.setParameter("codigoFormulario", codigoFormulario);
			List<Boton> lbs = q.getResultList();
			return lbs;
		} catch (Exception e) {
			log.error(" error al obtener la lista por la codigoFormulario :"
					+ codigoFormulario + " error : " + e.getMessage());
		}
		return null;
	}

}
