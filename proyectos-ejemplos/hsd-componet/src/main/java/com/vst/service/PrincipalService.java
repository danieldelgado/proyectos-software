package com.vst.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.vst.dominio.Lista;
import com.vst.dominio.Usuario;

public interface PrincipalService {

	Lista obtenerListaEntidad(String entidad, HttpSession sesion);

	Map<String, Object> obtenerData(Usuario usuario, String entidad, String sidx, String sord, int page, int rows, boolean _search, String searchField, String searchOper, String searchString);



}
