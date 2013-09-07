package com.vst.android.demo.mensajeria;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gcm.GCMRegistrar;
import com.vst.android.adapter.CustomListViewAdapter;
import com.vst.android.beans.RowItem;
import com.vst.android.service.SeguridadService;
import com.vst.android.service.impl.SeguridadServiceImpl;
import com.vst.android.util.BroadCastRecepcionador;
import com.vst.android.util.Constantes;
import com.vst.android.util.LogCustom;
import com.vst.android.util.Util;

public class MensajeriaActivity extends Activity implements OnItemClickListener {

	private Context context = this;
	private ProgressDialog pd;
	private ListView listView;
	private List<RowItem> rowItems;
	private CustomListViewAdapter adapter;
	private RowItem item;
	private AsyncTask<Void, Void, Void> task;
	private SeguridadService seguridadService = SeguridadServiceImpl.newStaticInstance();// usar
																							// un
																							// apuntador
																							// del
																							// objeto
																							// ya
																							// creado
																							// e
																							// instanciado
																							// y
																							// se
																							// obtiene
																							// mediante
																							// esta
																							// linea.
	private BroadCastRecepcionador mHandleMessageReceiver = new BroadCastRecepcionador();

	// public static final String[] titles = new String[] { "Strawberry",
	// "Banana", "Orange", "Mixed" };
	// public static final Integer[] images = { R.drawable.android_logo,
	// R.drawable.android_logo, R.drawable.android_logo, R.drawable.android_logo
	// };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "onCreate  iniciando Activity");
		instaceNumeroTelefono();
		gcmRegistrer();
		validarGCmRegistrer();
	}

	/**
	 * Metodo por el cual obtengo e instancio el numero de telefono en
	 * Constantes.INSTANCE.str_telefono
	 */
	private void instaceNumeroTelefono() {
		Constantes.instance.str_telefono = Util.getMyPhoneNumber(this);
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "numero telefono :" + Constantes.instance.str_telefono);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		RowItem row = rowItems.get(position);
		Toast toast = Toast.makeText(getApplicationContext(), "Item " + (position + 1) + ": " + row.getNombre(), Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	/**
	 * Metodo donde regsitro el dispositvo y ejecuto el metodo el
	 * registerReceiver BroadcastReceiver. Valido el
	 * GCMRegistrar.getRegistrationId(this) dentro de Constantes.INSTANCE.regId
	 * en el caso de que este vacio ejecuto GCMRegistrar.register(this,
	 * Constantes.GCM_ID.SENDER_ID) para regsitrarme el google y poder obtener
	 * el nuevo valor pero es gestionado por la clase GCMIntentService. Caso
	 * contrario de que si tenga valor el Constantes.INSTANCE.regId valido si
	 * esta en base de datos en el servidor.
	 */

	private void gcmRegistrer() {
		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);
		registerReceiver(mHandleMessageReceiver, new IntentFilter(Constantes.intent.DISPLAY_MESSAGE_ACTION));
		Constantes.instance.regId = GCMRegistrar.getRegistrationId(this);
	}

	private void validarGCmRegistrer() {
		if (Constantes.instance.regId.equals("")) {
			GCMRegistrar.setRegisteredOnServer(context, false);
			GCMRegistrar.register(this, Constantes.gcm_id.SENDER_ID);
			irRegistroUsuaroActivity();
		} else {
			task = new AsyncTask<Void, Void, Void>() {
				protected Void doInBackground(Void... params) {
					try {
						boolean estoyRegistradoServidor = seguridadService.validarRegistroServidor(Constantes.instance.regId);
						boolean isRegister = GCMRegistrar.isRegisteredOnServer(context);
						if (isRegister && estoyRegistradoServidor) {
							Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "REGISTRADO EN SERVIDOR");
						} else {
							Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm()+ "validarGCmRegistrer doInBackground validar si estoy en servidor");
							if (estoyRegistradoServidor) {
								GCMRegistrar.setRegisteredOnServer(context, true);
								// listado de usuarios
							} else {
								GCMRegistrar.setRegisteredOnServer(context, false);
								GCMRegistrar.unregister(context);
								gcmRegistrer();
								validarGCmRegistrer();
							}
						}
					} catch (ClientProtocolException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
					return null;
				}
				protected void onPostExecute(Void result) {
					task = null;
				}
			};
			task.execute(null, null, null);
		}
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "gsmRegistrer regId:" + Constantes.instance.regId);
	}

	// Metodo ejecutado para ir al Activity Registrar Usuario
	public void irRegistroUsuaroActivity() {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "irRegistroUsuaroActivity");
		Intent intent = new Intent();
		intent.setClass(this, RegistroActivity.class);
		startActivityForResult(intent, Constantes.intent.INTENT_REGISTAR_USUARIO);
	}

	// Metodo que se ejecuta del Activity termiando y espero una respuesta.
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "onActivityResult");
		switch (requestCode) {
		case Constantes.intent.INTENT_REGISTAR_USUARIO:
			if (resultCode == RESULT_OK) {
				validarGCmRegistrer();
			}
			break;
		}
	}

	/*
	 * *****************************************************************************************
	 */

	private void listarUsuarios() {
		varialesNull();
		// rowItems = new ArrayList<RowItem>();
		// for (int i = 0; i < titles.length; i++) {
		// item = new RowItem(i, titles[i], null);
		// rowItems.add(item);
		// }
		// listView = (ListView) findViewById(R.id.listview);
		// adapter = new CustomListViewAdapter(this, R.layout.list_item,
		// rowItems);
		// listView.setAdapter(adapter);
		// listView.setOnItemClickListener(this);
	}

	// varialbes a null para liberar memoria
	private void varialesNull() {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "rowItems:" + rowItems);
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "item:" + item);
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "listView:" + listView);
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "adapter:" + adapter);
		rowItems = null;
		item = null;
		listView = null;
		adapter = null;
	}

	private void validarDatosUsuario() {
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "validarDatosUsuario");
		// task = new AsyncTask<Void, Void, Void>() {
		// @Override
		// protected void onPreExecute() {
		// pd = ProgressDialog.show(context, "", "Cargando...", true);
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "ProgressDialog");
		//
		// }
		// @Override
		// protected Void doInBackground(Void... arg0) {
		// try {
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "doInBackground init");
		// int regIdExisteDevice = existeRegisterIDinMobile();
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "regIdExisteDevice : " + regIdExisteDevice);
		// if (regIdExisteDevice ==
		// Constantes.REGISTROS.REGISTRO_ID_MOBILE_EXISTE) {
		// listarUsuarios();
		// } else if (regIdExisteDevice ==
		// Constantes.REGISTROS.REGISTRO_ID_MOBILE_NO_EXISTE) {
		// boolean estoyRegistradoServidor =
		// seguridadService.validarRegistroServidor(Constantes.INSTANCE.regId,
		// Constantes.INSTANCE.str_telefono);
		// if (estoyRegistradoServidor)
		// registrarEnDispositivo();
		// else
		// irRegistroUsuaroActivity();
		// }
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "doInBackground termina");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
		// }
		//
		// @Override
		// protected void onPostExecute(Void result) {
		// if (pd != null) {
		// pd.dismiss();
		// }
		// task = null;
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "onPostExecute");
		// }
		// };
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "task execute");
		// task.execute((Void[]) null);
	}

	@Override
	public void onBackPressed() {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "onBackPressed");
		super.onBackPressed();
	}

	@Override
	protected void onPostResume() {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "onPostResume");
		super.onPostResume();
	}

	@Override
	protected void onPause() {
		Log.v(MensajeriaActivity.class.getName(), LogCustom.ocm() + "onPause");
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		// GCMRegistrar.unregister(this);
		// GCMRegistrar.setRegisteredOnServer(context, false);
		if (mHandleMessageReceiver != null) {
			unregisterReceiver(mHandleMessageReceiver);
		}
		if (pd != null) {
			pd.dismiss();
		}
		GCMRegistrar.onDestroy(this);
		// Log.v(MensajeriaActivity.class.getName(), ("is 1  " +
		// GCMRegistrar.isRegistered(this)));
		// Log.v(MensajeriaActivity.class.getName(), ("is 2 " +
		// GCMRegistrar.isRegisteredOnServer(this)));
		// Log.v(MensajeriaActivity.class.getName(), ("onDestroy"));
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mensajeria, menu);
		return true;
	}

}
