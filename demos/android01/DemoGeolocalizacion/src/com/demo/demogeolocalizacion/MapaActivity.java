package com.demo.demogeolocalizacion;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	TextView messageTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
//		messageTextView=(TextView)findViewById(R.id.tv1);
//		LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//		LocationListener milocListener = new MiLocationListener();
//		milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
//				milocListener);
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
	
}
