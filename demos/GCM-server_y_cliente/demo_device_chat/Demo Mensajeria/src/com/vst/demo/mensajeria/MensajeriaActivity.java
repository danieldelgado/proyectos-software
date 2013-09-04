package com.vst.demo.mensajeria;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.vst.android.adapter.CustomListViewAdapter;
import com.vst.android.beans.RowItem;

public class MensajeriaActivity extends Activity implements OnItemClickListener {

	// private Context context;
	// private ProgressDialog pd;

	public static final String[] titles = new String[] { "Strawberry", "Banana", "Orange", "Mixed" };

	public static final String[] descriptions = new String[] { "It is an aggregate accessory fruit", "It is the largest herbaceous flowering plant","Citrus Fruit", "Mixed Fruits" };

	public static final Integer[] images = { R.drawable.android_logo, R.drawable.blackberry_logo, R.drawable.ios_logo, R.drawable.windowsmobile_logo };

	ListView listView;
	List<RowItem> rowItems;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
			rowItems.add(item);
		}
		listView = (ListView) findViewById(R.id.listview);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Toast toast = Toast.makeText(getApplicationContext(), "Item " + (position + 1) + ": " + rowItems.get(position), Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

	// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	//
	// }

	// private View viewContainer;

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.layout_activity_mensajeria_init);
	// ListView l = (ListView) findViewById(R.id.listview);
	// String[] values = new String[] { "Ubuntu", "Android", "iPhone",
	// "Windows", "Ubuntu", "Android", "iPhone", "Windows" };
	// ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	// android.R.layout.simple_list_item_1, values);
	// viewContainer = findViewById(R.id.undobar);
	// l.setAdapter(adapter);
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.mensajeria, menu);
	// return true;
	// }

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// // showUndo(viewContainer);
	// return true;
	// }

	// public void onClick(View view) {
	// Toast.makeText(this, "Deletion undone", Toast.LENGTH_LONG).show();
	// // viewContainer.setVisibility(View.GONE);
	// }

	// @SuppressLint("NewApi")
	// public static void showUndo(final View viewContainer) {
	// viewContainer.setVisibility(View.VISIBLE);
	// viewContainer.setAlpha(1);
	// // viewContainer.animate().alpha(0.4f);
	// viewContainer.animate().alpha(0.4f).setDuration(5000).withEndAction(new
	// Runnable() {
	//
	// @Override
	// public void run() {
	// viewContainer.setVisibility(View.GONE);
	// }
	// });
	//
	// }

	// List<Map<String, String>> planetsList = new ArrayList<Map<String,
	// String>>();

	// @Override
	// protected void onCreate(Bundle savedInstanceState) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.layout_activity_mensajeria_init);
	// context = this;
	// validarDatosUsuario();
	// initList();
	// ListView lv = (ListView) findViewById(R.id.lst_Usuario);
	// SimpleAdapter simpleAdpt = new SimpleAdapter(this, planetsList,
	// android.R.layout.simple_list_item_1, new String[] { "planet" },
	// new int[] { android.R.id.text1 });
	// lv.setAdapter(simpleAdpt);
	// TextView e = new TextView(this);
	// e.setText("data");
	// lv.addView(e);

	// }

	// private void initList() {
	// planetsList.add(createPlanet("planet", "Mercury"));
	// planetsList.add(createPlanet("planet", "Venus"));
	// planetsList.add(createPlanet("planet", "Mars"));
	// planetsList.add(createPlanet("planet", "Jupiter"));
	// planetsList.add(createPlanet("planet", "Saturn"));
	// planetsList.add(createPlanet("planet", "Uranus"));
	// planetsList.add(createPlanet("planet", "Neptune"));
	// planetsList.add(createPlanet("planet", "Neptune1"));
	// planetsList.add(createPlanet("planet", "Neptune2"));
	// planetsList.add(createPlanet("planet", "Neptune3"));
	// planetsList.add(createPlanet("planet", "Neptune4"));
	// planetsList.add(createPlanet("planet", "Neptune5"));
	//
	// }

//	private HashMap<String, String> createPlanet(String key, String name) {
//		HashMap<String, String> planet = new HashMap<String, String>();
//		planet.put(key, name);
//		return planet;
//	}

//	private void validarDatosUsuario() {
//		AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
//			@Override
//			protected void onPreExecute() {
//				pd = ProgressDialog.show(context, "", "Cargando...", true);
//			}
//
//			@Override
//			protected Void doInBackground(Void... arg0) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				return null;
//			}
//
//			@Override
//			protected void onPostExecute(Void result) {
//				if (pd != null) {
//					pd.dismiss();
//				}
//			}
//		};
//		task.execute((Void[]) null);
//	}

	// @Override
	// protected void onDestroy() {
	// if (pd != null) {
	// pd.dismiss();
	// }
	// super.onDestroy();
	// }

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getMenuInflater().inflate(R.menu.mensajeria, menu);
	// return true;
	// }

}
