package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Columna;
import com.vst.util.IDAO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ColumnaDAO.
 */
public interface ColumnaDAO extends IDAO<Columna> {

	/**
	 * Buscar por lista.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	List<Columna> buscarPorLista(Integer id);

}
