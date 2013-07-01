package com.vst.hsd.dao;

import java.util.List;
import java.util.Map;

import com.vst.hsd.dominio.Columna;
import com.vst.hsd.dominio.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataListComponet.
 */
public interface DataListComponet {

	/**
	 * Gets the data.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param codigo
	 *            the codigo
	 * @param columnas
	 *            the columnas
	 * @param estado
	 *            the estado
	 * @param columnaOrden
	 *            the columna orden
	 * @param direccionOrden
	 *            the direccion orden
	 * @param pagina
	 *            the pagina
	 * @param filas
	 *            the filas
	 * @param _search
	 *            the _search
	 * @param searchField
	 *            the search field
	 * @param searchOper
	 *            the search oper
	 * @param searchString
	 *            the search string
	 * @return the data
	 */
	List<Map<String, Object>> getData(Usuario usuario, String codigo, List<Columna> columnas, Character estado, String columnaOrden, String direccionOrden, int pagina, int filas, boolean _search,
			String searchField, String searchOper, String searchString);

	/**
	 * Gets the cuenta data.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param codigo
	 *            the codigo
	 * @param columnas
	 *            the columnas
	 * @param estado
	 *            the estado
	 * @return the cuenta data
	 */
	Integer getCuentaData(Usuario usuario, String codigo, List<Columna> columnas, Character estado);

	/**
	 * Gets the cantidad data rows.
	 * 
	 * @param usuario
	 *            the usuario
	 * @param codigo
	 *            the codigo
	 * @param estado
	 *            the estado
	 * @return the cantidad data rows
	 */
	int getCantidadDataRows(Usuario usuario, String codigo, Character estado);
}
