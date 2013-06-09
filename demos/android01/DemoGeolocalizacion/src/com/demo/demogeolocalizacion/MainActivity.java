package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.demo.demogeolocalizacion.util.Constantes;
import com.demo.demogeolocalizacion.ws.client.GeolocalizacionWService;

public class MainActivity extends Activity {

	EditText editText1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText)findViewById(R.id.et1);
		System.out.println("Prueba 10");
		
		
//		GeolocalizacionWService geoWs = new GeolocalizacionWService();
//		System.out.println("123 " + GeolocalizacionWService.existeUsuarioPorNumero("987456123"));
//		System.out.println("123 " + GeolocalizacionWService.registrarUsuarioPorTelefono("Danielle", "mongolo", "1990-12-06T09:47:46.8942117-04:00", "985214741"));
//		System.out.println("123 " + GeolocalizacionWService.registrarPuntoGeolocalizacion(true, "987456123", "-12.67556", "-77.0345901"));
//		System.out.println("123 " + GeolocalizacionWService.registrarPuntoGeolocalizacion(false, "987456123", "-12.675561", "-77.03459011"));
//		System.out.println("123 " + GeolocalizacionWService.registrarPuntoGeolocalizacion(false, "987456123", "-12.675562", "-77.03459012"));
//		System.out.println("123 " + GeolocalizacionWService.registrarPuntoGeolocalizacion(false, "987456123", "-12.675563", "-77.03459013"));
//		System.out.println("Prueba 11");
		
		SharedPreferences prefe = getSharedPreferences("datos",Context.MODE_PRIVATE);
		editText1.setText(prefe.getString("nroCelular",""));
		if(!prefe.getString("nroCelular","").equals("")){
			Integer res = GeolocalizacionWService.existeUsuarioPorNumero(prefe.getString("nroCelular",""));
			if(res.equals(Constantes.USUARIO_NO_EXISTE)){
				Intent i = new Intent(this, IngresarDatosActivity.class );
		        i.putExtra("numeroTelefono", prefe.getString("nroCelular",""));
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
		Integer res = GeolocalizacionWService.existeUsuarioPorNumero(valor1);
		
		if(res.equals(Constantes.USUARIO_NO_EXISTE)){
			Intent i = new Intent(this, IngresarDatosActivity.class );
	        i.putExtra("numeroTelefono", valor1);
	        startActivity(i);
		} else {
			guardarPreference();
	        Intent i = new Intent(this, MapaActivity.class );
	        i.putExtra("numeroTelefono", valor1);
	        startActivity(i);
		}
		
        
	} 
	
//	public void irIngresoDatos(View view) {
//		guardarPreference();
//        Intent i = new Intent(this, IngresarDatosActivity.class );
//        i.putExtra("numeroTelefono", valor1);
//        startActivity(i);
//	}
//	
//	public void irMapa(View view) {
//		guardarPreference();
//        Intent i = new Intent(this, MapaActivity.class );
//        startActivity(i);
//	} 
	
	public void guardarPreference(){
		 SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
	        Editor editor=preferencias.edit();
	        editor.putString("nroCelular", editText1.getText().toString());
	        editor.commit();
	}

}
