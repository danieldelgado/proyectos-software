package com.vst.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

@SuppressWarnings({ "rawtypes", "unchecked"})
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
	
	public  static boolean validarCadena(Object object, int rangMin, int rangoMAx,String... str) {
		String u = String.valueOf(object);
		u = u.toLowerCase().trim();
		if(u!=null){			
				if(u!="" || !(u.equals(""))){					
					if( ( u.length() >= rangMin ) && ( u.length() <= rangoMAx ) ){						
						for (int i = 0; i < str.length; i++) {		
							String sE = str[i].toLowerCase().trim();
							if(( sE.toLowerCase().trim().equals(u))){
								return false;
							}							
						}	
						return true;					
					}					
				}			
		}		
		return false;
	}
	
	public   static boolean validarSelector(Object object, int rangMin,String... str) {
		Integer s = Integer.parseInt( String.valueOf(object) );
		if(s!=null){			
				if(s>rangMin){										
					for (int i = 0; i < str.length; i++) {		
						String sE = str[i].toLowerCase().trim();
						if(( sE.toLowerCase().trim().equals(String.valueOf(s)))){
							return false;
						}							
					}	
					return true;	
				}			
		}		
		return false;
	}
	
	

	public  static boolean validarClave(Object object, int rangMin, int rangoMAx,String... str) {
		String c = String.valueOf(object);
		if(c!=null){			
				if(c!="" || !(c.equals(""))){					
					if( ( c.length() >= rangMin ) && ( c.length() <= rangMin ) ){						
						Pattern r = Pattern.compile("(\\d)\\w{1,10}");
						Matcher m = r.matcher(c);
						return m.matches();
					}					
				}			
		}		
		return false;
	}

	public static Boolean validarEntero(Integer entero, Integer rangoEnteroMin, Integer rangoEnteroMax, Integer valorEnteroMin, Integer valorEnteroMax) {
		return false;		
	}

	public static Boolean validarDecimal(Double decimal, Double rangoDecimalMin, Double rangoDecimalMax, Double valorDecimalMin, Integer valorDecimalMax, Integer cantidadDecimales) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Boolean validarFormato(String format, String valorFormat, Integer rangoCadenaMin, Integer rangoCadenaMax, String[] cadenasRestringidas) {
		// TODO Auto-generated method stub
		return null;
	}
}
