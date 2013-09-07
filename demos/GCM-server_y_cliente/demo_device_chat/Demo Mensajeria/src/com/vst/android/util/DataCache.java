package com.vst.android.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
/**
 * DataCache clase donde se puede instanciar datos en cache del dispositivo
 * en SharedPreferences del contexto
 * @author ddelgado
 *
 */
public class DataCache {

	private static SharedPreferences sharedPreferences;
	private static SharedPreferences.Editor editor;
	
	private DataCache() {
		throw new UnsupportedOperationException();
	}

	public static SharedPreferences getDataCachePreferences(Context context) {
		return context.getSharedPreferences(Constantes.tags.PAQUETE_ROOT, 0);
	}
	
	/**
	 * Guarda la informacion necesaria.
	 * @param context
	 * @param key
	 * @param object
	 */
	@SuppressLint("CommitPrefEdits")
	public static void putObject(Context context, String key, Object object) {
		sharedPreferences = getDataCachePreferences(context);
		editor = sharedPreferences.edit();
		if (object instanceof String) {
			editor.putString(key, String.valueOf(object));		
		} else if (object instanceof Integer) {
			editor.putInt(key, Integer.valueOf(String.valueOf(object))
					.intValue());
		} else if (object instanceof Boolean) {
			editor.putBoolean(key, Boolean.valueOf(String.valueOf(object)));
		} else if (object instanceof Long) {
			editor.putLong(key, Long.valueOf(String.valueOf(object)));
		}else {
			throw new UnsupportedOperationException("EL objeto no pertenece a ninguno de los tipos de clases para el SharedPreferences");
		}
		editor.commit();
		variablesNull();
	}
	
	/**
	 * Pregunta si existe algun valor.
	 * @param context
	 * @param tipo
	 * @param key
	 * @return
	 */
	public static boolean existeValor(Context context, int tipo, String key){
		sharedPreferences = getDataCachePreferences(context);		
		switch (tipo) {
		case 1:
			String vl = sharedPreferences.getString(key, Constantes.valores_por_defecto.VACIO);
			if(!vl.equals(Constantes.valores_por_defecto.VACIO)){
				return true;
			}
			break;
		case 2:
			int vint = sharedPreferences.getInt(key, Constantes.valores_por_defecto.MENOS_UNO);
			if(!(vint==Constantes.valores_por_defecto.MENOS_UNO)){
				return true;
			}
			break;
		case 3:
			boolean vBool = sharedPreferences.getBoolean(key, Constantes.valores_por_defecto.FALSO);
			if(vBool){
				return true;
			}
			break;
		case 4:
			float vflot = sharedPreferences.getFloat(key, Constantes.valores_por_defecto.MENOS_UNO);
			if(!(vflot==Constantes.valores_por_defecto.MENOS_UNO)){
				return true;
			}
			break;
		}
		variablesNull();
		return false;
	}
	
	/**
	 * Obtengo valor si se encuentra alguno en caso contrario devulve null
	 * @param context
	 * @param tipo
	 * @param key
	 * @return
	 */
	public static Object obtenerValorSharedPreferences(Context context, int tipo, String key){
		sharedPreferences = getDataCachePreferences(context);		
		switch (tipo) {
		case 1:
			String vl = sharedPreferences.getString(key, Constantes.valores_por_defecto.VACIO);
			if(vl.equals(Constantes.valores_por_defecto.VACIO)){
				return vl;
			}
			break;
		case 2:
			int vint = sharedPreferences.getInt(key, Constantes.valores_por_defecto.MENOS_UNO);
			if(!(vint==Constantes.valores_por_defecto.MENOS_UNO)){
				return vint;
			}
			break;
		case 3:
			boolean vBool = sharedPreferences.getBoolean(key, Constantes.valores_por_defecto.FALSO);
			if(vBool){
				return vBool;
			}
			break;
		case 4:
			float vflot = sharedPreferences.getFloat(key, Constantes.valores_por_defecto.MENOS_UNO);
			if(!(vflot==Constantes.valores_por_defecto.MENOS_UNO)){
				return vflot;
			}
			break;
		}
		return null;
	}
	
	//libera memoria
	private static void variablesNull() {
		sharedPreferences = null;
		editor = null;
	}

}
