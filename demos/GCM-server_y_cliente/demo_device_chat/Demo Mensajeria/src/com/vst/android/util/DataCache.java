package com.vst.android.util;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class DataCache {
	
	private DataCache() {
		throw new UnsupportedOperationException();
	}

	public static SharedPreferences getGCMPreferences(Context context) {
		return context.getSharedPreferences("com.vst.demochat", 0);
	}

	@SuppressLint("CommitPrefEdits")
	public static void putObject(Context context, String key, Object object) {
		SharedPreferences sharedPreferences = getGCMPreferences(context);
		SharedPreferences.Editor editor = sharedPreferences.edit();
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
	}
	
	public static boolean existeValor(Context context, int tipo, String key){
		SharedPreferences sharedPreferences = getGCMPreferences(context);		
		switch (tipo) {
		case 1:
			String vl = sharedPreferences.getString(key, Constantes.VACIO);
			if(!vl.equals(Constantes.VACIO)){
				return true;
			}
			break;
		case 2:
			int vint = sharedPreferences.getInt(key, Constantes.MENOS_UNO);
			if(!(vint==Constantes.MENOS_UNO)){
				return true;
			}
			break;
		case 3:
			boolean vBool = sharedPreferences.getBoolean(key, Constantes.FALSO);
			if(vBool){
				return true;
			}
			break;
		case 4:
			float vflot = sharedPreferences.getFloat(key, Constantes.MENOS_UNO);
			if(!(vflot==Constantes.MENOS_UNO)){
				return true;
			}
			break;
		}
		return false;
	}
	
	public static Object obtenerValorSharedPreferences(Context context, int tipo, String key){
		SharedPreferences sharedPreferences = getGCMPreferences(context);		
		switch (tipo) {
		case 1:
			String vl = sharedPreferences.getString(key, Constantes.VACIO);
			if(vl.equals(Constantes.VACIO)){
				return vl;
			}
			break;
		case 2:
			int vint = sharedPreferences.getInt(key, Constantes.MENOS_UNO);
			if(!(vint==Constantes.MENOS_UNO)){
				return vint;
			}
			break;
		case 3:
			boolean vBool = sharedPreferences.getBoolean(key, Constantes.FALSO);
			if(vBool){
				return vBool;
			}
			break;
		case 4:
			float vflot = sharedPreferences.getFloat(key, Constantes.MENOS_UNO);
			if(!(vflot==Constantes.MENOS_UNO)){
				return vflot;
			}
			break;
		}
		return null;
	}

}
