package com.vst.hsd.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrincipalService.
 */
public interface PrincipalService {

	/**
	 * Obtener lista entidad.
	 *
	 * @param entidad the entidad
	 * @param sesion the sesion
	 * @return the lista
	 */
	public Lista obtenerListaEntidad(String entidad, HttpSession sesion);

	/**
	 * Obtener data.
	 *
	 * @param usuario the usuario
	 * @param entidad the entidad
	 * @param sidx the sidx
	 * @param sord the sord
	 * @param page the page
	 * @param rows the rows
	 * @param _search the _search
	 * @param searchField the search field
	 * @param searchOper the search oper
	 * @param searchString the search string
	 * @return the map
	 */
	public Map<String, Object> obtenerData(Usuario usuario, String entidad,
			String sidx, String sord, int page, int rows, boolean _search,
			String searchField, String searchOper, String searchString);

	/**
	 * Obtener menus por perfil.
	 *
	 * @param u the u
	 * @return the list
	 */
	public List<Menu> obtenerMenusPorPerfil(Usuario u);

	/**
	 * Obtener botones por menu default.
	 *
	 * @param lstMenus the lst menus
	 * @return the list
	 */
	public List<Boton> obtenerBotonesPorMenuDefault(List<Menu> lstMenus);

	/**
	 * Obtener botones por menu.
	 *
	 * @param idmenu the idmenu
	 * @return the list
	 */
	public List<Boton> obtenerBotonesPorMenu(Integer idmenu);

}
