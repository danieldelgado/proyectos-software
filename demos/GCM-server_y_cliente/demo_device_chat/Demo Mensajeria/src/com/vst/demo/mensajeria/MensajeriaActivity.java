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

public class MensajeriaActivity extends Activity  {

	private Context context;
	private ProgressDialog pd;
//	static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
//		"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
//		"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
	
	List<Map<String, String>> planetsList = new ArrayList<Map<String,String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);
		context = this;
		validarDatosUsuario();
//		setListAdapter(new ArrayAdapter<String>(this, R.id.lst_Usuario,FRUITS));
//		 
//		ListView listView = getListView();
//		listView.setTextFilterEnabled(true);
// 
//		listView.setOnItemClickListener(new OnItemClickListener() {
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//			    // When clicked, show a toast with the TextView text
//			    Toast.makeText(getApplicationContext(),
//				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
//			}
//		});
		
		initList();
		 ListView lv = (ListView) findViewById(R.id.lst_Usuario);
		
		 SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList, android.R.layout.simple_list_item_1, new String[] {"planet"}, new int[] {android.R.id.text1});
		 lv.setAdapter(simpleAdpt);

	}
	
	 private void initList() {
		    // We populate the planets

		    planetsList.add(createPlanet("planet", "Mercury"));
		    planetsList.add(createPlanet("planet", "Venus"));
		    planetsList.add(createPlanet("planet", "Mars"));
		    planetsList.add(createPlanet("planet", "Jupiter"));
		    planetsList.add(createPlanet("planet", "Saturn"));
		    planetsList.add(createPlanet("planet", "Uranus"));
		    planetsList.add(createPlanet("planet", "Neptune"));

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
				// pd = new ProgressDialog(context);
				// pd.setTitle("Processing...");
				// pd.setMessage("Please wait.");
				// pd.setCancelable(false);
				// pd.setIndeterminate(true);
				// pd.show();
				pd = ProgressDialog.show(context, "", "Cargando...", true);
			}

			@Override
			protected Void doInBackground(Void... arg0) {
				try {
					// Do something...
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
