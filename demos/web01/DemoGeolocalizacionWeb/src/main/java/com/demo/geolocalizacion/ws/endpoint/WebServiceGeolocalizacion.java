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
import com.demo.geolocalizacion.service.GeolocalizacionService;
import com.demo.geolocalizacion.service.UsuarioService;
import com.demo.geolocalizacion.util.Util;
@Service("WebServiceGeolocalizacion")
@WebService(serviceName = "WebServiceGeolocalizacion")
public class WebServiceGeolocalizacion {
	//http://localhost:9998/WebServiceGeolocalizacion?wsdl	
	private static final Logger logger = LoggerFactory.getLogger(WebServiceGeolocalizacion.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private GeolocalizacionService geolocalizacionService;
		
	/**
	 * Es un metodo para hacer una prueba simple de hola mundo con el simple web serivce de spring
	 * solo es necesario ingresar un parametro cadena
	 * @param msj
	 * @return
	 */
	@WebMethod	
	public String sayHello(@WebParam(name="msj")  String msj) {
		logger.info(" msj: "+msj);
		return " respuesta msj: " + msj;
	}

	/**
	 * Se realiza la consulta, si un numero en la base de datos a sido registrado
	 * retorna:
	 * 1  si existe
	 * 0  si  ocurre algun error al hacer la busqueda
	 * -1 no existe en la base de datos
	 * @param numero
	 * @return
	 */
	@WebMethod	
	public Integer existeUsuarioPorNumero(@WebParam(name="numero") String numero) {
		logger.info("numero_usuario_existe numero: "+numero);
		int existeUsuarioPorNumero = usuarioService.validarUsuarioPorNumeroRegistrado(numero);
		logger.info("existeUsuarioPorNumero repuesta : "+existeUsuarioPorNumero);
		return existeUsuarioPorNumero;
	}

	/**
	 * Se le envia el objeto Telefono(hereda de la entidad usuario asi q tiene todos sus atributos) para guardar
	 * en la base de datos, pero, tambien valida sus campos y el numero ingresado si ya a sido registrado anteriormente
	 * 
	 * retorna una cadena en formato json con maximos de 2 parametros
	 * 
	 * paramtro registro es el valor si a sido registrado o no  
	 * 					    1 = Registrado
	 * 						2 = No cumple el formato (en el caso de los campos con error) y retornara un parametro mas que una lista de campos con error
	 * 						3 = Es cuando el usuario intenta registrarse y el numero de telefono ya existe ne la base de datos, no se registra.
	 * 						-1= Es que el objeto es nulo
	 * 						0 = Si ocurre algun error en la base de datos
	 * 
	 * @param telefono
	 * @return
	 */
	//	web service fecha nacimiento 1990-12-06T09:47:46.8942117-04:00 -- > esto sirve al hacer las pruebas con el web service en las fechas q son de la clase DATE
	@WebMethod	
	public  String registrarUsuariaPorTelefono(@WebParam(name="usuario_telefono") Telefono telefono ) {
		logger.info("registrarUsuariaPorTelefono obtelefono: "+Util.getJsonObject(telefono));		
		Map<String, Object> registrarUsuario = usuarioService.registrarUsuario_Telefono(telefono);	
		String rspt = Util.getJson(registrarUsuario);
		logger.info("registrarUsuario repuesta  rspt: "+rspt);
		return rspt;
	}
		
	/**
	 * Registra los puntos de geolocalizacion cada vez q se ingresa un nuevo punto de ubicacion inicial
	 * 
	 * al ser el flag true es uno nuevo
	 * al ser el flag false se mantiene en el punto anterior
	 * paramtro registro es el valor si a sido registrado o no  
	 * 					    1 = Registrado
	 * 						2 = No cumple el formato (en el caso de los campos con error) y retornara un parametro mas que una lista de campos con error
	 * 						-1= Es que el objeto es nulo
	 * 
	 * @param flagPuntoInicial
	 * @param numero
	 * @param latitud
	 * @param longitud
	 * @return
	 */
	@WebMethod
	public Integer registrarPuntoGeolocalizacion(@WebParam(name="flagPuntoInicial") boolean flagPuntoInicial,@WebParam(name="numero") String numero,@WebParam(name="latitud")  String latitud,
			@WebParam(name="longitud") String longitud) {
		logger.info(" registrarGeolocalizacion numero: "+numero+" latitud: "+latitud+" longitud: "+longitud+"  flagPuntoInicial :"+flagPuntoInicial);		
		int resptRegistrarPuntoGeolocalizacion = geolocalizacionService.registrarPuntoGeolocalizacion(flagPuntoInicial,numero,latitud,longitud);
		logger.info("registrarPuntoGeolocalizacion resptRegistrarPuntoGeolocalizacion : "+resptRegistrarPuntoGeolocalizacion);		
		return resptRegistrarPuntoGeolocalizacion;
	}

}
