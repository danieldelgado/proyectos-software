package com.vst.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.vst.util.persistence.Entidad;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Util {

	private static 	Random r =new Random();
	
	public static String getCodigo(Entidad entidad) {
		Calendar c = Calendar.getInstance();
		return entidad.getClass().getSimpleName() + "-" + c.getTimeInMillis() + "-" + random();
	}

	public static int random(){	
		return r.nextInt();
	}
	
	public static int random(int limit){	
		return r.nextInt(limit);
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


	/*
	 * public static String generateCollection(String campo, List list) { String
	 * result ="";// "( "; try {
	 * 
	 * if (list == null || list.isEmpty()) return "()"; for (Iterator it =
	 * list.iterator(); it.hasNext();) { Object obentidad = it.next(); Class c =
	 * obentidad.getClass(); Method myMethod; myMethod = c.getMethod("getId",
	 * null); result += myMethod.invoke(obentidad, null); if (it.hasNext()) {
	 * result += " , "; } }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } result += "";// " )";
	 * return result; }
	 */

//	public static List<Integer> generateCollection(String campo, List list) {
//		System.out.println(list);
//		List<Integer> result = new ArrayList<Integer>();
//		try {
//			if (list == null || list.isEmpty()) {
//				result.add(0);
//				return result;
//			}
//			for (Iterator it = list.iterator(); it.hasNext();) {
//				Object obentidad = it.next();
//				Class c = obentidad.getClass();
//				Method myMethod;
//				myMethod = c.getMethod("getId", null);
//				int r = (Integer) myMethod.invoke(obentidad, null);
//				result.add(r);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}




}
