package com.vst.util;

public class NumeroUtil {
	
	public static boolean isDecimalNoCero(Double numero) {
		if(numero!=null) return numero!=0;
		return false;
	}
	
	public static boolean isDecimalPositivo(Double numero) {
		if(numero!=null) return 0<numero;
		return false;
	}
	
	public static boolean isDecimalNoCadena(String texto) {
		return false;
	}
	
	public static boolean isDecimal(String texto){
		try {
			Double.parseDouble(texto);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

}
