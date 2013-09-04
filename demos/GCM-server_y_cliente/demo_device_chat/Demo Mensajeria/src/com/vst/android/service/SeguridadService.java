package com.vst.android.service;

public interface SeguridadService {

	boolean validarRegistroServidor(String string, String str_telefono);

	int registrarEnServidor(String string, String numero, String email);


}
