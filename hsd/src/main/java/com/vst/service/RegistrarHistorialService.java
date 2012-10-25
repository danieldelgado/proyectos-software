package com.vst.service;

import javax.servlet.http.HttpServletRequest;

public interface RegistrarHistorialService {

	public void guardarHistorial(HttpServletRequest objRequest);

	public void guardarHistorial(Object objeto,String metodo, HttpServletRequest objRequest);

}
