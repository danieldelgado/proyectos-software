package com.demo.demogeolocalizacion.ws.client;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.demo.demogeolocalizacion.util.Constantes;

public class GeolocalizacionWService {
	// http://192.168.43.123:9998/WebServiceGeolocalizacion?wsdlhttp://endpoint.ws.geolocalizacion.demo.com

	public static Integer existeUsuarioPorNumero(String numero) {
		Integer existe = null;
		SoapObject request = new SoapObject(Constantes.NAMESPACE,Constantes.EXISTE_USUARIO_POR_NUMERO_WS);
		request.addProperty("numero", numero);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.setOutputSoapObject(request);
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Constantes.URL);
			androidHttpTransport.call(Constantes.SOAP_ACTION, envelope);
			SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
			String resp = result.toString();
			existe = Integer.valueOf(resp);
		} catch (Exception e) {
			e.printStackTrace();
			existe = Constantes.ERROR_CONEXION_SERVIDOR;
		}
		return existe;
	}
	
	/*Devolvera un String en formato Json*/
	public static String registrarUsuarioPorTelefono(String nombres, String apellidos, String fechaNacimiento, String numero) {
		String registrado = null;
		SoapObject request = new SoapObject(Constantes.NAMESPACE,Constantes.REGISTRAR_USUARIO_POR_TELEFONO_WS);
		request.addProperty("nombres", nombres);
		request.addProperty("apellidos",apellidos);
		request.addProperty("fechaNacimiento", fechaNacimiento);
		request.addProperty("numero", numero);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.setOutputSoapObject(request);
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Constantes.URL);
			androidHttpTransport.call(Constantes.SOAP_ACTION, envelope);
			SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
			registrado = result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			registrado = String.valueOf(Constantes.ERROR_CONEXION_SERVIDOR);
		}
		return registrado;
	}
	
	public static Integer registrarPuntoGeolocalizacion(Boolean flagPuntoInicial, String numero, String latitud, String longitud) {
		Integer registrado = null;
		SoapObject request = new SoapObject(Constantes.NAMESPACE,Constantes.REGISTRAR_PUNTO_GEOLOCALIZACION_WS);
		request.addProperty("flagPuntoInicial", flagPuntoInicial);
		request.addProperty("numero",numero);
		request.addProperty("latitud", latitud);
		request.addProperty("longitud", longitud);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.setOutputSoapObject(request);
		try {
			HttpTransportSE androidHttpTransport = new HttpTransportSE(Constantes.URL);
			androidHttpTransport.call(Constantes.SOAP_ACTION, envelope);
			SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
			String resp = result.toString();
			registrado = Integer.valueOf(resp);
		} catch (Exception e) {
			e.printStackTrace();
			registrado = Constantes.ERROR_CONEXION_SERVIDOR;
		}
		return registrado;
	}

	//
	// public String Convert(String fromCurrency) {
	// SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	// request.addProperty("msj", fromCurrency);
	//
	// SoapSerializationEnvelope envelope = new
	// SoapSerializationEnvelope(SoapEnvelope.VER11);
	// envelope.dotNet = false;
	// envelope.setOutputSoapObject(request);
	// System.out.println(request);
	// try {
	// HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	// androidHttpTransport.call(SOAP_ACTION, envelope);
	// // System.out.println(envelope);
	// SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
	// // System.out.println(result);
	// return result.toString();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return e.getMessage();
	// }
	// }
	//
	// public String Convert2() {
	//
	// SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	// request.addProperty("nombre", "Anisella");
	// request.addProperty("apellidos", "Danielle mongolo");
	// request.addProperty("fechaNacimiento",
	// "1990-12-06T09:47:46.8942117-04:00");
	// request.addProperty("numero", "923456789");
	//
	// SoapSerializationEnvelope envelope = new
	// SoapSerializationEnvelope(SoapEnvelope.VER11);
	// envelope.dotNet = false;
	// envelope.setOutputSoapObject(request);
	// System.out.println(request);
	// try {
	// HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	// androidHttpTransport.call(SOAP_ACTION, envelope);
	// // System.out.println(envelope);
	// SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
	// // System.out.println(result);
	// return result.toString();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return e.getMessage();
	// }
	// }
}
