package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Intent;
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void irDatos(View view) {
        Intent i = new Intent(this, IngresarDatosActivity.class );
        startActivity(i);
	} 
	
	public void irMapa(View view) {
        Intent i = new Intent(this, MapaActivity.class );
        startActivity(i);
	} 

}
