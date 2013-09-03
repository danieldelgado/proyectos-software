package com.vst.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.vst.beans.Usuario;
import com.vst.service.SeguridadUsuario;
import com.vst.util.Constantes;
import com.vst.util.HttpUtilConexiones;

public class SeguridadUsuarioImpl implements SeguridadUsuario {

	@Override
	public int registrarNuevoUsuario(Usuario usuario) throws IOException, JSONException {
		String serverUrl = Constantes.SERVER_URL + "/registerUsuario";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", usuario.getUserName());
		params.put("clave", usuario.getClave());
		params.put("nombre", usuario.getNombre());
		params.put("apellido", usuario.getApellido());
		params.put("numero", usuario.getNumero());
		params.put("regId", usuario.getRegId());
		long backoff = Constantes.BACKOFF_MILLI_SECONDS + Constantes.RANDOM.nextInt(1000);
		for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
			try {				
				JSONObject objresp = HttpUtilConexiones.getJSONFromUrl(serverUrl, params);
				System.out.println("objresp");
				System.out.println(objresp);
				return 1;
			} catch (Exception e) {				
				if (i == Constantes.MAX_ATTEMPTS) {
					break;
				}
				try {
					Thread.sleep(backoff);
				} catch (InterruptedException e1) {
					Thread.currentThread().interrupt();
					return 0;
				}
				backoff *= 2;
			}
		}
		return 0;
	}

	@Override
	public boolean obtenerRegisterIDInserver(String regID) {
		System.out.println("obtenerRegisterIDInserver regID: "+regID);
//		String serverUrl = Constantes.SERVER_URL + "/registerUsuario";
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("regId", regID);
//		long backoff = Constantes.BACKOFF_MILLI_SECONDS + Constantes.RANDOM.nextInt(1000);
//		for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
//			try {				
//				JSONObject objresp = HttpUtilConexiones.getJSONFromUrl(serverUrl, params);
//				System.out.println("objresp");
//				System.out.println(objresp);
//				return true;
//			} catch (Exception e) {				
//				if (i == Constantes.MAX_ATTEMPTS) {
//					break;
//				}
//				try {
//					Thread.sleep(backoff);
//				} catch (InterruptedException e1) {
//					Thread.currentThread().interrupt();
//					return false;
//				}
//				backoff *= 2;
//			}
//		}
		return false;
	}

}
