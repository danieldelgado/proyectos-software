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

	private Context context = this;
	private ProgressDialog pd;

	public static final String[] titles = new String[] { "Strawberry", "Banana", "Orange", "Mixed" };

	public static final Integer[] images = { R.drawable.android_logo, R.drawable.android_logo, R.drawable.android_logo, R.drawable.android_logo };

	ListView listView;
	List<RowItem> rowItems;
	CustomListViewAdapter adapter;
	RowItem item;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);
		
		validarDatosUsuario();
		
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
				rowItems = new ArrayList<RowItem>();
				for (int i = 0; i < titles.length; i++) {
					item = new RowItem(i, titles[i], null);
					rowItems.add(item);
				}
				listView = (ListView) findViewById(R.id.listview);
				adapter = new CustomListViewAdapter(context, R.layout.list_item, rowItems);
				listView.setAdapter(adapter);
				listView.setOnItemClickListener((OnItemClickListener) context);
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
