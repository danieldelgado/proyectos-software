package com.vst.demochat;

import java.util.Random;

public class Constantes {

	public static final String VACIO = "";
	public static final int MENOS_UNO = -1;
	public static final boolean FALSO = false;
	
	public static final int TIPO_STRING = 1;
	public static final int TIPO_INT = 2;
	public static final int TIPO_BOOLEAN = 3;
	public static final int TIPO_FLOAT = 4;
	public static final String KEY_REGISTRADO_EN_SERVIDOR = "REGISTRADO_SERVIDOR";
	public static final int INTENT_REGISTAR_USUARIO = 1;
	public static final String KEY_USUARIO_REGISTRADO = "USUARIO_REGISTRADO";
	public static final int REGISTRO_EXITOSO_USUARIO = 1;
	public static final CharSequence MSJ_USUARIO_REGISTRO__EXITOSO = "Usuario registrado exitosamente.";
	
	public static final String SERVER_URL = "http://192.168.1.153:8082/gcm-demo-server-spring/";
	public static final int BACKOFF_MILLI_SECONDS = 2000;
	public static final Random RANDOM = new Random();
	public static final int MAX_ATTEMPTS = 5;
	public static final String TAG = "GCMDemo";
    
    
	private Constantes() {
		throw new UnsupportedOperationException();
	}
	
	
}
