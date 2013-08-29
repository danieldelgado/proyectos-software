package com.vst.demochat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DemoChatActivity extends Activity {
	
	 private static final int REQUEST_CODE = 10;
		public static final int BOOK_SELECT = 1;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_demo_chat);
		new Thread(new CargaDatosInicio(this)).start();	
		
//		Button btn = new Button(this);
//		btn.setText("registrar");
//		btn.setTextColor(Color.WHITE);
//		LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.principal);
//		linearLayout.addView(btn);
//		
//		btn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				irRegistroUsuaroActivity();
//			}			
//		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Toast.makeText(this, "Retornoooo XD", Toast.LENGTH_LONG).show();
		System.out.println("onActivityResult");
		System.out.println(requestCode);
		System.out.println(resultCode);
//		System.out.println(data.getDataString());
		
		
	   
	  }

	public void irRegistroUsuaroActivity(){		
		Intent intent = new Intent();
//		Intent intent = new Intent(DemoChatActivity.this,Registro_Usuario.class);
		intent.setClass(this,Registro_Usuario.class);
		System.out.println("iniciando Registro_Usuario");
		startActivityForResult(intent,BOOK_SELECT);
//		startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		  case R.id.itemRun:			  		  
//              return true; 
//		}
		return false;
	}

//	08-29 20:36:21.465: E/AndroidRuntime(1887): 	at com.vst.demochat.DemoChatActivity.onActivityResult(DemoChatActivity.java:51)

}
