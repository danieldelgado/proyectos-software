package com.vst.hsd.service;

import javax.servlet.http.HttpServletRequest;

import com.vst.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The Interface RegistrarHistorialService.
 */
public interface RegistrarHistorialService {

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param valor the valor
	 * @param objRequest the obj request
	 */
	public void registrarHistorial(String clase, String metodo, Object valor,
			HttpServletRequest objRequest);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param objRequest the obj request
	 * @param objecto the objecto
	 */
	public void registrarHistorial(String clase, String metodo,
			HttpServletRequest objRequest, Object... objecto);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param valor the valor
	 */
	public void registrarHistorial(String clase, String metodo, Object valor);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param valor the valor
	 */
	public void registrarHistorial(String clase, String metodo, Object... valor);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 * @param valor the valor
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje,
			Object valor);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 * @param valor the valor
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje,
			Object... valor);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 * @param objRequest the obj request
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje,
			HttpServletRequest objRequest);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param entidad the entidad
	 * @param objRequest the obj request
	 */
	public void registrarHistorial(String clase, String metodo,
			Entidad entidad, HttpServletRequest objRequest);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param objRequest the obj request
	 * @param entidad the entidad
	 */
	public void registrarHistorial(String clase, String metodo,
			HttpServletRequest objRequest, Entidad... entidad);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 * @param entidad the entidad
	 * @param objRequest the obj request
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje,
			Entidad entidad, HttpServletRequest objRequest);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 * @param objRequest the obj request
	 * @param entidad the entidad
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje,
			HttpServletRequest objRequest, Entidad... entidad);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param entidad the entidad
	 */
	public void registrarHistorial(String clase, String metodo, Entidad entidad);

	/**
	 * Registrar historial.
	 *
	 * @param clase the clase
	 * @param metodo the metodo
	 * @param mensaje the mensaje
	 */
	public void registrarHistorial(String clase, String metodo, String mensaje);

	/**
	 * Registrar historial.
	 *
	 * @param mensaje the mensaje
	 * @param entidad the entidad
	 */
	public void registrarHistorial(String mensaje, Entidad... entidad);

	/**
	 * Registrar historial.
	 *
	 * @param mensaje the mensaje
	 * @param obj the obj
	 */
	public void registrarHistorial(String mensaje, Object obj);

	/**
	 * Registrar historial.
	 *
	 * @param mensaje the mensaje
	 * @param obj the obj
	 */
	public void registrarHistorial(String mensaje, Object... obj);

}
