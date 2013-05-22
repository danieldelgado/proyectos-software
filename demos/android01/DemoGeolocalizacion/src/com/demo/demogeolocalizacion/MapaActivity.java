package com.demo.demogeolocalizacion;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	TextView messageTextView;
	private GoogleMap mMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
		mMap = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		mMap.addMarker(new MarkerOptions()
		        .position(new LatLng(-12.1167, -77.05))
		        .title("mongoloide"));
		
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
