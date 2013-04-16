package prueb1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

	
	public static boolean isn(String valor) {
		return validar("[a-zA-Z0-9\\s-]{1,100}", valor);
	}

	public static boolean validar(String expReg, String valor) {
		Pattern patron = Pattern.compile(expReg);
		Matcher encajador = patron.matcher(valor);
		return encajador.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isn("awsd2354324"));
	}

}