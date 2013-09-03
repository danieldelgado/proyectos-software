package com.vst.service;

import java.io.IOException;

import org.json.JSONException;

import com.vst.beans.Usuario;

public interface SeguridadUsuario {

	int registrarNuevoUsuario(Usuario u) throws IOException, JSONException;

	boolean obtenerRegisterIDInserver(String regID);

}
