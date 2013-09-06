package com.vst.android.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.vst.android.service.SeguridadService;
import com.vst.android.util.Constantes;
import com.vst.android.util.HttpUtilConexiones;

/**
 * SeguridadServiceImpl clase que se encarga de gestionar el servicio de seguridad con el servidor
 * @author ddelgado
 *
 */
public class SeguridadServiceImpl implements SeguridadService {
	
	//Se crea el mismo objeto implementando  SeguridadService pcon la finalidad de no volver a crear el mismo objeto otra vez y acceder facilmente a sus metodos como capa de servicio.
	private static SeguridadService serviceImpl = newInstanceInter();	
	
	// permite el no crear el mismo objeto fuera de la clase, obliga a usar newStaticInstance
	private SeguridadServiceImpl() {
	}
	
	/**
	 * Metodo que retorna el objeto SeguridadServiceImpl(serviceImpl) ya instaciado y acceder a los metodos de servicio
	 * @return
	 */
	public static SeguridadService newStaticInstance(){
		return  serviceImpl;
	}	
	// retorna un nuevo objeto SeguridadService
	private static SeguridadService newInstanceInter(){
		return  new SeguridadServiceImpl();
	}
	
	/**
	 * Valida si el regid y numero de telefono han sido registrados en el servidor
	 */
	public  boolean validarRegistroServidor(String regId, String numero) {		
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor");
		Map<String, Object> params = new HashMap<String, Object>();//objeto Map donde envio mis parametros
		params.put("regId", regId);
		params.put("numero", numero);
		Log.v(SeguridadServiceImpl.class.getName(), "params:"+params);
		try {
			//Mediante HttpUtilConexiones obtengo ej json donde esta mi respuesta del servidor
			JSONObject json =  HttpUtilConexiones.getJSONFromUrl(Constantes.URL_SERVER.URL_EXISTE_NUMERO, params );
			params = null;
			Log.v(SeguridadServiceImpl.class.getName(), "json:"+json);
			int r = (Integer) json.get("resp");//respuesta del servidor
			if(r>0){
				return true;
			}
		} catch (IOException e) {	
			
			e.printStackTrace();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}	
		return false;
	}

	/**
	 * Registra en el servidor el dipositivo	 * 
	 */
	public int registrarEnServidor(String regId, String numero, String email) {
		Log.v(SeguridadServiceImpl.class.getName(), "registrarEnServidor");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regId", regId);
		params.put("numero", numero);
		params.put("email", email);
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor params:"+params);
		long backoff = Constantes.RANGOS.BACKOFF_MILLI_SECONDS + Constantes.RANGOS.RANDOM.nextInt(1000);
		for (int i = 1; i <= Constantes.RANGOS.MAX_ATTEMPTS; i++) { // Se dan interancciones en los intentos de conexion al servidor
			try {				
				JSONObject json =  HttpUtilConexiones.getJSONFromUrl(Constantes.URL_SERVER.URL_REGISTRAR_DISPOSITIVO_USUARIO, params );
				params = null;
				Log.v(SeguridadServiceImpl.class.getName(), "json:"+json);
				int r = (Integer) json.get("resp");
				if(r>0){
					return 1;
				}
			} catch (Exception e) {				
				if (i == Constantes.RANGOS.MAX_ATTEMPTS) {
					break;
				}
				try {
					Thread.sleep(backoff);
				} catch (InterruptedException e1) {
					Thread.currentThread().interrupt();
					return 0;
				}
				backoff *= 2;
				e.printStackTrace();
			}
		}				
		return -1;
	}

}
