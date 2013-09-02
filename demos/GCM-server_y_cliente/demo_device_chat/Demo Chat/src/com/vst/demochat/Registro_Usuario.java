package com.vst.demochat;

import java.io.IOException;

import org.json.JSONException;

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
	private String regId = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro__usuario);
		seguridadUsuario = new SeguridadUsuarioImpl();
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
		        System.out.println("regId:"+regId);
				String nombre = Util.getString(txt_nombre_usuario.getText());
				String apellido = Util.getString(txt_apellido_usuario.getText());
				String nickname =  Util.getString(txt_nick_name.getText());
				String clave =  Util.getString(txt_clave.getText());		
				String numero = Util.getString( txt_numero_movil.getText());				
				Usuario u = new Usuario(nombre, apellido, nickname, clave, numero,regId);
				int resultadoRegistro;
				try {
					resultadoRegistro = seguridadUsuario.registrarNuevoUsuario(u);
					System.out.println("resultadoRegistro:"+resultadoRegistro);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}				
				
				Intent returnIntent = new Intent();
				returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
	
	private void gsmRegistrer() {
		GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
        regId = GCMRegistrar.getRegistrationId(this);
        if (regId.equals("")) {
            GCMRegistrar.register(this, Constantes.SENDER_ID);
            regId = GCMRegistrar.getRegistrationId(this);
        }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro__usuario, menu);
		return true;
	}
	
}