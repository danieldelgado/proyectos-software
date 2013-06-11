package com.demo.demogeolocalizacion;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.demogeolocalizacion.util.Constantes;
import com.demo.demogeolocalizacion.util.SimpleValidate;
import com.demo.demogeolocalizacion.ws.client.GeolocalizacionWService;

public class IngresarDatosActivity extends Activity {

	EditText nombres;
	EditText apellidos;
	EditText fechaNacimiento;
	String numCelular;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ingresardatos);

		Bundle bundle = getIntent().getExtras();
		numCelular = bundle.getString("numeroTelefono");

		nombres = (EditText) findViewById(R.id.et1);
		apellidos = (EditText) findViewById(R.id.et2);
		fechaNacimiento = (EditText) findViewById(R.id.et3);

	}

	public void irMapa(View view) {

		String nombresT = nombres.getText().toString();
		String apellidosT = apellidos.getText().toString();
		String fechaNacimientoT = fechaNacimiento.getText().toString();
		Boolean flagError = false;

		String result = GeolocalizacionWService.registrarUsuarioPorTelefono(
				nombresT, apellidosT, fechaNacimientoT
						+ "T09:47:46.8942117-04:00", numCelular);

		try {
			JSONArray jsonArray = new JSONArray(result);
			JSONObject jsonObject = jsonArray.getJSONObject(0);
			String erroresT = "";

			if (jsonObject.getString("registro").equals(
					String.valueOf(Constantes.NO_CUMPLE_CON_FORMATO))) {
				flagError = true;
				String errores = jsonObject.getString("errores");

				if (errores.lastIndexOf("nombres") > 0) {
					erroresT += "El nombre ingresado es invalido.\n";
				}
				if (errores.lastIndexOf("apellidos") > 0) {
					erroresT += "El apellido ingresado es invalido.\n";
				}
			}

			if (!SimpleValidate.validarFecha(
					Constantes.FORMATO_FECHA_DD_MM_YYYY, fechaNacimientoT)) {
				flagError = true;
				erroresT += "La fecha no tiene formato correcto.";
			}
			if (flagError) {
				Toast.makeText(getApplicationContext(), erroresT,
						Toast.LENGTH_LONG).show();
			} else {
				Intent i = new Intent(this, MapaActivity.class);
				i.putExtra("numeroTelefono", numCelular);
				startActivity(i);
			}

			System.out.println("RESULT: " + result + " er:"
					+ jsonObject.getString("registro"));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
