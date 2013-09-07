package com.vst.android.util;

import java.util.Random;

import android.annotation.SuppressLint;
import android.os.StrictMode;
/**
 * Constantes clase que mantiene variables para la aplicacion
 * @author ddelgado
 *
 */
@SuppressLint("NewApi")
public class Constantes {
	
	
	
	/**
	 * Variables en las que se pued instanciar valores atravez de la aplicacion
	 * @author ddelgado
	 *
	 */
	public static final class instance {
		public static String str_telefono;
		public static  String  regId;
	}
	
	/**
	 * Valores por defecto
	 * @author ddelgado
	 *
	 */
	public static final class valores_por_defecto {
		public static final String VACIO = "";
		public static final int MENOS_UNO = -1;
		public static final boolean FALSO = false;
	}

	public static final class tipo_registro_mobile {
		public static final int DESDE_CLASE_GCMINTENT_SERVICE = 1;
		public static final int DESDE_CLASE_MENSAJERIA_ACTIVITY = 2;
		public static final int DESDE_CLASE_REGISTRO_ACTIVITY = 3;
	}
	
	public static final class tipo_variable {
		public static final int TIPO_STRING = 1;
		public static final int TIPO_INT = 2;
		public static final int TIPO_BOOLEAN = 3;
		public static final int TIPO_FLOAT = 4;
	}

	public static final class keys {
		public static final String KEY_REGISTRADO_EN_SERVIDOR = "REGISTRADO_SERVIDOR";
		public static final String KEY_USUARIO_REGISTRADO = "USUARIO_REGISTRADO";
		public static final String KEY_REG_ID_DEVICE = "regId";
		public static final String KEY_ESTE_NUMERO_TELEFONO = "ESTE_NUMERO_TELEFONO";
	}

	public static final class registros {
		public static final int REGISTRO_EXITOSO_USUARIO = 1;
		public static final int REGISTRO_EXITOSO = 1;
		public static final int REGISTRO_ID_MOBILE_EXISTE = 1;
		public static final int REGISTRO_ID_MOBILE_NO_EXISTE = -1;
		public static final int DISPOSITIVO_REGISTRADO = 1;
		public static final int NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO = 2;		
	}
	
	public static final class errores_servidor {
		public static final int ERROR_SERVICIO_WEB = 100002;
		public static final int ERROR_AL_LOGUEARSE = 64685;
		public static final int ERROR_SERVIDOR = -2;
	}
	
	public static final class respuestas_servidor {
		public static final String KEY_RESPUESTA_registrarDispositivoMovil = "resp";
		public static final String KEY_RESPUESTA_CORRECTA = "RESPUESTA_CORRECTA";
		public static final int RESPUESTA_CORRECTA = 1;
		public static final String KEY_REGISTRO_EXITOSO = "REGISTRO_EXITOSO";
		public static final int REGISTRO_EXITOSO = 2;
		public static final String KEY_DISPOSITIVO_REGISTRADO = "DISPOSITIVO_REGISTRADO";
		public static final int DISPOSITIVO_REGISTRADO = 3;
		public static final String KEY_NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO = "NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO";
		public static final int NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO = 4;
		public static final int ACTUAL_DISPOSITIVO_POR_USUARIO_REGISTRADO = 5;
		public static final int NUEVO_DISPOSITIVO_POR_NUEVO_USUARIO_REGISTRADO = 6;
		public static final int NUEVO_USUARIO_POR_DISPOSITIVO_REGISTRADO = 7;				
	}
	
	public static final class intent {
		public static final int INTENT_REGISTAR_USUARIO = 1;
		public static final String DISPLAY_MESSAGE_ACTION = "com.vst.android.demo.chat.DISPLAY_MESSAGE";
		public static final String EXTRA_MESSAGE = "intent_mensaje";
	}

	public static final class url_server {
		public static final String URL_SERVER = "http://192.168.1.36:8083/gcm-demo-server-spring";
		public static final String URL_EXISTE_NUMERO = URL_SERVER + "/existeNumero";
		public static final String URL_REGISTRAR_DISPOSITIVO_USUARIO =  URL_SERVER + "/registrarDispositivoUsuario";
		
	}

	public static final class gcm_id {
		public static final String SENDER_ID = "485888261287";
	}

	public static final class rangos {
		public static final int BACKOFF_MILLI_SECONDS = 2000;
		public static final Random RANDOM = new Random();
		public static final int MAX_ATTEMPTS = 5;
	}

	public static final class tags {
		public static final String TAG = "GCMDemo";
		public static final String PAQUETE_ROOT = "com.vst.android";
	}


	
	static {
		// con este metodo static soluciona el problema de la conexion a
		// internet method post
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}

	private Constantes() {
		throw new UnsupportedOperationException();
	}
	
}
