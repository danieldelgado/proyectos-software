package com.vst.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.vst.beans.Usuario;
import com.vst.service.SeguridadUsuario;
import com.vst.util.Constantes;
import com.vst.util.HttpUtilConexiones;

public class SeguridadUsuarioImpl implements SeguridadUsuario {

	@Override
	public int registrarNuevoUsuario(Usuario usuario) {
		// Log.i(TAG, "registering device (regId = " + regId + ")");
		String serverUrl = Constantes.SERVER_URL + "/registerUsuario";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", usuario.getUserName());
		params.put("clave", usuario.getClave());
		params.put("nombre", usuario.getNombre());
		params.put("apellido", usuario.getApellido());
		params.put("numero", usuario.getNumero());
		params.put("regId", usuario.getRegId());
		long backoff = Constantes.BACKOFF_MILLI_SECONDS + Constantes.RANDOM.nextInt(1000);
		// Once GCM returns a registration id, we need to register it in the
		// demo server. As the server might be down, we will retry it a couple
		// times.
		for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
			try {
				HttpUtilConexiones.post(serverUrl, params);
				
				System.out.println(HttpUtilConexiones.getJSONFromUrl(serverUrl));
				
				return 1;
			} catch (IOException e) {
				// Here we are simplifying and retrying on any error; in a real
				// application, it should retry only on unrecoverable errors
				// (like HTTP error code 503).

				if (i == Constantes.MAX_ATTEMPTS) {
					break;
				}
				try {

					Thread.sleep(backoff);
				} catch (InterruptedException e1) {
					Thread.currentThread().interrupt();
					return 0;
				}
				// increase backoff exponentially
				backoff *= 2;
			}
		}
		return 0;
	}

}
