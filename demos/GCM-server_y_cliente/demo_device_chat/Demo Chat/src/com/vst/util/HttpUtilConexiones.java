package com.vst.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtilConexiones {


//	public static void register(String regId) {
//		// Log.i(TAG, "registering device (regId = " + regId + ")");
//		String serverUrl = Constantes.SERVER_URL + "/register";
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("regId", regId);
//		long backoff = Constantes.BACKOFF_MILLI_SECONDS + Constantes.RANDOM.nextInt(1000);
//		// Once GCM returns a registration id, we need to register it in the
//		// demo server. As the server might be down, we will retry it a couple
//		// times.
//		for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
//			try {
//				post(serverUrl, params);
//
//				return;
//			} catch (IOException e) {
//				// Here we are simplifying and retrying on any error; in a real
//				// application, it should retry only on unrecoverable errors
//				// (like HTTP error code 503).
//
//				if (i == Constantes.MAX_ATTEMPTS) {
//					break;
//				}
//				try {
//
//					Thread.sleep(backoff);
//				} catch (InterruptedException e1) {
//					Thread.currentThread().interrupt();
//					return;
//				}
//				// increase backoff exponentially
//				backoff *= 2;
//			}
//		}
//	}
	
	public static void post(String endpoint, Map<String, Object> params) throws IOException {
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
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		// constructs the POST body using the parameters
		while (iterator.hasNext()) {
			Entry<String, Object> param = iterator.next();
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
			conn.setDoOutput(true);
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
