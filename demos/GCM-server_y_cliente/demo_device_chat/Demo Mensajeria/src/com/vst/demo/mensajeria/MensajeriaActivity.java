package com.vst.demo.mensajeria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MensajeriaActivity extends Activity {

	private Context context;
	private ProgressDialog pd;

	List<Map<String, String>> planetsList = new ArrayList<Map<String, String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);
		context = this;
//		validarDatosUsuario();
		initList();
		ListView lv = (ListView) findViewById(R.id.lst_Usuario);
		SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList,
				android.R.layout.simple_list_item_1, new String[] { "planet" },
				new int[] { android.R.id.text1 });
		lv.setAdapter(simpleAdpt);

	}

	private void initList() {
		planetsList.add(createPlanet("planet", "Mercury"));
		planetsList.add(createPlanet("planet", "Venus"));
		planetsList.add(createPlanet("planet", "Mars"));
		planetsList.add(createPlanet("planet", "Jupiter"));
		planetsList.add(createPlanet("planet", "Saturn"));
		planetsList.add(createPlanet("planet", "Uranus"));
		planetsList.add(createPlanet("planet", "Neptune"));
		planetsList.add(createPlanet("planet", "Neptune1"));
		planetsList.add(createPlanet("planet", "Neptune2"));
		planetsList.add(createPlanet("planet", "Neptune3"));
		planetsList.add(createPlanet("planet", "Neptune4"));
		planetsList.add(createPlanet("planet", "Neptune5"));

	}

	private HashMap<String, String> createPlanet(String key, String name) {
		HashMap<String, String> planet = new HashMap<String, String>();
		planet.put(key, name);
		return planet;
	}

	private void validarDatosUsuario() {
		AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
			@Override
			protected void onPreExecute() {
				pd = ProgressDialog.show(context, "", "Cargando...", true);
			}

			@Override
			protected Void doInBackground(Void... arg0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				if (pd != null) {
					pd.dismiss();
				}
			}
		};
		task.execute((Void[]) null);
	}

	@Override
	protected void onDestroy() {
		if (pd != null) {
			pd.dismiss();
		}
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.mensajeria, menu);
		return true;
	}

}
