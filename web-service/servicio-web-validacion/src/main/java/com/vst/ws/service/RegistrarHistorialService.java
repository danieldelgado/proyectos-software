package com.vst.ws.service;

import javax.servlet.http.HttpServletRequest;

import com.vst.util.Entidad;


public interface RegistrarHistorialService {

	public void registrarHistorial(String clase,String metodo,Object valor, HttpServletRequest objRequest);
	
	public void registrarHistorial(String clase,String metodo, HttpServletRequest objRequest,Object... objecto);

	public void registrarHistorial(String clase,String metodo,Object valor);
	
	public void registrarHistorial(String clase,String metodo,Object... valor);
	
	public void registrarHistorial(String clase,String metodo,String mensaje ,Object valor);
	
	public void registrarHistorial(String clase,String metodo,String mensaje ,Object... valor);
	
	public void registrarHistorial(String clase,String metodo,String mensaje, HttpServletRequest objRequest);

	public void registrarHistorial(String clase,String metodo,Entidad entidad, HttpServletRequest objRequest);
	
	public void registrarHistorial(String clase,String metodo, HttpServletRequest objRequest,Entidad... entidad);

	public void registrarHistorial(String clase,String metodo,String mensaje,Entidad entidad, HttpServletRequest objRequest);
	
	public void registrarHistorial(String clase,String metodo,String mensaje, HttpServletRequest objRequest,Entidad... entidad);

	public void registrarHistorial(String clase,String metodo,Entidad entidad);

	public void registrarHistorial(String clase,String metodo,String mensaje);
	
	public void registrarHistorial(String mensaje,Entidad... entidad);
	
}
