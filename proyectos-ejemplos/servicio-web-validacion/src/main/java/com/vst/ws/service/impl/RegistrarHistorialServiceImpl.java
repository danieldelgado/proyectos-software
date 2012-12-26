package com.vst.ws.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vst.dao.HistorialDAO;
import com.vst.dominio.Historial;
import com.vst.ws.service.RegistrarHistorialService;
import com.vst.util.Entidad;
import com.vst.util.Util;

@Service("RegistrarHistorialService")
public class RegistrarHistorialServiceImpl implements RegistrarHistorialService {

	private static Logger log = LoggerFactory.getLogger(RegistrarHistorialServiceImpl.class);

	@Autowired
	private HistorialDAO historialDAO;

	@Transactional
	public void registrarHistorial(String clase, String metodo, Object valor, HttpServletRequest objRequest) {
		log.info("[  metodo:guardarHistorial - objeto:"+Util.getJson(valor)+" ]");
		try {
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}

			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			if(valor!=null){
				h.setValor(Util.getJson(valor));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, Entidad valor) {
		log.info("[  metodo:guardarHistorial - objeto:"+Util.getJson(valor)+" ]");
		try {
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setValor(Util.getJsonObject(valor));
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje) {
		log.info("[  metodo:guardarHistorial - mensaje:"+mensaje+" ]");
		try {
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setValor(mensaje);
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje, HttpServletRequest objRequest) {
		log.info("[  metodo:guardarHistorial - mensaje:"+mensaje+" ]");
		try {
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}

			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			h.setDescripcion(mensaje);	
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, Entidad entidad, HttpServletRequest objRequest) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJsonObject(entidad)+" ]");
		try {
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}

			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			if(entidad!=null){
				h.setValor(Util.getJsonObject(entidad));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String mensaje, Entidad... entidad) {
		log.info("[  metodo:guardarHistorial - mensaje:"+mensaje+" , entidad(s):"+Util.getJson(entidad)+" ]");
		try {
			
			Historial h = new Historial();
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setValor(Util.getJson(entidad));
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje, Object valor) {
		log.info("[  metodo:guardarHistorial - mensaje:"+mensaje+" , valor:"+Util.getJson(valor)+" ]");
		try {
			
			Historial h = new Historial();
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setDescripcion(mensaje);
			h.setValor(Util.getJson(valor));
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, HttpServletRequest objRequest, Object... objecto) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(objecto)+" ]");
		try {
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}

			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			if(objecto!=null){
				h.setValor(Util.getJson(objecto));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, Object valor) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(valor)+" ]");
		try {
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			if(valor!=null){
				h.setValor(Util.getJson(valor));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, Object... valor) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(valor)+" ]");
		try {
			String jsonRequest = "";
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			if(valor!=null){
				h.setValor(Util.getJson(valor));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje, Object... valor) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(valor)+" ]");
		try {			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setDescripcion(mensaje);
			if(valor!=null){
				h.setValor(Util.getJson(valor));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, HttpServletRequest objRequest, Entidad... entidad) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(entidad)+" ]");
		try {		
			
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			if(entidad!=null){
				h.setValor(Util.getJson(entidad));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje, Entidad entidad, HttpServletRequest objRequest) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(entidad)+" ]");
		try {		
			
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			h.setDescripcion(mensaje);
			if(entidad!=null){
				h.setValor(Util.getJson(entidad));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

	@Transactional
	public void registrarHistorial(String clase, String metodo, String mensaje, HttpServletRequest objRequest, Entidad... entidad) {
		log.info("[  metodo:guardarHistorial - entidad:"+Util.getJson(entidad)+" ]");
		try {		
			
			String jsonRequest = "";
			if (objRequest != null) {
				jsonRequest = Util.getJson(
						"contextPath:" + objRequest.getContextPath(), 
						"localAddr:" + objRequest.getLocalAddr(), 
						"scheme:"+ objRequest.getScheme(), 
						"serverName:" + objRequest.getServerName(), 
						"requestURI:" + objRequest.getRequestURI(),
						"requestURL:" + objRequest.getRequestURL().toString(), 
						"queryString:" + objRequest.getQueryString(), 
						"requestedSessionId:"+ objRequest.getRequestedSessionId(), 
						"remoteAddr:" + objRequest.getRemoteAddr());
			}
			
			Historial h = new Historial();
			h.setClase(clase);
			h.setMetodo(metodo);
			h.setCodigo(Util.getCodigo(h));
			h.setFechaRegistro(new Date());
			h.setRequest(jsonRequest);
			h.setDescripcion(mensaje);
			if(entidad!=null){
				h.setValor(Util.getJson(entidad));				
			}			
			historialDAO.guardar(h);
			
		} catch (Exception e) {
			log.error("Error con guardarHistorial " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}


}
