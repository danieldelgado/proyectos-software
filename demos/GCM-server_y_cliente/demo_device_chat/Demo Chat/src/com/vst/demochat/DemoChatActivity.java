package com.vst.demochat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gcm.GCMRegistrar;
import com.vst.util.CargaDatosInicio;
import com.vst.util.Constantes;
import com.vst.util.DataCache;

public class DemoChatActivity extends Activity {

	private CargaDatosInicio cargaDatosInicio;
	private  BroadcastReceiver mHandleMessageReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_demo_chat);
		mHandleMessageReceiver = new BroadcastReceiver() {
	        @Override
	        public void onReceive(Context context, Intent intent) {
	        	System.out.println(" Registro_Usuario onReceive  ");
//	            String newMessage = intent.getExtras().getString(EXTRA_MESSAGE);
//	            mDisplay.append(newMessage + "\n");
	        }
	    };
	    registerReceiver(mHandleMessageReceiver,new IntentFilter(Constantes.DISPLAY_MESSAGE_ACTION));
		
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
//                    cargaDatosInicio.removeAllViews();                    
        			DataCache.putObject(this, Constantes.KEY_REGISTRADO_EN_SERVIDOR, true);
        			cargaDatosInicio.addTexviewMensaje("Usuario y dispositivo movil registrado");                    
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
	

	@Override
    protected void onDestroy() {
//        if (mRegisterTask != null) {
//            mRegisterTask.cancel(true);
//        }
        unregisterReceiver(mHandleMessageReceiver);
//        GCMRegistrar.onDestroy(this);
        super.onDestroy();
    }
	
}
