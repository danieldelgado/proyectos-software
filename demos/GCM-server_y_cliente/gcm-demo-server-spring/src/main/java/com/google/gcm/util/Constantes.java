package com.google.gcm.util;

public class Constantes {

	public static final class tipo_registro_mobile {
		public static final int DESDE_CLASE_GCMINTENT_SERVICE = 1;
		public static final int DESDE_CLASE_MENSAJERIA_ACTIVITY = 2;
		public static final int DESDE_CLASE_REGISTRO_ACTIVITY = 3;
	}
	
	public static final class valores_por_defecto {
		public static final String VACIO = "";
		public static final int MENOS_UNO = -1;
		public static final boolean FALSO = false;
	}
	
	public static final class  key_session {
		public static final String SESION_TITULO = "titulo";
		public static String SESION_USUARIO = "usuario_en_session";
	}
	
	public static final class  estados {
		public static final Character ACTIVO = 'A';
		public static final Character INACTIVO = 'I';		
	}

	public static final class tipo_de_extension {
		public static final String TXT = "txt";
		public static final String PDF = "pdf";
		public static final String WORD = "word";
		public static final String WORDX = "wordx";
		public static final String XLS = "xls";
		public static final String XLSX = "xlsx";
		public static final String EXT_PROHI_EXE = "exe";
		public static final String EXT_PROHI_BAT = "bat";
		public static final String EXT_PROHI_SH = "sh";
	}

	public static final class registro {
		public static final int REGISTRO_EXITOSO_USUARIO = 1;
		public static final int REGISTRO_EXITOSO = 1;
		public static final int REGISTRO_ID_MOBILE_EXISTE = 1;
		public static final int REGISTRO_ID_MOBILE_NO_EXISTE = -1;
		public static final int DISPOSITIVO_REGISTRADO = 1;
		public static final int NUEVO_DISPOSITIVO_POR_USUARIO_REGISTRADO = 2;
	}
	
	public static final class respuestas_servidor {
		
		public static final String KEY_RESPUESTA_registrarDispositivoMovil = "resp";
		public static final String KEY_RESPUESTA_existeDispositivo = "resp";
		public static final String KEY_OBJETO_DIPOSITIVO = "OBJETO_DIPOSITIVO";	
		
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

	public static final class instance {
		public static final int USUARIO_LOGEADO = 1;
		public static final int USUARIO_DESLOGUEADO = 0;
	}

	public static final class errores_servidor {
		public static final int ERROR_SERVICIO_WEB = 100002;
		public static final int ERROR_AL_LOGUEARSE = 64685;
		public static final int ERROR_SERVIDOR = -2;
	}
	
	public static final class google_api {
		public static final String PATH = "/api.key";
		public static final String PK_GOOGLE = Config.getPropiedad("google.api.key");
	}

//	public static final String ATTRIBUTE_ACCESS_KEY = "apiKey";
	
	
	
}
