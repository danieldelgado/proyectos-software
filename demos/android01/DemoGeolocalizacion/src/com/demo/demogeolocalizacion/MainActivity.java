package com.demo.demogeolocalizacion;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		System.out.println("Entto");
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
			Toast.makeText(getApplicationContext(), coordenadas,
					Toast.LENGTH_LONG).show();
		}

		public void onProviderDisabled(String provider) {
			Toast.makeText(getApplicationContext(), "Gps Desactivado",
					Toast.LENGTH_SHORT).show();
		}

		public void onProviderEnabled(String provider) {
			Toast.makeText(getApplicationContext(), "Gps Activo",
					Toast.LENGTH_SHORT).show();
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

}
