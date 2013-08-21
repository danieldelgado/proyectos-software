package com.vst.util.encriptacion;

public class Encriptador {

	private  static final String passPhrase = "Util";
	private  static final StringEncrypter desEncrypter = new StringEncrypter(passPhrase);

	public static String desencripta(String s) throws Exception {
		return desEncrypter.decrypt(s);
	}
	
	public static String encripta(String s) throws Exception {
		return desEncrypter.encrypt(s);
	}

}