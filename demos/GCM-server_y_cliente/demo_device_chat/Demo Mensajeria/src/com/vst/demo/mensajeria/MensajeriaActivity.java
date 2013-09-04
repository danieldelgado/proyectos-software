package com.vst.demo.mensajeria;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.vst.android.adapter.CustomListViewAdapter;
import com.vst.android.beans.RowItem;

public class MensajeriaActivity extends Activity implements OnItemClickListener {

	 private Context context;
	 private ProgressDialog pd;

	public static final String[] titles = new String[] { "Strawberry", "Banana", "Orange", "Mixed" };

	public static final String[] descriptions = new String[] { "It is an aggregate accessory fruit", "It is the largest herbaceous flowering plant","Citrus Fruit", "Mixed Fruits" };

	public static final Integer[] images = { R.drawable.android_logo, R.drawable.blackberry_logo, R.drawable.ios_logo, R.drawable.windowsmobile_logo };

	ListView listView;
	List<RowItem> rowItems;

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
