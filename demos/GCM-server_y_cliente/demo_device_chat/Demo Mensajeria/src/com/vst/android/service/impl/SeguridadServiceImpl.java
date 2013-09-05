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

public class SeguridadServiceImpl implements SeguridadService {

	private Map<String, Object> params;
	
	@Override
	public boolean validarRegistroServidor(String regId, String numero) {
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor");
		params = new HashMap<String, Object>();
		params.put("regId", regId);
		params.put("numero", numero);
		Log.v(SeguridadServiceImpl.class.getName(), "params:"+params);
		try {
			JSONObject json =  HttpUtilConexiones.resppost(Constantes.URL_SERVER.URL_EXISTE_NUMERO, params );
			params = null;
			Log.v(SeguridadServiceImpl.class.getName(), "json:"+json);
			int r = (Integer) json.get("resp");
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

	@Override
	public int registrarEnServidor(String regId, String numero, String email) {
		params = new HashMap<String, Object>();
		params.put("regId", regId);
		params.put("numero", numero);
		params.put("email", email);
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor params:"+params);
		long backoff = Constantes.RANGOS.BACKOFF_MILLI_SECONDS + Constantes.RANGOS.RANDOM.nextInt(1000);
		for (int i = 1; i <= Constantes.RANGOS.MAX_ATTEMPTS; i++) {
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
		
		
		
//		try {
//			JSONObject json =  HttpUtilConexiones.getJSONFromUrl(Constantes.URL_SERVER.URL_REGISTRAR_DISPOSITIVO_USUARIO, params );
//			Log.v(SeguridadServiceImpl.class.getName(), "json:"+json);
//			int r = (Integer) json.get("resp");
//			if(r>0){
//				return 1;
//			}
//		} catch (IOException e) {	
//			e.printStackTrace();
//			return 0;
//		} catch (JSONException e) {
//			e.printStackTrace();
//			return 0;
//		}			
		return -1;
	}

}
