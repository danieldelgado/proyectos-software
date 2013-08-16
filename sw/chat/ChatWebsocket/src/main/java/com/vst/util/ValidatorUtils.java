package com.vst.util;


import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	
	/**
	 * Retorna <code>true</code> Si la cadena es un nombre vÃƒÂ¡lido con caracteres letras y caracteres
	 * con tildes.
	 *
	 * @param  nombres el nombre a verificar
	 * @return <code>true</code> si la cadena es un nombre vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
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
	/**
	 * Retorna <code>true</code> Si la cadena es un apellido vÃƒÂ¡lido con caracteres letras y caracteres
	 * con tildes.
	 *
	 * @param  apellidos el apellido a verificar
	 * @return <code>true</code> si la cadena es un apellido vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isApellido(String apellidos){
		if(isNull(apellidos)) return false;
		Matcher matcher = _patron_nombre.matcher(apellidos);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es una direcciÃƒÂ³n de correo electrÃƒÂ³nico vÃƒÂ¡lido
	 *
	 * @param  email el correo electrÃƒÂ³nico a verificar
	 * @return <code>true</code> si la cadena es un correo electrÃƒÂ³nico vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isEmail(String email){
		if(isNull(email)) return false;
		Matcher matcher = _patron_email.matcher(email);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un nÃƒÂºmero de telefono valido de <code>7 digitos</code>
	 *
	 * @param  telefono el nÃƒÂºmero de telefono a verificar
	 * @return <code>true</code> si la cadena es un telefono vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isTelefono(String telefono){
		if(isNull(telefono)) return false;
		Matcher matcher = _patron_telefono.matcher(telefono);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un nÃƒÂºmero de celular valido de <code>9 digitos</code>
	 *
	 * @param  celular el nÃƒÂºmero de celular a verificar
	 * @return <code>true</code> si la cadena es un celular vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isCelular(String celular){
		if(isNull(celular)) return false;
		if(celular.charAt(0) != '9') return false;
		Matcher matcher = _patron_celular.matcher(celular);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un nÃƒÂºmero de DNI valido de <code>8 digitos</code>
	 *
	 * @param  dni el nÃƒÂºmero de DNI a verificar
	 * @return <code>true</code> si la cadena es un DNI vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isDNI(String dni){
		if(isNull(dni)) return false;
		if(dni.equals("00000000")) return false;
		Matcher matcher = _patron_dni.matcher(dni);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un nÃƒÂºmero de RUC valido de <code>11 digitos</code>
	 *
	 * @param  ruc el nÃƒÂºmero de RUC a verificar
	 * @return <code>true</code> si la cadena es un RUC vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
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


	/**
	 * Retorna <code>true</code> Si la cadena es un nÃƒÂºmero de carnÃƒÂ© de extanjerÃƒÂ­a valido de <code>9 - 11 caracteres alfanumerico</code>
	 *
	 * @param  ce el nÃƒÂºmero de carnÃƒÂ© de extanjerÃƒÂ­a a verificar
	 * @return <code>true</code> si la cadena es un carnÃƒÂ© de extanjerÃƒÂ­a vÃƒÂ¡lido;
	 *         <code>false</code> otro caso
	 */
	public static boolean isCarneExtranjeria(String ce){
		if(isNull(ce)) return false;
		Matcher matcher = _patron_carnet_extranjeria.matcher(ce);
		return matcher.matches();
	}
	
	/**
	 * Retorna <code>true</code> Si la cadena es <code>null</code>, lo que indica
	 * una referencia a  <code>null</code> ,nada mÃƒÂ¡s que espacios, o la cadena
	 * "<code>null</code>".
	 *
	 * @param  s la cadena a verificar
	 * @return <code>true</code> si la cadena es <code>null</code>;
	 *         <code>false</code> otro caso
	 */
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
/**
 *
 * @param l
 * @return
 */
	public static boolean isNull(Long l) {
		if ((l == null) || (l.longValue() == 0)) {
			return true;
		}
		else {
			return false;
		}
	}


