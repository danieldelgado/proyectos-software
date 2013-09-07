package com.vst.android.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public interface SeguridadService {

	public boolean validarRegistroServidor(String string, String str_telefono);

	public int registrarEnServidor(String regId, String numero, String email, int tipoRegistro)  throws ClientProtocolException, IOException, JSONException;
 

}
