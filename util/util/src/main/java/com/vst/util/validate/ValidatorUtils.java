package com.vst.util.validate;


import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vst.util.CharPool;

public class ValidatorUtils {
	private static Pattern _cadena=Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s-]{1,100}");
	private static Pattern _idCompuesto=Pattern.compile("[a-zA-Z0-9._-]{1,14}");
	private static Pattern _patron_nombre=Pattern.compile("[a-z'A-ZñÑáéíóúÁÉÍÓÚüÜ\\s-]+");
	private static Pattern _patron_email=Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
	private static Pattern _patron_telefono=Pattern.compile("[0-9]{6,15}");
	private static Pattern _patron_celular=Pattern.compile("[0-9]{9}");
	private static Pattern _patron_dni=Pattern.compile("[0-9]{8}");
	private static Pattern _patron_ruc=Pattern.compile("[0-9]{11}");
	private static Pattern _patron_carnet_extranjeria=Pattern.compile("[a-zA-ZñÑ0-9]{9,12}");
	private static Pattern _pasaporte=Pattern.compile("[a-zA-ZñÑ0-9]{9,12}");
	private static Pattern _comentario=Pattern.compile("[a-zA-ZñÑ0-9-]{1,1000}");
	private static Pattern _texto=Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ-]{1,100}");
	private static Pattern _IMAGE_PATTERN=Pattern.compile("([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
	private static Pattern _FILE_PATTERN=Pattern.compile("([^\\s]+(\\.(?i)(xls|xlsx|doc|docx|pdf))$)");
	
	private static Pattern _solicitud_patron_dni = Pattern.compile("[0-9]{8}");
	private static Pattern _solicitud_patron_carne_extranjeria = Pattern.compile("[a-zA-ZñÑ0-9]{9,12}");
	private static Pattern _solicitud_patron_nombre = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ0-9\\s-']{1,50}");
	private static Pattern _solicitud_patron_direccion = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ0-9\\s-']{1,100}");
	private static Pattern _solicitud_patron_placa = Pattern.compile("[a-zA-Z0-9-]{6,8}");
	private static Pattern _solicitud_patron_razonSocial = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s-']{1,100}");
	private static Pattern _solicitud_patron_ruc = Pattern.compile("[0-9]{11}");
	private static Pattern _solicitud_patron_celular = Pattern.compile("[0-9]{9,10}");
	private static Pattern _solicitud_patron_telefono = Pattern.compile("[0-9]{6,10}");
	private static Pattern _solicitud_patron_anexo = Pattern.compile("[0-9]{1,10}");
	private static Pattern _solicitud_patron_email = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
	
	private static final int _DIGIT_BEGIN = 48;
	private static final int _DIGIT_END = 57;

	public static boolean vacio(String cadena) {
		return cadena == null || cadena.equals("");
	}
	
	public static boolean isNombre(String nombres){
		if(isNull(nombres)) return false;
		Matcher matcher = _patron_nombre.matcher(nombres);
		return matcher.matches();
	}


	
	public static boolean isNumber(String number) {
		if (isNull(number)) {
			return false;
		}

		for (char c : number.toCharArray()) {
			if (!isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	public static boolean isDigit(char c) {
		int x = c;

		if ((x >= _DIGIT_BEGIN) && (x <= _DIGIT_END)) {
			return true;
		}

		return false;
	}
	
	public static boolean isApellido(String apellidos){
		if(isNull(apellidos)) return false;
		Matcher matcher = _patron_nombre.matcher(apellidos);
		return matcher.matches();
	}

	
	public static boolean isEmail(String email){
		if(isNull(email)) return false;
		Matcher matcher = _patron_email.matcher(email);
		return matcher.matches();
	}


	public static boolean isTelefono(String telefono){
		if(isNull(telefono)) return false;
		Matcher matcher = _patron_telefono.matcher(telefono);
		return matcher.matches();
	}


	public static boolean isCelular(String celular){
		if(isNull(celular)) return false;
		if(celular.charAt(0) != '9') return false;
		Matcher matcher = _patron_celular.matcher(celular);
		return matcher.matches();
	}

	
	public static boolean isDNI(String dni){
		if(isNull(dni)) return false;
		if(dni.equals("00000000")) return false;
		Matcher matcher = _patron_dni.matcher(dni);
		return matcher.matches();
	}

	
	public static boolean isRUC(String ruc){
		if(isNull(ruc)) return false;
		if(ruc.charAt(0) != '1' && ruc.charAt(0) != '2' ) return false;
		Matcher matcher = _patron_ruc.matcher(ruc);
		return matcher.matches();
	}

	public static boolean isPasaporte(String pasaporte){
		if(isNull(pasaporte)) return false;
		Matcher matcher = _pasaporte.matcher(pasaporte);
		return matcher.matches();
	}


	
	public static boolean isCarneExtranjeria(String ce){
		if(isNull(ce)) return false;
		Matcher matcher = _patron_carnet_extranjeria.matcher(ce);
		return matcher.matches();
	}
	
	
	public static boolean isNull(String s) {
		if (s == null) {
			return true;
		}

		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == CharPool.SPACE) {
				continue;
			}
			else if (counter > 3) {
				return false;
			}

			if (counter == 0) {
				if (c != CharPool.LOWER_CASE_N) {
					return false;
				}
			}
			else if (counter == 1) {
				if (c != CharPool.LOWER_CASE_U) {
					return false;
				}
			}
			else if ((counter == 2) || (counter == 3)) {
				if (c != CharPool.LOWER_CASE_L) {
					return false;
				}
			}

			counter++;
		}

		if ((counter == 0) || (counter == 4)) {
			return true;
		}

		return false;
	}

	public static boolean isNull(Long l) {
		if ((l == null) || (l.longValue() == 0)) {
			return true;
		}
		else {
			return false;
		}
	}


		public static boolean isNull(Object obj) {
			if (obj instanceof Long) {
				return isNull((Long)obj);
			}
			else if (obj instanceof String) {
				return isNull((String)obj);
			}
			else if (obj == null) {
				return true;
			}
			else {
				return false;
			}
		}


	public static boolean isNotNull(Long l) {
		return !isNull(l);
	}


	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}


	public static boolean isNotNull(Object[] array) {
		return !isNull(array);
	}



	public static boolean isDate(int dia, int mes, int anio) {
		return isGregorianDate(dia, mes, anio);
	}


	public static boolean isGregorianDate(int dia, int mes, int anio) {
		if ((mes < 0) || (mes > 11)) {
			return false;
		}

		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (mes == 1) {
			int febMax = 28;

			if (((anio % 4) == 0) && ((anio % 100) != 0) ||
				((anio % 400) == 0)) {

				febMax = 29;
			}

			if ((dia < 1) || (dia > febMax)) {
				return false;
			}
		}
		else if ((dia < 1) || (dia > months[mes])) {
			return false;
		}

		return true;
	}

	public static boolean isMayor_0(int num) {
		if(num>0)
			return true;
		return false;
	}
	
	public static boolean isCero(int num) {
		return (num == 0);
	}
	

	public static boolean isCadena(String cadena){
		if(isNull(cadena)) return false;
		Matcher matcher = _cadena.matcher(cadena);
		return matcher.matches();
	}
	
	public static boolean isIdCompuesto(String cadena){
		if(isNull(cadena)) return false;
		Matcher matcher = _idCompuesto.matcher(cadena);
		return matcher.matches();
	}
	
	
	public static boolean isTexto(String texto){
		if(isNull(texto)) return false;
		Matcher matcher = _texto.matcher(texto);
		return matcher.matches();
	}
	
	
	public static boolean tamanno(String cadena,int tamanno){		
		if(cadena.length()>0){
			if(cadena.length()<=tamanno){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isComentarioMax(String cadena,int tamanno){
		if(isNull(cadena)) 
			return false;
		if(tamanno(cadena,tamanno)){
			Matcher matcher = _comentario.matcher(cadena);
			return matcher.matches();
		}
		return false;		
	}
	

	public static boolean isFile(String fileName){
		if(isNull(fileName)) return false;
		Matcher matcher = _FILE_PATTERN.matcher(fileName);
		return matcher.matches();
	}
	
	public static boolean isImage(String fileName){
		if(isNull(fileName)) return false;
		Matcher matcher = _IMAGE_PATTERN.matcher(fileName);
		return matcher.matches();
	}
	public static boolean isUrl(String url){
		try {
			new URL(url);
			return true;
		} catch (Exception e) {
		}		
		return false;
	}
	
	public static boolean isDouble(String num){
		try {
			new Double(num);
			return true;
		} catch (Exception e) {
		}
		return false;
	}


	public static String quitarAcentos(String input) {
	    // Cadena de caracteres original a sustituir.
	    String original = "Ã¡Ã Ã¤Ã©Ã¨Ã«Ã­Ã¬Ã¯Ã³Ã²Ã¶ÃºÃ¹uÃ±Ã�Ã€Ã„Ã‰ÃˆÃ‹Ã�ÃŒÃ�Ã“Ã’Ã–ÃšÃ™ÃœÃ‘Ã§Ã‡";
	    // Cadena de caracteres ASCII que reemplazarÃ¡n los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }//for i
	    return output;
	}

	public static boolean solicitud_isDNI(String dni){
		if(isNull(dni)) return false;
		if(dni.equals("00000000")) return false;
		Matcher matcher = _solicitud_patron_dni.matcher(dni);
		return matcher.matches();
	}
	
	public static boolean solicitud_isCarneExtranjeria(String ce){
		if (isNull(ce)) return false;
		Matcher matcher = _solicitud_patron_carne_extranjeria.matcher(ce);
		return matcher.matches();
	}

	public static boolean solicitud_isNombre(String nombres){
		if(isNull(nombres)) return false;
		Matcher matcher = _solicitud_patron_nombre.matcher(nombres);
		return matcher.matches();
	}
	
	public static boolean solicitud_isRazonSocial(String razonSocial){
		if(isNull(razonSocial)) return false;
		Matcher matcher = _solicitud_patron_razonSocial.matcher(razonSocial);
		return matcher.matches();
	}
	
	public static boolean solicitud_isRUC(String ruc){
		if(isNull(ruc)) return false;
		if(ruc.charAt(0) != '1' && ruc.charAt(0) != '2' ) return false;
		Matcher matcher = _solicitud_patron_ruc.matcher(ruc);
		return matcher.matches();
	}
	
	public static boolean solicitud_isCelular(String celular){
		if(isNull(celular)) return false;
		if(celular.charAt(0) != '9') return false;
		Matcher matcher = _solicitud_patron_celular.matcher(celular);
		return matcher.matches();
	}
	
	public static boolean solicitud_isTelefono(String telefono){
		if(isNull(telefono)) return false;
		Matcher matcher = _solicitud_patron_telefono.matcher(telefono);
		return matcher.matches();
	}
	
	public static boolean solicitud_isAnexo(String anexo){
		if(isNull(anexo)) return false;
		Matcher matcher = _solicitud_patron_anexo.matcher(anexo);
		return matcher.matches();
	}
	
	public static boolean solicitud_isEmail(String email){
		if(isNull(email)) return false;
		Matcher matcher = _solicitud_patron_email.matcher(email);
		return matcher.matches();
	}
	
	public static boolean solicitud_isPlaca(String placa){
		if(isNull(placa)) return false;
		Matcher matcher = _solicitud_patron_placa.matcher(placa);
		return matcher.matches();
	}
	
	public static boolean solicitud_isDireccion(String direccion){
		if(isNull(direccion)) return false;
		Matcher matcher = _solicitud_patron_direccion.matcher(direccion);
		return matcher.matches();
	}
}