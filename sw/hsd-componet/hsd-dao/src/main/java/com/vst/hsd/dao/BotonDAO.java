package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Menu;
import com.vst.util.IDAO;

// TODO: Auto-generated Javadoc
/**
 * The Interface BotonDAO.
 */
public interface BotonDAO extends IDAO<Boton> {

	/**
	 * Obtener botones por menu.
	 * 
	 * @param m
	 *            the m
	 * @return the list
	 */
	List<Boton> obtenerBotonesPorMenu(Integer idmenu);

	List<Boton> obtenerBotonesPorFormulario(String codigoFormulario);

}
