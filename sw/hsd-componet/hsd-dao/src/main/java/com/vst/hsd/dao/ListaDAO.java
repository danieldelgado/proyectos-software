package com.vst.hsd.dao;

import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Usuario;
import com.vst.util.IDAO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ListaDAO.
 */
public interface ListaDAO extends IDAO<Lista> {

	/**
	 * Obtener lista por usuario.
	 * 
	 * @param entidad
	 *            the entidad
	 * @param u
	 *            the u
	 * @return the lista
	 */
	Lista obtenerListaPorUsuario(String codigoentidad, Usuario u);

	/**
	 * Obtener lista por entidad.
	 * 
	 * @param entidad
	 *            the entidad
	 * @return the lista
	 */
	Lista obtenerListaPorEntidad(String entidad);

}
