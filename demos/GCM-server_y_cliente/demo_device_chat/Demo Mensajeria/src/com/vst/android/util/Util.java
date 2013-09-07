package com.vst.android.util;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

public class Util {

	/**
	 * De CharSequence a String
	 * @param charSequence
	 * @return
	 */
	public static String getString(CharSequence charSequence){
		return charSequence.toString();
	}
	
	/**
	 * isNotNull
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		if(str!=null&&!(str.equals(""))){
			return true;
		}
		return false;
	}
	/**
	 * isNull
	 * @param str
	 * @return
	 */
	@SuppressWarnings("null")
	public static boolean isNull(String str) {
		if(str==null&&(str.equals(""))){
			return true;
		}
		return false;
	}
	
	/**
	 * lengthMayorCero
	 * @param str
	 * @return
	 */
	public static boolean lengthMayorCero(String str){
		if(str.length()>0){
			return true;
		}
		return false;
	}
	
	/**
	 * getMyPhoneNumber
	 * @param context
	 * @return
	 */
	public static String getMyPhoneNumber(Context context){
	    TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE); 
	    return mTelephonyMgr.getLine1Number();
	}
	/**
	 * getMy10DigitPhoneNumber
	 * @param context
	 * @return
	 */
	public static String getMy10DigitPhoneNumber(Context context){
	    String s = getMyPhoneNumber(context);
	    return s.substring(2);
	}

	public  static void displayMessage(Context context, String message) {
        Intent intent = new Intent(Constantes.intent.DISPLAY_MESSAGE_ACTION);
        intent.putExtra(Constantes.intent.EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
}
