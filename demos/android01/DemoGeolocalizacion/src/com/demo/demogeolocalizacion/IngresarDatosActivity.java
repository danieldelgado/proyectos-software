package com.demo.demogeolocalizacion;

import com.demo.demogeolocalizacion.ws.client.GeolocalizacionWService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
		
		nombres = (EditText)findViewById(R.id.et1);
		apellidos = (EditText)findViewById(R.id.et2);
		fechaNacimiento = (EditText)findViewById(R.id.et3);
		
	}

	public void irMapa(View view) {
        Intent i = new Intent(this, MapaActivity.class );
        i.putExtra("numeroTelefono", numCelular);
        startActivity(i);
        String nombresT = nombres.getText().toString();
        String apellidosT = apellidos.getText().toString();
        String fechaNacimientoT = fechaNacimiento.getText().toString();
		
		GeolocalizacionWService.registrarUsuarioPorTelefono(nombresT, apellidosT, fechaNacimientoT + "T09:47:46.8942117-04:00", numCelular);
        
	} 
	
}
