package com.vst.demochat;

import com.vst.util.CargaDatosInicio;
import com.vst.util.Constantes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class DemoChatActivity extends Activity {

	private CargaDatosInicio cargaDatosInicio;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_demo_chat);
		cargaDatosInicio = new CargaDatosInicio(this);
		new Thread(cargaDatosInicio).start();
		
	}

	
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
	
}
