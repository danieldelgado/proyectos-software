package com.vst.hsd.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.vst.hsd.dominio.Boton;
import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Menu;
import com.vst.hsd.dominio.Usuario;

public interface PrincipalService {

	public Lista obtenerListaEntidad(String entidad, HttpSession sesion);

	public Map<String, Object> obtenerData(Usuario usuario, String entidad, String sidx, String sord, int page, int rows, boolean _search, String searchField, String searchOper, String searchString);

	public List<Menu> obtenerMenusPorPerfil(Usuario u);

	public List<Boton> obtenerBotonesPorMenuDefault(List<Menu> lstMenus);

}
