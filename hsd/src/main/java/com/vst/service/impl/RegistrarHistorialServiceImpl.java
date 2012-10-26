package com.vst.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.HistorialDAO;
import com.vst.dominio.Historial;
import com.vst.dominio.Usuario;
import com.vst.filtro.FiltroSeguridad;
import com.vst.service.RegistrarHistorialService;
import com.vst.util.Util;

@Service("RegistrarHistorialService")
public class RegistrarHistorialServiceImpl implements RegistrarHistorialService {

	private static Logger log=LoggerFactory.getLogger(RegistrarHistorialServiceImpl.class);
	
	@Autowired
	private HistorialDAO historialDAO;
	
	@Transactional
	public void guardarHistorial(HttpServletRequest objRequest) {
		Historial h = new Historial();
		h.setClase("");
		
	}

	@Transactional
	public void guardarHistorial(Object objeto, String metodo, HttpServletRequest objRequest) {
		log.info("RegistrarHistorialServiceImpl Metodo guardarHistorial");
		try {
		/*	objRequest.getContextPath();
			objRequest.getLocalAddr();
			objRequest.getServletPath();
			objRequest.getScheme();
			objRequest.getServerName();
			objRequest.getRequestURI();
			objRequest.getRequestURL().toString();
			objRequest.getRequestedSessionId();
			objRequest.getRemoteAddr();*/						
			String json = Util.getJson(
					"contextPath:"+objRequest.getContextPath(),
					"localAddr:"+objRequest.getLocalAddr(),
					"scheme:"+objRequest.getScheme(),
					"serverName:"+objRequest.getServerName(),
					"requestURI:"+objRequest.getRequestURI(),
					"requestURL:"+objRequest.getRequestURL().toString(),
					"queryString:"+objRequest.getQueryString(),
					"requestedSessionId:"+objRequest.getRequestedSessionId(),
					"remoteAddr:"+objRequest.getRemoteAddr()				
					);
			Historial h = new Historial();
			h.setCodigo(Util.getCodigo(h));
			h.setClase(objeto.getClass().getSimpleName());
			h.setMetodo(metodo);
			h.setFechaRegistro(new Date());
			h.setValor(json);					
			historialDAO.guardar(h);
			log.info("registrado  Historial :"+Util.getJsonObject(h));			
		} catch (Exception e) {
			log.error("Erro con guardarHistorial "+e.getMessage());
			e.printStackTrace();
		}		
	}

	public void guardarObjetoHIstorial(String string, Usuario u) {
		log.info("RegistrarHistorialServiceImpl Metodo guardarObjetoHIstorial");
		try {							
			String json = Util.getJsonObject(u);
			Historial h = new Historial();
			h.setCodigo(Util.getCodigo(h));
			h.setClase(u.getClass().getSimpleName());
			h.setMetodo(string);
			h.setFechaRegistro(new Date());
			h.setValor(json);					
			historialDAO.guardar(h);
			log.info("registrado  Historial :"+Util.getJsonObject(h));			
		} catch (Exception e) {
			log.error("Erro con guardarHistorial "+e.getMessage());
			e.printStackTrace();
		}		
		
	}

	

}
