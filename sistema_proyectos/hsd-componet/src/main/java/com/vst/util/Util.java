package com.vst.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.gson.Gson;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Util {

	public static String getCodigo(Entidad entidad) {
		Calendar c = Calendar.getInstance();
		return entidad.getClass().getSimpleName()+"-"+c.getTimeInMillis()+"-"+entidad.hashCode();
	}

	public static String getJsonObject(Entidad entidad) {
		Gson gson = new Gson();
		String gsonString = gson.toJson(entidad);
		return "{" + entidad.getClass().getSimpleName() + ":[" + gsonString + "]}";
	}

	public static String getJson(Object... ob) {
		List l = new ArrayList();
		for (int i = 0; i < ob.length; i++) {
			Object o = ob[i];
			l.add(o);
		}
		Gson gson = new Gson();
		return gson.toJson(l);
	}

	public static boolean vacio(String cadena){
		return cadena == null || cadena.equals("");
	}
	
}
