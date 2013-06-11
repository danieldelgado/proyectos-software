package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.demogeolocalizacion.util.Constantes;
import com.demo.demogeolocalizacion.util.SimpleValidate;
import com.demo.demogeolocalizacion.ws.client.GeolocalizacionWService;

public class MainActivity extends Activity {

	EditText editText1;
	private static final String VERBOSE = "MyActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText) findViewById(R.id.et1);
		Log.v(VERBOSE, "Prueba 10");

		// Resources resources = this.getResources();
		// AssetManager assetManager = resources.getAssets();
		// try {
		// InputStream inputStream = assetManager.open("config.properties");
		// Properties properties = new Properties();
		// properties.load(inputStream);
		// Log.v(VERBOSE, "Ani " + properties.get("url.web.service"));
		// System.out.println("The properties are now loaded");
		// } catch (Exception e) {
		// e.printStackTrace();
		// System.out.println(e.toString());
		// }

		SharedPreferences prefe = getSharedPreferences("datos",
				Context.MODE_PRIVATE);
		// editText1.setText(prefe.getString("nroCelular",""));

		String celular = prefe.getString("nroCelular", "");
		//
		if (!celular.equals("")) {
			Integer res = GeolocalizacionWService
					.existeUsuarioPorNumero(celular);
			if (!validarFormatoNumero(celular)) {
				return;
			}
			if (res.equals(Constantes.USUARIO_NO_EXISTE)) {
				Intent i = new Intent(this, IngresarDatosActivity.class);
				i.putExtra("numeroTelefono", celular);
				startActivity(i);
				finish();
			} else {
				guardarPreference();
				Intent i = new Intent(this, MapaActivity.class);
				i.putExtra("numeroTelefono", celular);
				startActivity(i);
				finish();
			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void irDatos(View view) {

		System.out.println("IR DATOS");
		guardarPreference();
		String valor1 = editText1.getText().toString();

		if (!validarFormatoNumero(valor1)) {
			Toast.makeText(getApplicationContext(),
					"El valor ingresado no es válido", Toast.LENGTH_LONG)
					.show();
			return;
		}

		Integer res = GeolocalizacionWService.existeUsuarioPorNumero(valor1);

		if (res.equals(Constantes.USUARIO_NO_EXISTE)) {
			Intent i = new Intent(this, IngresarDatosActivity.class);
			i.putExtra("numeroTelefono", valor1);
			startActivity(i);
		} else {
			guardarPreference();
			Intent i = new Intent(this, MapaActivity.class);
			i.putExtra("numeroTelefono", valor1);
			startActivity(i);
		}

	}

	public Boolean validarFormatoNumero(String numeroCel) {
		return SimpleValidate.validar(Constantes.FORMATO_TELEFONO, numeroCel);
	}

	public void guardarPreference() {
		SharedPreferences preferencias = getSharedPreferences("datos",
				Context.MODE_PRIVATE);
		Editor editor = preferencias.edit();
		editor.putString("nroCelular", editText1.getText().toString());
		editor.commit();
	}

}
