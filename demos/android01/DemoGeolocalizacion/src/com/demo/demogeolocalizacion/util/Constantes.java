package com.demo.demogeolocalizacion.util;


public class Constantes {

	public static final String SOAP_ACTION = "http://endpoint.ws.geolocalizacion.demo.com/geolocalizacion";
  
	public static final String NAMESPACE = "http://endpoint.ws.geolocalizacion.demo.com/";
	public static final String URL = "http://192.168.1.34:9998/WebServiceGeolocalizacion?wsdl";
	public static final String EXISTE_USUARIO_POR_NUMERO_WS="existeUsuarioPorNumero";
	public static final String REGISTRAR_USUARIO_POR_TELEFONO_WS="registrarUsuarioPorTelefono";
	public static final String REGISTRAR_PUNTO_GEOLOCALIZACION_WS="registrarPuntoGeolocalizacion";
	public static final Integer ERROR_CONEXION_SERVIDOR = -2 ;
	
	
	public static final int ERROR_SERVER= 0;
	public static final int USUARIO_NO_EXISTE = -1;
	public static final int USUARIO_EXISTE = 1;
	
	public static final String FORMATO_TELEFONO="^[9|6][0-9]{8}";
	public static final String FORMATO_NOMBRE="[a-z'A-ZÃ±Ã‘Ã¡Ã©Ã­Ã³ÃºÃ�Ã‰Ã�Ã“ÃšÃ¼Ãœ\\s-]+";
	public static final String FORMATO_FECHA_DD_MM_YYYY="dd/MM/yyyy";
	
	
	public static final int NO_CUMPLE_CON_FORMATO = 2;
	public static final int REGISTRADO = 1;
	public static final int NO_REGISTRADO = 3;
	
}
