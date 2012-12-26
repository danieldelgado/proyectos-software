package com.vst.hsd.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.vst.hsd.dominio.Lista;
import com.vst.hsd.dominio.Usuario;

public interface PrincipalService {

	Lista obtenerListaEntidad(String entidad, HttpSession sesion);

	Map<String, Object> obtenerData(Usuario usuario, String entidad, String sidx, String sord, int page, int rows, boolean _search, String searchField, String searchOper, String searchString);



}
