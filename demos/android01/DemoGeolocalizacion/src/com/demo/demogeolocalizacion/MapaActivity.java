package com.demo.demogeolocalizacion;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	TextView messageTextView;
	private GoogleMap mMap;
	Marker marker1 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
//		messageTextView=(TextView)findViewById(R.id.tv1);
	    LocationManager milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		LocationListener milocListener = new MiLocationListener();
		milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				milocListener);
		mMap = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		
//		crearMarcador(latitude, longitude);
		mMap.setOnMapClickListener(new OnMapClickListener() {
             @Override
             public void onMapClick(LatLng point) {
                  // TODO Auto-generated method stub
            	 mMap.addMarker(new MarkerOptions().position(point).title(
                            point.toString()));
             }
        });
		
	}
	
	
	public class MiLocationListener implements LocationListener {
		public void onLocationChanged(Location loc) {
			loc.getLatitude();
			loc.getLongitude();
			String coordenadas = "Mis coordenadas son: " + " Latitud = "
					+ loc.getLatitude() + " Longitud = " + loc.getLongitude();
//			Toast.makeText(getApplicationContext(), coordenadas,
//					Toast.LENGTH_LONG).show();
			System.out.println(coordenadas);
			crearMarcador(loc.getLatitude(), loc.getLongitude());
			
		}

		public void onProviderDisabled(String provider) {
			Toast.makeText(getApplicationContext(), "Gps Desactivado. Se cerrara la aplicacion",
					Toast.LENGTH_LONG).show();
			finish();
//			messageTextView.setText("Gps Desactivado");
		}

		public void onProviderEnabled(String provider) {
			messageTextView.setText("Gps Activo");
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	}
	
	public void crearMarcador(Double lat, Double longi ){
		
		if(marker1 == null){
			
			marker1 = mMap.addMarker(new MarkerOptions()
			        .position(new LatLng(lat, longi))
			        .title("Mongoloide " + lat + "Long" + longi));
			mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 17));
			
		} else {
			
			marker1.setPosition(new LatLng(lat, longi));
			
		}
		
		
//		LatLngBounds bounds = new LatLngBounds.Builder()
//        .include(new LatLng(lat,longi))
////        .include((new LatLng(52.3563, 4.8790)))
//        .build();

//        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 15));
        
	}
	
}
