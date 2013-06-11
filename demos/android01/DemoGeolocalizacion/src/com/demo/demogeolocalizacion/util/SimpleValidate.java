package com.demo.demogeolocalizacion.util;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleValidate {


	/**
	 * Valida el formato de cualquier cadena, son eviandole los 2 parametros la expresion regular y el valor.
	 * Retorna true si es correcto el formato
	 * @param expReg
	 * @param valor
	 * @return
	 */
	public static boolean validar(String expReg, String valor) {
		Pattern patron = Pattern.compile(expReg);
		Matcher encajador = patron.matcher(valor);
		boolean r = encajador.matches();
		return r;
	}
	/**
	 * Valida la fecha segun el formato enviado
	 * return true si es correcto.
	 * @param format
	 * @param fechax
	 * @return
	 */
	public static boolean validarFecha(String format,String fechax) {
		boolean r = false;
        try {
            final SimpleDateFormat formatoFecha = new SimpleDateFormat(format);
            formatoFecha.parse(fechax);
            r = true;
        } catch (Exception e) {
            r = false;
        }
        return r;
    }

}
