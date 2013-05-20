package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView messageTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("Entro");
		messageTextView=(TextView)findViewById(R.id.tv1);
		LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener milocListener = new MiLocationListener();
		milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				milocListener);
		

	}

	public class MiLocationListener implements LocationListener {
		public void onLocationChanged(Location loc) {
			loc.getLatitude();
			loc.getLongitude();
			String coordenadas = "Mis coordenadas son: " + "Latitud = "
					+ loc.getLatitude() + "Longitud = " + loc.getLongitude();
//			Toast.makeText(getApplicationContext(), coordenadas,
//					Toast.LENGTH_LONG).show();
			
			messageTextView.setText(coordenadas);
		}

		public void onProviderDisabled(String provider) {
			messageTextView.setText("Gps Desactivado");
		}

		public void onProviderEnabled(String provider) {
			messageTextView.setText("Gps Activo");
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void irMapa(View view) {
        Intent i = new Intent(this, MapaActivity.class );
        startActivity(i);
  } 

}
