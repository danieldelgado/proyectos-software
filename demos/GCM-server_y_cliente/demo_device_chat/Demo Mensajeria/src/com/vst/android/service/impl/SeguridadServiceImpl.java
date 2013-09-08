package com.vst.android.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.vst.android.beans.DispositivoMovil;
import com.vst.android.beans.Usuario;
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
		inicializarInstanciasUsuarioDispositivoMovil(json);		
		return r;
	}

	private void inicializarInstanciasUsuarioDispositivoMovil(JSONObject json) throws JSONException {
		String jsonDis =  json.getString(Constantes.respuestas_servidor.KEY_OBJETO_DIPOSITIVO);
		json = new JSONObject(jsonDis);		
		Integer id = json.getInt("id");		
		String key_device = json.getString("key_device");	
		String numeromovil = json.getString("numeromovil");	
		String usuario = json.getString("usuario");		
		json = new JSONObject(usuario);	
		DispositivoMovil dispositivoMovil = new DispositivoMovil();
		dispositivoMovil.setId(id);
		dispositivoMovil.setKey_device(key_device);
		dispositivoMovil.setNumeromovil(numeromovil);
		Integer idU  = json.getInt("id");			
		String userName  = json.getString("userName");		
		String clave  = json.getString("clave");			
		String nombre  = json.getString("nombre");		
		String apellido  = json.getString("apellido");		
		String email = json.getString("email");		;
		Usuario us = new Usuario();
		us.setId(idU);
		us.setUserName(userName);
		us.setClave(clave);
		us.setNombre(nombre);
		us.setApellido(apellido);
		us.setEmail(email);
		Constantes.instance.DISPOSITIVOMOVIL_SERVER = dispositivoMovil;
		Constantes.instance.USUARIO_SERVER = us;		
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
