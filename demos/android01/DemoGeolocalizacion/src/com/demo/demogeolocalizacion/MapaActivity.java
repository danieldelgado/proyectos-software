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
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaActivity extends android.support.v4.app.FragmentActivity {

	TextView messageTextView;
	private GoogleMap mMap;
	Marker marker1 = null;
	LocationManager milocManager;
	LocationListener milocListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);

		milocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		milocListener = new MiLocationListener();

		mMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		if (milocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
					0, 0, milocListener);
			Location loc = milocManager
					.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			crearMarcador(loc);
		} else if (milocManager
				.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			milocManager.requestLocationUpdates(
					LocationManager.NETWORK_PROVIDER, 0, 0, milocListener);
			Location loc = milocManager
					.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			crearMarcador(loc);
		} else {
			Toast.makeText(
					getApplicationContext(),
					"Debe activar el GPS o la utilizacion de redes inalambricas para continuar",
					Toast.LENGTH_LONG).show();
			finish();
		}

		mMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng point) {
				// TODO Auto-generated method stub
				mMap.addMarker(new MarkerOptions()
						.position(point)
						.title(point.toString())
						.icon(BitmapDescriptorFactory
								.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
			}
		});

	}

	public class MiLocationListener implements LocationListener {
		public void onLocationChanged(Location loc) {
			crearMarcador(loc);
		}

		public void onProviderDisabled(String provider) {
			if (provider.equalsIgnoreCase("GPS")) {
				if (milocManager
						.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
					milocManager.requestLocationUpdates(
							LocationManager.NETWORK_PROVIDER, 0, 0,
							milocListener);
				} else {
					Toast.makeText(
							getApplicationContext(),
							"Debe activar el GPS o la utilizacion de redes inalambricas para continuar",
							Toast.LENGTH_LONG).show();
					finish();
				}
			} else if (provider.equalsIgnoreCase("network")) {
				if (milocManager
						.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
					milocManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER, 0, 0, milocListener);
				} else {
					Toast.makeText(
							getApplicationContext(),
							"Debe activar el GPS o la utilizacion de redes inalambricas para continuar",
							Toast.LENGTH_LONG).show();
					finish();
				}
			}
		}

		public void onProviderEnabled(String provider) {
			messageTextView.setText(provider + "Activo");
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
	}

	public void crearMarcador(Location loc) {

		if (loc != null) {
			Double lat = loc.getLatitude();
			Double lng = loc.getLongitude();

			if (marker1 == null) {
				marker1 = mMap.addMarker(new MarkerOptions().position(
						new LatLng(lat, lng)).title(
						"Latitud: " + lat + " Long: " + lng));
				mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
						lat, lng), 17));

			} else {
				marker1.setPosition(new LatLng(lat, lng));
			}
		}

	}

}
