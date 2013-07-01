package com.vst.hsd.service.impl;

import org.springframework.stereotype.Service;

import com.vst.hsd.service.RegistrarHistorialService;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrarHistorialServiceImpl.
 */
@Service("RegistrarHistorialService")
public class RegistrarHistorialServiceImpl implements RegistrarHistorialService {
	//
	// /** The log. */
	// private static Logger log = LoggerFactory
	// .getLogger(RegistrarHistorialServiceImpl.class);
	//
	// /** The historial dao. */
	// @Autowired
	// private HistorialDAO historialDAO;
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.Object,
	// javax.servlet.http.HttpServletRequest)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, Object valor,
	// HttpServletRequest objRequest) {
	// log.debug("[ metodo:guardarHistorial - objeto:" + Util.getJson(valor)
	// + " ]");
	// try {
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// if (valor != null) {
	// h.setValor(Util.getJson(valor));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, com.vst.util.Entidad)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, Entidad
	// valor) {
	// log.debug("[ metodo:guardarHistorial - objeto:" + Util.getJson(valor)
	// + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// if (valor != null) {
	// h.setValor(Util.getJsonObject(valor));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje) {
	// log.debug("[ - metodo:guardarHistorial - mensaje:" + mensaje + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setValor(mensaje);
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String,
	// javax.servlet.http.HttpServletRequest)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje,
	// HttpServletRequest objRequest) {
	// log.debug("[ - metodo:guardarHistorial - mensaje:" + mensaje + " ]");
	// try {
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// h.setDescripcion(mensaje);
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, com.vst.util.Entidad,
	// javax.servlet.http.HttpServletRequest)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo,
	// Entidad entidad, HttpServletRequest objRequest) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJsonObject(entidad) + " ]");
	// try {
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// if (entidad != null) {
	// h.setValor(Util.getJsonObject(entidad));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// com.vst.util.Entidad[])
	// */
	// @Transactional
	// public void registrarHistorial(String mensaje, Entidad... entidad) {
	// log.debug("[ - metodo:guardarHistorial - mensaje:" + mensaje
	// + " , entidad(s):" + Util.getJson(entidad) + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setValor(Util.getJson(entidad));
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String, java.lang.Object)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje,
	// Object valor) {
	// log.debug("[ - metodo:guardarHistorial - mensaje:" + mensaje
	// + " , valor:" + Util.getJson(valor) + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setDescripcion(mensaje);
	// h.setValor(Util.getJson(valor));
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, javax.servlet.http.HttpServletRequest,
	// java.lang.Object[])
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo,
	// HttpServletRequest objRequest, Object... objecto) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(objecto) + " ]");
	// try {
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// if (objecto != null) {
	// h.setValor(Util.getJson(objecto));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.Object)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, Object valor)
	// {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(valor) + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// if (valor != null) {
	// h.setValor(Util.getJson(valor));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.Object[])
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, Object...
	// valor) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(valor) + " ]");
	// try {
	// String jsonRequest = "";
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// if (valor != null) {
	// h.setValor(Util.getJson(valor));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String, java.lang.Object[])
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje,
	// Object... valor) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(valor) + " ]");
	// try {
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setDescripcion(mensaje);
	// if (valor != null) {
	// h.setValor(Util.getJson(valor));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, javax.servlet.http.HttpServletRequest,
	// com.vst.util.Entidad[])
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo,
	// HttpServletRequest objRequest, Entidad... entidad) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(entidad) + " ]");
	// try {
	//
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// if (entidad != null) {
	// h.setValor(Util.getJson(entidad));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String, com.vst.util.Entidad,
	// javax.servlet.http.HttpServletRequest)
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje,
	// Entidad entidad, HttpServletRequest objRequest) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(entidad) + " ]");
	// try {
	//
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// h.setDescripcion(mensaje);
	// if (entidad != null) {
	// h.setValor(Util.getJson(entidad));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.String, java.lang.String,
	// javax.servlet.http.HttpServletRequest, com.vst.util.Entidad[])
	// */
	// @Transactional
	// public void registrarHistorial(String clase, String metodo, String
	// mensaje,
	// HttpServletRequest objRequest, Entidad... entidad) {
	// log.debug("[ - metodo:guardarHistorial - entidad:"
	// + Util.getJson(entidad) + " ]");
	// try {
	//
	// String jsonRequest = "";
	// if (objRequest != null) {
	// jsonRequest = Util.getJson(
	// "contextPath:" + objRequest.getContextPath(),
	// "localAddr:" + objRequest.getLocalAddr(),
	// "scheme:" + objRequest.getScheme(),
	// "serverName:" + objRequest.getServerName(),
	// "requestURI:" + objRequest.getRequestURI(),
	// "requestURL:" + objRequest.getRequestURL().toString(),
	// "queryString:" + objRequest.getQueryString(),
	// "requestedSessionId:"
	// + objRequest.getRequestedSessionId(),
	// "remoteAddr:" + objRequest.getRemoteAddr());
	// }
	//
	// Historial h = new Historial();
	// h.setClase(clase);
	// h.setMetodo(metodo);
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setRequest(jsonRequest);
	// h.setDescripcion(mensaje);
	// if (entidad != null) {
	// h.setValor(Util.getJson(entidad));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con guardarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	//
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.Object)
	// */
	// public void registrarHistorial(String mensaje, Object obj) {
	// log.debug("[ - metodo: registrarHistorial  - entidad:"
	// + Util.getJson(obj) + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setDescripcion(mensaje);
	// if (obj != null) {
	// h.setValor(Util.getJson(obj));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con registrarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	// }
	//
	// /* (non-Javadoc)
	// * @see
	// com.vst.hsd.service.RegistrarHistorialService#registrarHistorial(java.lang.String,
	// java.lang.Object[])
	// */
	// public void registrarHistorial(String mensaje, Object... obj) {
	// log.debug("[ - metodo: registrarHistorial  - entidad:"
	// + Util.getJson(obj) + " ]");
	// try {
	//
	// Historial h = new Historial();
	// h.setCodigo(Util.getCodigo(h));
	// h.setFechaRegistro(new Date());
	// h.setDescripcion(mensaje);
	// if (obj != null) {
	// h.setValor(Util.getJson(obj));
	// }
	// historialDAO.guardar(h);
	//
	// } catch (Exception e) {
	// log.error("Error con registrarHistorial " + e.getMessage());
	// e.printStackTrace();
	// }
	// }

}
