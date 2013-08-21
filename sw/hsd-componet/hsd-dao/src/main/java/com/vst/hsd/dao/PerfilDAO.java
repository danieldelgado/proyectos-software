package com.vst.hsd.dao;

import java.util.List;

import com.vst.hsd.dominio.Perfil;
import com.vst.util.persistence.IDAO;

// TODO: Auto-generated Javadoc
/**
 * The Interface PerfilDAO.
 */
public interface PerfilDAO extends IDAO<Perfil> {

	/**
	 * Obtener todos activos.
	 * 
	 * @return the list
	 */
	List<Perfil> obtenerTodosActivos();

}
