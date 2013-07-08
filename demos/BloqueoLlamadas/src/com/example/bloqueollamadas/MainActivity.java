package com.example.bloqueollamadas;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.android.internal.telephony.ITelephony;

public class MainActivity extends Activity {

	CheckBox blockAll_cb;
	BroadcastReceiver CallBlocker;
	TelephonyManager telephonyManager;
	ITelephony telephonyService;

	 
	@Override
	 public void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
	 setContentView(R.layout.activity_main);
	 initviews();
	 blockAll_cb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

	@Override
	 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

	 CallBlocker =new BroadcastReceiver()
	 {
	 @Override
	 public void onReceive(Context context, Intent intent) {

	 telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);

	 Class c = null;

	 try {
	 c = Class.forName(telephonyManager.getClass().getName());
	 } catch (ClassNotFoundException e) {
	 e.printStackTrace();
	 }

	 Method m = null;

	 try {
	 m = c.getDeclaredMethod("getITelephony");
	 } catch (SecurityException e) {
	 e.printStackTrace();
	 } catch (NoSuchMethodException e) {
	 e.printStackTrace();
	 }

	 m.setAccessible(true);

	 try {
	 telephonyService = (ITelephony)m.invoke(telephonyManager);
	 } catch (IllegalArgumentException e) {
	 e.printStackTrace();
	 } catch (IllegalAccessException e) {
	 e.printStackTrace();
	 } catch (InvocationTargetException e) {
	 e.printStackTrace();
	 }
	 telephonyManager.listen(callBlockListener, PhoneStateListener.LISTEN_CALL_STATE);
	 }//onReceive()

	 PhoneStateListener callBlockListener = new PhoneStateListener()
	 {
	 public void onCallStateChanged(int state, String incomingNumber)
	 {
		 System.out.println("INCOMING NUMBER" + incomingNumber);
	 if(state==TelephonyManager.CALL_STATE_RINGING)
	 {
	 if(blockAll_cb.isChecked())
	 {
	 try {
	 telephonyService.endCall();
	 } catch (RemoteException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 }
	 }
	 };
	 };//BroadcastReceiver

	 IntentFilter filter= new IntentFilter("android.intent.action.PHONE_STATE");
	 registerReceiver(CallBlocker, filter);
	 }
	 });
	 }//fin createView

	 public void initviews()
	 {
	 blockAll_cb=(CheckBox)findViewById(R.id.cbBlockAll);
	 }

	 @Override
	 protected void onDestroy() {
	 super.onDestroy();
	 if (CallBlocker != null)
	 {
	 unregisterReceiver(CallBlocker);
	 CallBlocker = null;
	 }
	 }
	}
