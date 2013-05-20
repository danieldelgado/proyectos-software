package com.demo.geolocalizacion.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;

public class SimpleValidate {
	
	private static final Logger logger = CustomLog.getLogger(SimpleValidate.class);

	public static boolean validar(String expReg, String valor){ 
		logger.info(" validar expReg :"+expReg+ " valor:"+valor );
        Pattern patron = Pattern.compile(expReg) ; 
        Matcher encajador = patron.matcher(valor) ; 
        return encajador.matches() ; 
}  
	
	
}
