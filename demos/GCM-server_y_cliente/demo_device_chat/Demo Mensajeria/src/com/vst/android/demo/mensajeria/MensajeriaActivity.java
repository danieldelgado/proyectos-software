package com.vst.android.demo.mensajeria;

import java.util.List;

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
	private SeguridadService seguridadService;
	
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
		Log.v( MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onCreate  iniciando Activity");
		seguridadService = new SeguridadServiceImpl();
		instaceNumeroTelefono();
		gsmRegistrer();
		// validarDatosUsuario();

	}

	private void instaceNumeroTelefono() {
		// Constantes.INSTANCE.str_telefono =
		// String.valueOf(DataCache.obtenerValorSharedPreferences(this,
		// Constantes.TIPO_VARIABLE.TIPO_STRING,
		// Constantes.KEYS.KEY_ESTE_NUMERO_TELEFONO));
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "str_telefono1:"+Constantes.INSTANCE.str_telefono);
		// if(!Util.isNull(Constantes.INSTANCE.str_telefono)){
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "entra al if str_telefono:"+Constantes.INSTANCE.str_telefono);
		Constantes.INSTANCE.str_telefono = Util.getMyPhoneNumber(this);
		// DataCache.putObject(this, Constantes.KEYS.KEY_ESTE_NUMERO_TELEFONO,
		// Constantes.INSTANCE.str_telefono);
		// }
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "numero telefono :" + Constantes.INSTANCE.str_telefono);
	}
	

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		RowItem row = rowItems.get(position);
		Toast toast = Toast.makeText(getApplicationContext(), "Item " + (position + 1) + ": " + row.getNombre(), Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	private void validarDatosUsuario() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "validarDatosUsuario");
		task = new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				pd = ProgressDialog.show(context, "", "Cargando...", true);
				Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "ProgressDialog");

			}

			@Override
			protected Void doInBackground(Void... arg0) {
				try {
					Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "doInBackground init");
					int regIdExisteDevice = existeRegisterIDinMobile();
					Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "regIdExisteDevice : " + regIdExisteDevice);
					if (regIdExisteDevice == Constantes.REGISTROS.REGISTRO_ID_MOBILE_EXISTE) {
						listarUsuarios();
					} else if (regIdExisteDevice == Constantes.REGISTROS.REGISTRO_ID_MOBILE_NO_EXISTE) {
						boolean estoyRegistradoServidor = seguridadService.validarRegistroServidor(Constantes.INSTANCE.regId,
								Constantes.INSTANCE.str_telefono);
						if (estoyRegistradoServidor)
							registrarEnDispositivo();
						else
							irRegistroUsuaroActivity();
					}
					Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "doInBackground termina");
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				if (pd != null) {
					pd.dismiss();
				}
				task = null;
				Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onPostExecute");
			}
		};
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "task execute");
		task.execute((Void[]) null);
	}

	private void gsmRegistrer() {

		GCMRegistrar.checkDevice(this);
		GCMRegistrar.checkManifest(this);

		
		registerReceiver(mHandleMessageReceiver, new IntentFilter(Constantes.INTENT.DISPLAY_MESSAGE_ACTION));

		Constantes.INSTANCE.regId = GCMRegistrar.getRegistrationId(this);
		if (Constantes.INSTANCE.regId.equals("")) {
			GCMRegistrar.register(this, Constantes.GCM_ID.SENDER_ID);
			// Constantes.INSTANCE.regId = GCMRegistrar.getRegistrationId(this);
		} else {
			if (GCMRegistrar.isRegisteredOnServer(this)) {
				Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "REGISTRADO EN SERVIDOR");
			} else {
				task = new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						boolean estoyRegistradoServidor = seguridadService.validarRegistroServidor(Constantes.INSTANCE.regId,
								Constantes.INSTANCE.str_telefono);
						if (estoyRegistradoServidor) {
							GCMRegistrar.setRegisteredOnServer(context, true);
						}
						Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "estoyRegistradoServidor:" + estoyRegistradoServidor);
						return null;
					}

					@Override
					protected void onPostExecute(Void result) {
						task = null;
					}

				};
				task.execute(null, null, null);
			}
		}
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "gsmRegistrer regId:" + Constantes.INSTANCE.regId);
	}

	private void registrarEnDispositivo() {
		// gsmRegistrer();
	}

	protected int existeRegisterIDinMobile() {
		// String regID =
		// String.valueOf(DataCache.obtenerValorSharedPreferences(context,
		// Constantes.TIPO_VARIABLE.TIPO_STRING,
		// Constantes.KEYS.KEY_REG_ID_DEVICE));
		// Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+
		// "existeRegisterIDinMobile : " + regID);
		// if (Util.isNotNull(regID)) {
		// if (Util.lengthMayorCero(regID)) {
		// return Constantes.REGISTROS.REGISTRO_ID_MOBILE_EXISTE;
		// }
		// }
		return Constantes.REGISTROS.REGISTRO_ID_MOBILE_NO_EXISTE;
	}

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

	private void varialesNull() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "rowItems:" + rowItems);
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "item:" + item);
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "listView:" + listView);
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "adapter:" + adapter);
		rowItems = null;
		item = null;
		listView = null;
		adapter = null;
	}

	public void irRegistroUsuaroActivity() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "irRegistroUsuaroActivity");
		Intent intent = new Intent();
		intent.setClass(this, RegistroActivity.class);
		startActivityForResult(intent, Constantes.INTENT.INTENT_REGISTAR_USUARIO);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onActivityResult");

	}

	@Override
	public void onBackPressed() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onBackPressed");
		super.onBackPressed();
	}

	@Override
	protected void onPostResume() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onPostResume");
		super.onPostResume();
	}

	@Override
	protected void onPause() {
		Log.v(MensajeriaActivity.class.getName(),LogCustom.ocm()+ "onPause");
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		GCMRegistrar.unregister(this);
		if (mHandleMessageReceiver != null) {
			unregisterReceiver(mHandleMessageReceiver);
		}
		if (pd != null) {
			pd.dismiss();
		}
		GCMRegistrar.onDestroy(this);
		Log.v(LogCustom.ocm(this), "is 1  " + GCMRegistrar.isRegistered(this));
		Log.v(LogCustom.ocm(this), "is 2 " + GCMRegistrar.isRegisteredOnServer(this));
		Log.v(LogCustom.ocm(this), "onDestroy");
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mensajeria, menu);
		return true;
	}

}
