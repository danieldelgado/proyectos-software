package com.vst.demochat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gcm.GCMRegistrar;
import com.vst.beans.Usuario;
import com.vst.service.SeguridadUsuario;
import com.vst.service.impl.SeguridadUsuarioImpl;
import com.vst.util.Constantes;
import com.vst.util.Util;

public class Registro_Usuario extends Activity {

	private Button btnregistrarUsuario = null;
	private SeguridadUsuario seguridadUsuario = null;
	private TextView txt_nombre_usuario = null;
	private TextView txt_apellido_usuario = null;
	private TextView txt_nick_name = null;
	private TextView txt_clave = null;
	private TextView txt_numero_movil = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		seguridadUsuario = new SeguridadUsuarioImpl();
		setContentView(R.layout.activity_registro__usuario);
		txt_nombre_usuario = (TextView) findViewById(R.id.txt_nombre_usuario);
		txt_apellido_usuario = (TextView) findViewById(R.id.txt_apellido_usuario);
		txt_nick_name = (TextView) findViewById(R.id.txt_nick_name);
		txt_clave = (TextView) findViewById(R.id.txt_clave);
		txt_numero_movil = (TextView) findViewById(R.id.txt_numero_movil);
		
		btnregistrarUsuario = (Button) findViewById(R.id.btn_regsitrar_usuario);
		btnregistrarUsuario.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				gsmRegistrer();
		        String regId = getRegistrationId();
		        System.out.println("regId:"+regId);
				String nombre = Util.getString(txt_nombre_usuario.getText());
				String apellido = Util.getString(txt_apellido_usuario.getText());
				String nickname =  Util.getString(txt_nick_name.getText());
				String clave =  Util.getString(txt_clave.getText());		
				String numero = Util.getString( txt_numero_movil.getText());				
				Usuario u = new Usuario(nombre, apellido, nickname, clave, numero,regId);
				int resultadoRegistro = seguridadUsuario.registrarNuevoUsuario(u);				
				System.out.println("resultadoRegistro:"+resultadoRegistro);
				
				Intent returnIntent = new Intent();
				returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
				setResult(RESULT_OK, returnIntent);
				finish();
			}

			
		});
	}
	
	private String getRegistrationId(){
		 String regId = GCMRegistrar.getRegistrationId(this);
		 return regId;
	}
	
	private void gsmRegistrer() {
		GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro__usuario, menu);
		return true;
	}

	
}
