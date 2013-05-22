package com.demo.demogeolocalizacion;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	TextView messageTextView;
	private GoogleMap mMap;
	MarkerOptions marker1 = new MarkerOptions();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
		double latitude = 0; // latitude
	    double longitude = 0; // longitude
		
//		messageTextView=(TextView)findViewById(R.id.tv1);
		LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener milocListener = new MiLocationListener();
		milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				milocListener);
//		Location location = milocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//		if (location != null) {
//            latitude = location.getLatitude();
//            longitude = location.getLongitude();
//        }
		
//		crearMarcador(latitude, longitude);
		
	}
	
	
	public class MiLocationListener implements LocationListener {
		public void onLocationChanged(Location loc) {
			loc.getLatitude();
			loc.getLongitude();
			String coordenadas = "Mis coordenadas son: " + "Latitud = "
					+ loc.getLatitude() + "Longitud = " + loc.getLongitude();
//			Toast.makeText(getApplicationContext(), coordenadas,
//					Toast.LENGTH_LONG).show();
			System.out.println(coordenadas);
			crearMarcador(loc.getLatitude(), loc.getLongitude());
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
	
	public void crearMarcador(Double lat, Double longi ){
		mMap = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		mMap.addMarker(marker1
		        .position(new LatLng(lat, longi))
		        .title("Mongoloide " + lat + "Long" + longi));
		
		LatLngBounds bounds = new LatLngBounds.Builder()
        .include(new LatLng(lat,longi))
//        .include((new LatLng(52.3563, 4.8790)))
        .build();

        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 35));
	}
	
}
