package com.vst.android.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class BroadCastRecepcionador extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.v(BroadCastRecepcionador.class.getName(), "onReceive");
		 String newMessage = intent.getExtras().getString(Constantes.intent.EXTRA_MESSAGE);
         Toast.makeText(context, "BroadCastRecepcionador:"+newMessage,Toast.LENGTH_LONG).show();         
		Bundle extras = intent.getExtras();
		if (extras != null) {
			String state = extras.getString(TelephonyManager.EXTRA_STATE);
			Log.w("MY_DEBUG_TAG", state);
			if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
				String phoneNumber = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
				Log.w("MY_DEBUG_TAG", phoneNumber);
			}
		}
		Toast.makeText(context, "BroadCastRecepcionador Broadcast Intent Detected.",Toast.LENGTH_LONG).show();
//		 Intent service = new Intent(context, WordService.class);
//		    context.startService(service);
	}

}
