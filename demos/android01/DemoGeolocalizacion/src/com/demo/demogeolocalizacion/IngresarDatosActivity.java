package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IngresarDatosActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	public void irMapa(View view) {
        Intent i = new Intent(this, MapaActivity.class );
        startActivity(i);
	} 
	
}
