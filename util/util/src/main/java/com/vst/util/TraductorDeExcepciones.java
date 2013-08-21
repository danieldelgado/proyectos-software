package com.vst.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vst.util.archivo.ArchivoUtil;



public class TraductorDeExcepciones {

	private static final Logger log = LoggerFactory.getLogger(ArchivoUtil.class);

	public static void traducir(String msg,Exception e) {	
		log.error(msg+" "+e.getMessage() + " " + e.getLocalizedMessage() + " " +e.getCause() , e);		
		e.printStackTrace();		
	}

	public static void traducir(Exception e) {
		log.error(e.getMessage() + " " + e.getLocalizedMessage() + " " +e.getCause() , e);		
		e.printStackTrace();
	}

}
