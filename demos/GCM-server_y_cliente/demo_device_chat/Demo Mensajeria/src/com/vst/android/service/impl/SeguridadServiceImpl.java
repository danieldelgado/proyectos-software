package com.vst.android.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.vst.android.service.SeguridadService;
import com.vst.android.util.Constantes;
import com.vst.android.util.HttpUtilConexiones;

/**
 * SeguridadServiceImpl clase que se encarga de gestionar el servicio de
 * seguridad con el servidor
 * 
 * @author ddelgado
 * 
 */
public class SeguridadServiceImpl implements SeguridadService {

	// Se crea el mismo objeto implementando SeguridadService pcon la finalidad
	// de no volver a crear el mismo objeto otra vez y acceder facilmente a sus
	// metodos como capa de servicio.
	private static SeguridadService serviceImpl = newInstanceInter();

	// permite el no crear el mismo objeto fuera de la clase, obliga a usar
	// newStaticInstance
	private SeguridadServiceImpl() {
	}

	/**
	 * Metodo que retorna el objeto SeguridadServiceImpl(serviceImpl) ya
	 * instaciado y acceder a los metodos de servicio
	 * 
	 * @return
	 */
	public static SeguridadService newStaticInstance() {
		return serviceImpl;
	}

	// retorna un nuevo objeto SeguridadService
	private static SeguridadService newInstanceInter() {
		return new SeguridadServiceImpl();
	}

	/**
	 * Valida si el regid y numero de telefono han sido registrados en el
	 * servidor
	 * 
	 * @throws JSONException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public boolean validarRegistroServidor(String regId) throws ClientProtocolException, IOException, JSONException {
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor");
		// objeto Map donde envio mis parametros
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regId", regId);
		Log.v(SeguridadServiceImpl.class.getName(), "params:" + params);
		// Mediante HttpUtilConexiones obtengo ej json donde esta mi respuesta
		// del servidor
		JSONObject json = HttpUtilConexiones.getJSONFromUrl(Constantes.url_server.URL_EXISTE_DISPOSITIVO, params);
		params = null;
		Log.v(SeguridadServiceImpl.class.getName(), "json:" + json);
		boolean r = (Boolean) json.get(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil);
		return r;
	}

	/**
	 * Registra en el servidor el dipositivO
	 * 
	 * @throws JSONException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public int registrarEnServidor(String regId, String numero, String email, int tipoRegistro) throws ClientProtocolException, IOException,
			JSONException {
		Log.v(SeguridadServiceImpl.class.getName(), "registrarEnServidor");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regId", regId);
		params.put("numero", numero);
		params.put("email", email);
		switch (tipoRegistro) {
		case Constantes.tipo_registro_mobile.DESDE_CLASE_GCMINTENT_SERVICE:
			params.put("tipo_registro_mobile", Constantes.tipo_registro_mobile.DESDE_CLASE_GCMINTENT_SERVICE);
			break;
		case Constantes.tipo_registro_mobile.DESDE_CLASE_MENSAJERIA_ACTIVITY:
			params.put("tipo_registro_mobile", Constantes.tipo_registro_mobile.DESDE_CLASE_MENSAJERIA_ACTIVITY);
			break;
		case Constantes.tipo_registro_mobile.DESDE_CLASE_REGISTRO_ACTIVITY:
			params.put("tipo_registro_mobile", Constantes.tipo_registro_mobile.DESDE_CLASE_REGISTRO_ACTIVITY);
			break;
		}
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor params:" + params);
		JSONObject json = HttpUtilConexiones.getJSONFromUrl(Constantes.url_server.URL_REGISTRAR_DISPOSITIVO_USUARIO, params);
		params = null;
		Log.v(SeguridadServiceImpl.class.getName(), "json:" + json);
		int r = (Integer) json.get(Constantes.respuestas_servidor.KEY_RESPUESTA_registrarDispositivoMovil);
		return r;
	}
}
