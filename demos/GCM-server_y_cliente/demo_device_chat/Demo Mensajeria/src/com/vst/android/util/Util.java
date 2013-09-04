package com.vst.android.util;

public class Util {

	public static String getString(CharSequence charSequence){
		return charSequence.toString();
	}

	public static boolean isNotNull(String str) {
		if(str!=null&&!(str.equals(""))){
			return true;
		}
		return false;
	}
	
	public static boolean lengthMayorCero(String str){
		if(str.length()>0){
			return true;
		}
		return false;
	}
	
}
