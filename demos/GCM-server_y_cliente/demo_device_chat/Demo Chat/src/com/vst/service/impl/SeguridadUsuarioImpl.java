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

		JSONObject objresp = HttpUtilConexiones.resppost(serverUrl, params);
		int r = (Integer) objresp.get("resp");		
		if(r==Constantes.REGISTRO_EXITOSO){
			return r;			
		}
		return -1;

	}

}
