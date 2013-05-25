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

public class MainActivity extends Activity {

	EditText editText1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText1 = (EditText)findViewById(R.id.et1);
		
		SharedPreferences prefe = getSharedPreferences("datos",Context.MODE_PRIVATE);
		editText1.setText(prefe.getString("nroCelular",""));
		if(!prefe.getString("nroCelular","").equals("")){
			Intent i = new Intent(this, IngresarDatosActivity.class );
	        startActivity(i);
	        finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void irDatos(View view) {
		guardarPreference();
        Intent i = new Intent(this, IngresarDatosActivity.class );
        startActivity(i);
	} 
	
	public void irMapa(View view) {
		guardarPreference();
        Intent i = new Intent(this, MapaActivity.class );
        startActivity(i);
	} 
	
	public void guardarPreference(){
		 SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
	        Editor editor=preferencias.edit();
	        editor.putString("nroCelular", editText1.getText().toString());
	        editor.commit();
	}

}
