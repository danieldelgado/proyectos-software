package com.vst.demochat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.vst.beans.Usuario;
import com.vst.service.SeguridadUsuario;
import com.vst.service.impl.SeguridadUsuarioImpl;
import com.vst.util.Constantes;

public class Registro_Usuario extends Activity {

	private Button btnregistrarUsuario = null;
	private SeguridadUsuario seguridadUsuario = null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		seguridadUsuario = new SeguridadUsuarioImpl();
		setContentView(R.layout.activity_registro__usuario);
		
		btnregistrarUsuario = (Button) findViewById(R.id.btn_regsitrar_usuario);
		btnregistrarUsuario.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Usuario u = new Usuario("andUser01", "andUser01", "andUser01", "andUser01");
				seguridadUsuario.registrarNuevoUsuario(u);
				
				Intent returnIntent = new Intent();
				returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
				setResult(RESULT_OK, returnIntent);
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
