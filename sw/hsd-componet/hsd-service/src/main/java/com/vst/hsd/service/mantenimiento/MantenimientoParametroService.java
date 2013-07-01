package com.vst.hsd.service.mantenimiento;

import java.util.List;
import java.util.Map;

import com.vst.hsd.dominio.Parametro;

// TODO: Auto-generated Javadoc
/**
 * The Interface MantenimientoParametroService.
 */
public interface MantenimientoParametroService {

	/**
	 * Obtener estados.
	 * 
	 * @return the list
	 */
	List<Parametro> obtenerEstados();

	/**
	 * Obtener parametros padre.
	 * 
	 * @return the list
	 */
	List<Parametro> obtenerParametrosPadre();

	/**
	 * Guardar parametro.
	 * 
	 * @param parametro
	 *            the parametro
	 * @return the int
	 */
	int guardarParametro(Parametro parametro);

	/**
	 * Obtener parametro.
	 * 
	 * @param param
	 *            the param
	 * @return the parametro
	 */
	Parametro obtenerParametro(int param);

	/**
	 * Obtener parametros rules entidad.
	 * 
	 * @param entidad
	 *            the entidad
	 * @return the list
	 */
	@SuppressWarnings("rawtypes")
	List obtenerParametrosRulesEntidad(String entidad);

	/**
	 * Obtener parametros.
	 * 
	 * @return the list
	 */
	List<Map<String, Object>> obtenerParametros();

}