/**
 *
 * @param obj
 * @return
 */
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

	/**
	 * Retorna <code>true</code> si la cadena no es  <code>null</code>, esto indica
	 * que no es una referencia  <code>null</code>,nada mas que espacios, o la
	 * cadena "<code>null</code>".
	 *
	 * @param  s la cadena a verificar
	 * @return <code>true</code> si la cadena no es  <code>null</code>;
	 *         <code>false</code> en otro caso
	 */
	public static boolean isNotNull(Long l) {
		return !isNull(l);
	}

	/**
	 * Returns <code>true</code> if the object is not <code>null</code>, using
	 * the rules from {@link #isNotNull(Long)} or {@link #isNotNull(String)} if
	 * the object is one of these types.
	 *
	 * @param  obj the object to check
	 * @return <code>true</code> if the object is not <code>null</code>;
	 *         <code>false</code> otherwise
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * Returns <code>true</code> if the array is not <code>null</code>, meaning
	 * it is neither a <code>null</code> reference or empty.
	 *
	 * @param  array the array to check
	 * @return <code>true</code> if the array is not <code>null</code>;
	 *         <code>false</code> otherwise
	 */
	public static boolean isNotNull(Object[] array) {
		return !isNull(array);
	}


	/**
	 * Retorna <code>true</code> si la fecha es vÃƒÂ¡lida en el Calendario Gregoriano (PerÃƒÂº).
	 *
	 * @param  mes el mes a verificar (basado en 0,  0 para enero)
	 * @param  dia el dia a verificar
	 * @return <code>true</code> si la fecha es vÃƒÂ¡lida en el Calendario Gregoriano;
	 *         <code>false</code> en otro caso
	 */
	public static boolean isDate(int dia, int mes, int anio) {
		return isGregorianDate(dia, mes, anio);
	}

	/**
	 * Retorna <code>true</code> si la fecha es vÃƒÂ¡lida en el Calendario Gregoriano (PerÃƒÂº)..
	 *
	 * @param  mes el mes (basado en 0,  0 para enero)
	 * @param  dia el dÃƒÂ­a del mes
	 * @param  anio el aÃƒÂ±o
	 * @return <code>true</code> si la fecha es vÃƒÂ¡lida; <code>false</code>
	 *         en otro caso
	 */
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


/**
 *
 * @param num
 * @return
 */
	public static boolean isMayor_0(int num) {
		if(num>0)
			return true;
		return false;
	}
	
	public static boolean isCero(int num) {
		return (num == 0);
	}
	
/**
 *
 * @param cadena
 * @return
 */
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
	    String original = "ÃƒÂ¡ÃƒÂ ÃƒÂ¤ÃƒÂ©ÃƒÂ¨ÃƒÂ«ÃƒÂ­ÃƒÂ¬ÃƒÂ¯ÃƒÂ³ÃƒÂ²ÃƒÂ¶ÃƒÂºÃƒÂ¹uÃƒÂ±Ãƒï¿½Ãƒâ‚¬Ãƒâ€Ãƒâ€°ÃƒË†Ãƒâ€¹Ãƒï¿½ÃƒÅ’Ãƒï¿½Ãƒâ€œÃƒâ€™Ãƒâ€“ÃƒÅ¡Ãƒâ„¢ÃƒÅ“Ãƒâ€˜ÃƒÂ§Ãƒâ€¡";
	    // Cadena de caracteres ASCII que reemplazarÃƒÂ¡n los originales.
	    String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
	    String output = input;
	    for (int i=0; i<original.length(); i++) {
	        // Reemplazamos los caracteres especiales.
	        output = output.replace(original.charAt(i), ascii.charAt(i));
	    }//for i
	    return output;
	}//remove1
	
	 /******************************************************************************/
	/*************************** Solicitudes **************************************/
   /******************************************************************************/

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