package com.demo.geolocalizacion.ws.endpoint;

import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.geolocalizacion.dominio.Telefono;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Util;
@Service("WebServiceGeolocalizacion")
@WebService(serviceName = "WebServiceGeolocalizacion")
public class WebServiceGeolocalizacion {
	//http://localhost:9998/WebServiceGeolocalizacion?wsdl	
	private static final Logger logger = LoggerFactory.getLogger(WebServiceGeolocalizacion.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@WebMethod	
	public String sayHello(@WebParam(name="msj")  String msj) {
		logger.info(" msj: "+msj);
		return " respuesta msj: " + msj;
	}

	@WebMethod	
	public Integer existeUsuarioPorNumero(@WebParam(name="numero") String numero) {
		logger.info("numero_usuario_existe numero: "+numero);
		int existeUsuarioPorNumero = usuarioService.validarUsuarioPorNumeroRegistrado(numero);
		logger.info("existeUsuarioPorNumero repuesta : "+existeUsuarioPorNumero);
		return existeUsuarioPorNumero;
	}


	@WebMethod	
	public  String registrarUsuariaPorTelefono(@WebParam(name="usuario_telefono") Telefono telefono) {
		logger.info("registrarUsuariaPorTelefono obtelefono: "+Util.getJsonObject(telefono));		
		Map<String, Object> registrarUsuario = usuarioService.registrarUsuario_Telefono(telefono);	
		logger.info("registrarUsuario repuesta : "+registrarUsuario);
		return Util.getJson(registrarUsuario);
	}
	
	
	@WebMethod
	public Integer registrarGeolocalizacion(@WebParam(name="numero") String numero,@WebParam(name="latitud")  String latitud,
			@WebParam(name="longitud") String longitud) {
		logger.info(" numero: "+numero);
		logger.info(" latitud: "+latitud);
		logger.info(" longitud: "+longitud);				
		return 0;
	}

}
