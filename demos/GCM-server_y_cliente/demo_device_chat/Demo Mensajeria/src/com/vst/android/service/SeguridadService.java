package com.vst.android.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public interface SeguridadService {

	public int registrarEnServidor(String regId, String numero, String email, int tipoRegistro)  throws ClientProtocolException, IOException, JSONException;

	public boolean validarRegistroServidor(String regId)  throws ClientProtocolException, IOException, JSONException;
 

}
