package com.vst.util;

import com.vst.demochat.DemoChatActivity;
import com.vst.demochat.R;
import com.vst.demochat.R.id;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CargaDatosInicio implements Runnable {

	private DemoChatActivity demoChatActivity;
	private LinearLayout linearLayout;
	private TextView newText;
	
	public CargaDatosInicio(DemoChatActivity demoChatActivity) {
		this.demoChatActivity = demoChatActivity;
		linearLayout = (LinearLayout) demoChatActivity.findViewById(R.id.principal);
		addTexviewMensaje("Cargando");
	}

	@Override
	public void run() {
		validarSiseRegsitroEnServer();
	}

	private void validarSiseRegsitroEnServer() {
		boolean reg = DataCache.existeValor(demoChatActivity, Constantes.TIPO_BOOLEAN, Constantes.KEY_REGISTRADO_EN_SERVIDOR);
		addTexviewMensaje("Registrado en servidor " + ((reg) ? "SI" : "NO"));
		if (reg) {
			addTexviewMensaje("Validando registro");
			reg = validarExistenciaEnServidor();
			if (!reg) {
				DataCache.putObject(demoChatActivity, Constantes.KEY_REGISTRADO_EN_SERVIDOR, true);
				addTexviewMensaje("Dispositivo movil registrado");
			}
		} else {
			addTexviewMensaje("Para registrarse en el servidor debe ingresar alguno datos");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			demoChatActivity.irRegistroUsuaroActivity();			
//			DataCache.putObject(demoChatActivity, Constantes.KEY_REGISTRADO_EN_SERVIDOR, true);
//			addTexviewMensaje("Dispositivo movil registrado");
		}
	}

	private boolean validarExistenciaEnServidor() {
		return true;
	}

	public void addTexviewMensaje(final String msj) {
		demoChatActivity.runOnUiThread(new Runnable() {
			public void run() {
				newText = new TextView(demoChatActivity);
				newText.setText(msj);
				newText.setTextColor(Color.WHITE);
				linearLayout.addView(newText);
			}
		});

	}

	public void removeAllViews() {		
		linearLayout.removeAllViews();	
	}

}