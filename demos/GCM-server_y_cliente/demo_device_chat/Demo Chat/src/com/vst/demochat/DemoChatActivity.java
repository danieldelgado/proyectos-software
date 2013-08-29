package com.vst.demochat;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.Toast;

public class DemoChatActivity extends Activity {

	private CargaDatosInicio cargaDatosInicio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_demo_chat);
//		cargaDatosInicio = new CargaDatosInicio(this);
//		new Thread(cargaDatosInicio).start();
		
//		connect();
		
		

		Registro_Usuario.register("asdsa");

		System.out.println("connect1");
		
		new Connection().execute();

	}

//	private void connect() {
//		try {
//			DefaultHttpClient client = new DefaultHttpClient();
//			HttpGet request = new HttpGet("http://www.google.com");
//			HttpResponse response = client.execute(request);
//		} catch (ClientProtocolException e) {
////			Log.d("HTTPCLIENT", e.getLocalizedMessage());
//		} catch (IOException e) {
////			Log.d("HTTPCLIENT", e.getLocalizedMessage());
//		}
//	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {		
		switch(requestCode) {
			case Constantes.INTENT_REGISTAR_USUARIO: 
            if (resultCode == RESULT_OK) {
                int usuarioRegsitrado = data.getIntExtra(Constantes.KEY_USUARIO_REGISTRADO, 0);  
                if(usuarioRegsitrado>0){
                    Toast.makeText(this, Constantes.MSJ_USUARIO_REGISTRO__EXITOSO, Toast.LENGTH_LONG).show();              
                    cargaDatosInicio.removeAllViews(); 
                }
                break;
            }
		}
	}

	public void irRegistroUsuaroActivity() {
		Intent intent = new Intent();
		intent.setClass(this, Registro_Usuario.class);
		System.out.println("iniciando Registro_Usuario");
		startActivityForResult(intent, Constantes.INTENT_REGISTAR_USUARIO);
	}

	private class Connection extends AsyncTask {

		@Override
		protected Object doInBackground(Object... arg0) {
			connect();
			return null;
		}

	}

	private void connect() {
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://www.google.com");
			HttpResponse response = client.execute(request);
			System.out.println("connect");
		} catch (ClientProtocolException e) {
//			Log.d("HTTPCLIENT", e.getLocalizedMessage());
		} catch (IOException e) {
//			Log.d("HTTPCLIENT", e.getLocalizedMessage());
		}
	}

	
}
