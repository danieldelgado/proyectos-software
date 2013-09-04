package com.vst.android.demo.mensajeria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.vst.demo.mensajeria.R;

public class RegistroActivity extends Activity {

	private Button btnGuardar ;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_registro);
		Log.v(RegistroActivity.class.getName(), "onCreate  iniciando Activity");	
		
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent returnIntent = new Intent();
//				returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
//				returnIntent.putExtra(Constantes.REG_ID_DEVICE, regId);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});	
	}
		
	@Override
	public void onBackPressed() {
		Log.v(MensajeriaActivity.class.getName(), "onBackPressed");
		super.onBackPressed();
	}
	
	@Override
	protected void onPostResume() {
		Log.v(MensajeriaActivity.class.getName(), "onPostResume");
		super.onPostResume();
	}
	
	@Override
	protected void onPause() {
		Log.v(MensajeriaActivity.class.getName(), "onPause");
		super.onPause();		
	}
	
	@Override
	protected void onDestroy() {
		Log.v(MensajeriaActivity.class.getName(), "onDestroy");
		super.onDestroy();	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro, menu);
		return true;
	}
	

}
