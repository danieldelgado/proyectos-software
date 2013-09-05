package com.vst.android.demo.mensajeria;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.vst.android.service.SeguridadService;
import com.vst.android.service.impl.SeguridadServiceImpl;
import com.vst.android.util.Constantes;
import com.vst.android.util.Util;
//import com.vst.demo.mensajeria.R;

public class RegistroActivity extends Activity {

	private TextView txtNumero ;
	private TextView txtEmail ;
	private Button btnGuardar ;	
	private SeguridadService seguridadService;
	private AsyncTask<Void, Void, Void> task;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_registro);
		Log.v(RegistroActivity.class.getName(), "onCreate  iniciando Activity");
		seguridadService = new SeguridadServiceImpl();
		txtNumero = (TextView) findViewById(R.id.txtNumero);
		txtNumero.setText(Constantes.INSTANCE.str_telefono);
		txtEmail = (TextView) findViewById(R.id.txtEmail);
		btnGuardar = (Button) findViewById(R.id.btnGuardar);		
		btnGuardar.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {				
				registrarDispositivoEnServidor();				
			}
		});	
	}
		
	private void registrarDispositivoEnServidor() {		
		task = new AsyncTask<Void, Void, Void>() {
			String numero = null;
			String email = null;
			@Override
			protected void onPreExecute() {
				numero = Util.getString(txtNumero.getText());
				email = Util.getString(txtEmail.getText());	
			}			
			@Override
			protected Void doInBackground(Void... arg0) {				
				Log.v(RegistroActivity.class.getName(), "registrarDispositivoEnServidor numero:"+numero+" email:"+email);
				int r = seguridadService.registrarEnServidor("asdsde1erwfewfewffew",numero,email);
				Log.v(RegistroActivity.class.getName(), "registrarDispositivoEnServidor r:"+r);
				if(r>0){
					Intent returnIntent = new Intent();
//					returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
//					returnIntent.putExtra(Constantes.REG_ID_DEVICE, regId);
					setResult(RESULT_OK, returnIntent);
					finish();
				}
				return null;
			}			
		};
		task.execute((Void[]) null);
	}

	@Override
	public void onBackPressed() {
		Log.v(RegistroActivity.class.getName(), "onBackPressed");
		super.onBackPressed();
	}
	
	@Override
	protected void onPostResume() {
		Log.v(RegistroActivity.class.getName(), "onPostResume");
		super.onPostResume();
	}
	
	@Override
	protected void onPause() {
		Log.v(RegistroActivity.class.getName(), "onPause");
		super.onPause();		
	}
	
	@Override
	protected void onDestroy() {
		Log.v(RegistroActivity.class.getName(), "onDestroy");
		super.onDestroy();	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro, menu);
		return true;
	}
	

}
