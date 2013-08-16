package com.vst.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EnteroUtil {

	public static boolean isIdValido(Integer entero) {
		return isEnteroNoCero(entero);
	}
	
	public static boolean isIdValido(Byte entero) {
		if(entero!=null) return isEnteroNoCero(entero.intValue());
		return false;
	}	
	
	public static boolean isIdValido(Short entero) {
		if(entero!=null) return isEnteroNoCero(entero.intValue());
		return false;
	}
	
	public static boolean isIdValido(String entero) {
		if(entero!=null) return isEnteroNoCero(Integer.parseInt(entero));
		return false;
	}
	
	public static boolean isEnteroNoCero(Integer entero) {
		if(entero!=null) return entero!=0;
		return false;
	}
	
	public static boolean isPositivo(Integer entero) {
		if(entero!=null) return 0<entero;
		return false;
	}
	
	public static boolean isEnteroPositivo(String texto) {
		if(!TextoUtil.contieneAlgo(texto))
			return false;
		for(int i=0; i<texto.length(); i++) {
			if(!Character.isDigit(texto.charAt(i))) return false;
		} 
		return true;
	}
	
	/**
	 * Este método retorna una lista de id's encontrados en lista<br>
	 * Este método no retornar nulo
	 * 
	 * @param lista
	 * @param metodoGetId
	 * @return
	 * @throws BusinessException 
	 */
	public static List listarId(List lista, String metodoGetId) {
		return listarEnteroPorMetodo(lista, metodoGetId);
	}
	
	private static List listarEnteroPorMetodo(List lista, String metodoNombre)  {		
		ArrayList<Integer> listaId = new ArrayList<Integer>();
		Method metodo;
		if(lista!=null) {
			for (Object objeto : lista) {
				try {
					metodo = objeto.getClass().getMethod(metodoNombre);
					listaId.add((Integer) metodo.invoke(objeto));	
				} catch (SecurityException e) {
//					TraductorDeExcepciones.traducir(e);
				} catch (NoSuchMethodException e) {
//					TraductorDeExcepciones.traducir(e);
				} catch (IllegalArgumentException e) {
//					TraductorDeExcepciones.traducir(e);
				} catch (IllegalAccessException e) {
//					TraductorDeExcepciones.traducir(e);
				} catch (InvocationTargetException e) {
//					TraductorDeExcepciones.traducir(e);
				}
			}			
		}	
		return listaId;
	}
	
	public static Integer convertirCadenaAEntero(String cadena) {
		if (cadena != null) {
			return (cadena.length()!=0)?Integer.parseInt(cadena):0;
		}
		return null;
	}
	
	public static String convertirBigDecimalAString(BigDecimal bigDecimal) {
		if(bigDecimal!=null) {
			return (bigDecimal.intValue()!=0)?bigDecimal.toString():"";
		}
		return null;
	}
	
	public static String convertirDoubleAString(Double decimal) {
		if(decimal!=null) {
			return (decimal.intValue()!=0)?decimal.toString():"";
		}
		return null;
	}
	
	public static String obtenerParteEnteraDeBigDecimal(BigDecimal bigDecimal) {
			if(convertirBigDecimalAString(bigDecimal) != null){
				String bigDecimalCadena = convertirBigDecimalAString(bigDecimal);
				String parteEnteraDeBigDecimal = new String();
				int lugarPuntoDecimalEnCadena = bigDecimalCadena.indexOf(".");
					if(lugarPuntoDecimalEnCadena != -1){
						parteEnteraDeBigDecimal = bigDecimalCadena.substring(0, lugarPuntoDecimalEnCadena);
						return parteEnteraDeBigDecimal;
					}
					return bigDecimalCadena;
			}
		return null;
	}
	
	public static String obtenerParteEnteraDeDouble(Double decimal) {
		if(convertirDoubleAString(decimal) != null){
			String decimalCadena = convertirDoubleAString(decimal);
			String parteEnteraDeBigDecimal = new String();
			int lugarPuntoDecimalEnCadena = decimalCadena.indexOf(".");
				if(lugarPuntoDecimalEnCadena != -1){
					parteEnteraDeBigDecimal = decimalCadena.substring(0, lugarPuntoDecimalEnCadena);
					return parteEnteraDeBigDecimal;
				}
				return decimalCadena;
		}
		return null;
	}
	
}