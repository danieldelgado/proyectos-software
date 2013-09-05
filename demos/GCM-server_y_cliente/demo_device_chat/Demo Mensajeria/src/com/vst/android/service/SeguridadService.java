package com.vst.android.service;

public interface SeguridadService {

	boolean validarRegistroServidor(String string, String str_telefono);

	int registrarEnServidor(String regId, String numero, String email);


}
