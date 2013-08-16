package com.vst.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TraductorDeExcepciones {

	private static final Logger log = LoggerFactory.getLogger(ArchivoUtil.class);

	public static void traducir(String msg,Exception e) {	
		log.error(msg+" "+e.getMessage() + " " + e.getLocalizedMessage() + " " +e.getCause() , e);		
		e.printStackTrace();		
	}
}
