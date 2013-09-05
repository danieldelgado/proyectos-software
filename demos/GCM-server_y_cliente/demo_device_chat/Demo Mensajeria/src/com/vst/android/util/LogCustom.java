package com.vst.android.util;

public class LogCustom  {

	private final static String tipLog="LogCustomDM-";
	
	private LogCustom() {}
	
	public static String ocm(Object object){
		return tipLog+object.getClass().getName();
	}
	public static String ocm(){
		return tipLog;
	}
}
