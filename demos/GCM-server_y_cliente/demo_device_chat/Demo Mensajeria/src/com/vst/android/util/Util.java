package com.vst.android.util;

import android.content.Context;
import android.telephony.TelephonyManager;

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
	
	public static String getMyPhoneNumber(Context context){
	    TelephonyManager mTelephonyMgr;
	    mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); 
	    return mTelephonyMgr.getLine1Number();
	}
	
	public static String getMy10DigitPhoneNumber(Context context){
	    String s = getMyPhoneNumber(context);
	    return s.substring(2);
	}
}
