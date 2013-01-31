package com.vst.hsd.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vst.hsd.dao.BotonDAO;
import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Menu;
import com.vst.util.DAO;

// TODO: Auto-generated Javadoc
/**
 * The Class BotonDAOImpl.
 */
@Repository("BotonDAO")
public class BotonDAOImpl extends DAO<Boton> implements BotonDAO {

	/** The Constant log. */
	private static final Logger log = LoggerFactory
			.getLogger(BotonDAOImpl.class);

	/* (non-Javadoc)
	 * @see com.vst.hsd.dao.BotonDAO#obtenerBotonesPorMenu(com.vst.hsd.dominio.Menu)
	 */
	public List<Boton> obtenerBotonesPorMenu(Menu m) {
		// TODO Auto-generated method stub
		return null;
	}

}
