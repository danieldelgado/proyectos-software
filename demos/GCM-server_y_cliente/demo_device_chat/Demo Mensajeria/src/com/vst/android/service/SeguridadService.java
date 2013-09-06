package com.vst.android.service;

public interface SeguridadService {

	public boolean validarRegistroServidor(String string, String str_telefono);

	public int registrarEnServidor(String regId, String numero, String email);


}
