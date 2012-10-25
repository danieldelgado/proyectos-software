package com.vst.service;

import javax.servlet.http.HttpServletRequest;

import com.vst.dominio.Usuario;

public interface RegistrarHistorialService {

	public void guardarHistorial(HttpServletRequest objRequest);

	public void guardarHistorial(Object objeto,String metodo, HttpServletRequest objRequest);

	public void guardarObjetoHIstorial(String string, Usuario u);

}
