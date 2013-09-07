package com.vst.android.util;

public class LogCustom  {

	private final static String tipLog="LogCustomDM-";
	
	public static final class mensajes {
		public static final String registro_exitoso = tipLog+"Registro existoso.";
	}

	private LogCustom() {}


	
//	public static String ocm(Object object){
//		return tipLog+object.getClass().getName();
//	}
	public static String ocm(){
		return tipLog;
	}
//	public static String ocml(Object object){
//		return tipLog+object;
//	}
}
