package com.vst.demochat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Registro_Usuario extends Activity {

	private Button btnregistrarUsuario = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro__usuario);
		btnregistrarUsuario = (Button) findViewById(R.id.btn_regsitrar_usuario);
		btnregistrarUsuario.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				register("24132432432");
				
				Intent returnIntent = new Intent();
				returnIntent.putExtra(Constantes.KEY_USUARIO_REGISTRADO, Constantes.REGISTRO_EXITOSO_USUARIO);
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.registro__usuario, menu);
		return true;
	}

	public static void register(String regId) {
		// Log.i(TAG, "registering device (regId = " + regId + ")");
		String serverUrl = Constantes.SERVER_URL + "/register";
		Map<String, String> params = new HashMap<String, String>();
		params.put("regId", regId);
		long backoff = Constantes.BACKOFF_MILLI_SECONDS + Constantes.RANDOM.nextInt(1000);
		// Once GCM returns a registration id, we need to register it in the
		// demo server. As the server might be down, we will retry it a couple
		// times.
		for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
			try {
				post(serverUrl, params);

				return;
			} catch (IOException e) {
				// Here we are simplifying and retrying on any error; in a real
				// application, it should retry only on unrecoverable errors
				// (like HTTP error code 503).

				if (i == Constantes.MAX_ATTEMPTS) {
					break;
				}
				try {

					Thread.sleep(backoff);
				} catch (InterruptedException e1) {
					Thread.currentThread().interrupt();
					return;
				}
				// increase backoff exponentially
				backoff *= 2;
			}
		}
	}

	private static void post(String endpoint, Map<String, String> params) throws IOException {
		System.out.println("post!!!");
		System.out.println("endpoint:"+endpoint);
		System.out.println("params:"+params);
		URL url;
		try {
			url = new URL(endpoint);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("invalid url: " + endpoint);
		}
		StringBuilder bodyBuilder = new StringBuilder();
		Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
		// constructs the POST body using the parameters
		while (iterator.hasNext()) {
			Entry<String, String> param = iterator.next();
			bodyBuilder.append(param.getKey()).append('=').append(param.getValue());
			if (iterator.hasNext()) {
				bodyBuilder.append('&');
			}
		}
		String body = bodyBuilder.toString();
		// Log.v(TAG, "Posting '" + body + "' to " + url);
		byte[] bytes = body.getBytes();
		HttpURLConnection conn = null;
		try {
			System.out.println("openConnection post!!!");
			conn = (HttpURLConnection) url.openConnection();
//			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setFixedLengthStreamingMode(bytes.length);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			// post the request
			OutputStream out = conn.getOutputStream();
			out.write(bytes);
			out.close();
			// handle the response
			System.out.println("getResponseCode post!!!");
			int status = conn.getResponseCode();
			if (status != 200) {
				System.out.println("registro con exito");
				throw new IOException("Post failed with error code " + status);
			}		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally post!!!");
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
	

}
