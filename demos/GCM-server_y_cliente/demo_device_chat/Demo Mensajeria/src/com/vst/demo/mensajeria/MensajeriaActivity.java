package com.vst.demo.mensajeria;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Menu;

public class MensajeriaActivity extends Activity {

	private Context context;
	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_activity_mensajeria_init);
		context = this;
		validarDatosUsuario();
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
