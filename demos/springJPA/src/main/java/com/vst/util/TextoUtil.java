package com.vst.util;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TextoUtil {

	private static final String SALTO_DE_LINEA_HTML = "<br>";
	private static final String SALTO_DE_LINEA_TXT = "\n";
	private static final String MASCARA = "***";

	static public String enMinuscula(String texto) {
		if (contieneAlgo(texto)) {
			StringBuffer flujo = new StringBuffer(texto);
			for (int i = 0; i < texto.length(); i++) flujo.setCharAt(i, Character.toLowerCase(texto.charAt(i)));
			texto = flujo.toString();
		}
		return texto;
	}

	public static String primerasMayuscula(String texto) {
		if(contieneAlgo(texto)) {
			texto = " " + texto;
			texto = enMinuscula(texto);
			StringBuffer flujo = new StringBuffer(texto);
			for (int i = 1; i < texto.length(); i++) {
				if(texto.charAt(i-1)==' ')
					flujo.setCharAt(i, Character.toUpperCase(texto.charAt(i)));				
			}
			texto = flujo.toString();
			texto = texto.substring(1, texto.length());
		}
		return texto;
	}

	public static String mitadDerecha(String texto) {
		return texto.substring(texto.length() / 2, texto.length());
	}

	public static String mitadIzquierda(String texto) {
		return texto.substring(0, texto.length() / 2);
	}

	public static boolean isIdValido(String texto) {
		return contieneAlgo(texto);
	}

	public static boolean contieneAlgo(String texto) {
		if (texto != null )
			return 0 < texto.trim().length();
		return false;
	}
	
	// *AR*
	
	private static boolean isNumeric(String texto){
		try {
			Integer.parseInt(texto);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	
	// Por indicaciones de Deisy trabajar sólamente para el número de DNI (hasta nueva indicación) 
	public static boolean contieneNumeroDNI(String texto){
		if (TextoUtil.isNumeric(texto)){
			if(texto.trim().length()==8){
				return true;
			}
		}
		return false;
	}
	

	/*
	 * public static boolean contieneAlgo(Integer valor) { if (valor != null)
	 * return true; return false; }
	 */

	public static String enMayuscula(String texto) {
		if (texto != null)
			return texto.toUpperCase();
		return texto;
	}

	public static String enHtmlBr(String texto) {
		if (contieneAlgo(texto))
			return texto.replaceAll(SALTO_DE_LINEA_TXT, SALTO_DE_LINEA_HTML);
		return texto;
	}

	public static String trim(String texto) {
		if (texto != null)
			return texto.trim();
		return texto;
	}

	public static String corregir(String texto) {
		if (texto != null)
			texto = texto.trim();
		if (contieneAlgo(texto))
			return texto.toUpperCase();
		return texto;
	}

	public static String corregirConMascara(String texto) {
		if (contieneAlgo(texto))
			return corregir(texto);
		return MASCARA;
	}

	public static String eliminarMascara(String texto) {
		if (contieneAlgo(texto))
			if (MASCARA.equalsIgnoreCase(texto.trim()))
				return "";
		return texto;
	}

	public static String eliminarAcentos(String texto) {
		if (contieneAlgo(texto)) {
			texto = texto.replace('Á', 'A');
			texto = texto.replace('É', 'E');
			texto = texto.replace('Í', 'I');
			texto = texto.replace('Ó', 'O');
			texto = texto.replace('Ú', 'U');
			texto = texto.replace('Ü', 'U');
			texto = texto.replace('á', 'a');
			texto = texto.replace('é', 'e');
			texto = texto.replace('í', 'i');
			texto = texto.replace('ó', 'o');
			texto = texto.replace('ú', 'u');
			texto = texto.replace('ü', 'u');
			return texto;
		}
		return texto;
	}

	public static String extraerIdDepartamentoProvincia(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 6)
				return idUbigeo.substring(0, 4);
		}
		return null;
	}

	public static String extraerIdDepartamento(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 5)
				return idUbigeo.substring(3, 5);
		}
		return null;
	}
	
	public static String extraerIdDepartamentoUbigeo(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(0, 5);
		}
		return null;
	}

	public static String extraerIdProvincia(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 7)
				return idUbigeo.substring(5, 7); 
		}
		return null;
	}
	
	public static String extraerIdProvinciaUbigeo(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(0, 7); 
		}
		return null;
	}
	
	public static String extraerIdDistrito(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(7, 9);
		}
		return null;
	}
	
	public static String extraerIdDistritoUbigeo(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(0, 9);
		}
		return null;
	}

	public static boolean contieneAlgo(String[] arreglo) {
		if (arreglo != null)
			return 0 < arreglo.length;
		return false;
	}

	public static boolean contiene(String[] arreglo, String texto) {
		boolean encontrado = false;
		if (arreglo != null && texto != null) {
			for (int i = 0; i < arreglo.length && !encontrado; i++)
				encontrado = arreglo[i].equals(texto);
		}
		return encontrado;
	}

	public static String eliminarEspacioBlanco(String texto) {
		if (texto != null)
			return texto.replace(" ", "");
		return texto;
	}
	
	public static String eliminarCaracter(String texto, String caracter) {
		if (texto != null)
			return texto.replace(caracter, "");
		return texto;
	}

	public static String completarIzquierda(String textoBase, String textoComplementario, Integer longitud) {
		while (textoBase.length() < longitud)
			textoBase = textoComplementario + textoBase;
		return textoBase;
	}

	public static String extraerUbigeoNoPais(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(3, 9);
		}
		return null;
	}
	
	public static String extraerPais(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 9)
				return idUbigeo.substring(0, 3);
		}
		return null;
	}

	public static String incluirPaisEnUbigeo(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() == 6)
				return "001" + idUbigeo;
		}
		return idUbigeo;
	}
	
	public static String incluirPais(String idUbigeo) {
		if (contieneAlgo(idUbigeo)) {
			idUbigeo = corregir(idUbigeo);
			if (idUbigeo.length() != 0)
				return "001" + idUbigeo;
		}
		return idUbigeo;
	}
	
	public static boolean contieneEspacioEnBlanco(String texto) {
		char esp_blanco = ' ';
		for (int i = 0; i < texto.length(); i++) {
			Character caracter = texto.charAt(i);
			if (caracter.equals(esp_blanco))
				return true;
		}
		return false;
	}
	
	/*public static boolean contieneCaracteresPermitidos(String[] listasEvaluar, String texto) {
		for (int i = 0; i < texto.length(); i++) {
			Character caracter = texto.charAt(i);
			int suma = 0;
			int j = 0;
			for (j = 0; j < listaCarateresPermitidos.length; j++) {
				Character caracterPermitido = listaCarateresPermitidos[j].charAt(0);
				if (caracter.compareTo(caracterPermitido)!= 0 )
					retur true; 
			}
		}
		return false;
	}*/
	
	public static boolean contieneCaracteresPermitidos(List listasEvaluar, String texto) {
		int tamanoTexto = texto.length();
		int suma = 0;
		for (int i = 0; i < texto.length(); i++) {
			Character caracter = texto.charAt(i);
			for (Iterator iter = listasEvaluar.iterator(); iter.hasNext();) {
				Character[] listaCarateresPermitidos = (Character[]) iter.next();
				int j = 0;
				for (j = 0; j < listaCarateresPermitidos.length; j++) {
					Character caracterPermitido = listaCarateresPermitidos[j].charValue();
					if (caracter.compareTo(caracterPermitido) == 0) { 
						suma = suma + 1;
					}
				}
			}
		}
		return (tamanoTexto==suma);
	}
	
	public static String generarClaveAleatoria(int tamanoCadena) {
		StringBuffer claveAleatoria = new StringBuffer();
		Random numeroAleatorio = new Random();
		for(int i=0; i<tamanoCadena; i++){
			claveAleatoria.append(numeroAleatorio.nextInt(10));
		}
		return claveAleatoria.toString();
	}
	
	public static String extraerCorrelativoSecuencia(String secuencia) {
		if (contieneAlgo(secuencia)) {
			secuencia = corregir(secuencia);
			if (secuencia.length() == 6)
				return secuencia.substring(0, 2);
		}
		return null;
	}
	
	 public static String Left(String text, int length)
     {
           return text.substring(0, length);
     }

     public static String Right(String text, int length)
     {
           return text.substring(text.length() - length, length);
     }  

     public static String Mid(String text, int start, int end)
     {
           return text.substring(start, end);
     }  

     public static String Mid(String text, int start)
     {
           return text.substring(start, text.length() - start);
     }
     
     
     public static String formatearTelefonoCargas(String telefono){
//    	 telefono = telefono.replaceAll(".0", "");
    	 telefono = telefono.replaceAll("\\.", "");
    	 telefono = telefono.replaceAll("E8", "");
    	 return telefono;
     }
}
