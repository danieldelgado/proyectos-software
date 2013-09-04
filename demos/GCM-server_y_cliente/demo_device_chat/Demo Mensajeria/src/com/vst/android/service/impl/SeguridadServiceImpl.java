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

	@Override
	public boolean validarRegistroServidor(String regId, String numero) {
		Log.v(SeguridadServiceImpl.class.getName(), "validarRegistroServidor");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("regId", regId);
		params.put("numero", numero);
		Log.v(SeguridadServiceImpl.class.getName(), "params:"+params);
		try {
			JSONObject json =  HttpUtilConexiones.resppost(Constantes.URL_SERVER.URL_EXISTE_NUMERO, params );
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
	public int registrarEnServidor(String string, String numero, String email) {
		
		return 1;
	}

}
