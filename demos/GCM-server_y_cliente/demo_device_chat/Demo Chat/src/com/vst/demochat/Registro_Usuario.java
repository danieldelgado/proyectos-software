package com.vst.demochat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Registro_Usuario extends Activity {

	private Button btnregistrarUsuario = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro__usuario);
		btnregistrarUsuario = (Button) findViewById(R.id.btn_regsitrar_usuario);
		btnregistrarUsuario.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent returnIntent = new Intent();
		    	returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO,Constantes.REGISTRO_EXITOSO_USUARIO);
		    	setResult(RESULT_OK,returnIntent); 
		    	finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro__usuario, menu);
		return true;
	}

}
