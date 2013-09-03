package com.vst.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.string;
import android.util.Log;

public class HttpUtilConexiones {

	

	// public static void register(String regId) {
	// // Log.i(TAG, "registering device (regId = " + regId + ")");
	// String serverUrl = Constantes.SERVER_URL + "/register";
	// Map<String, Object> params = new HashMap<String, Object>();
	// params.put("regId", regId);
	// long backoff = Constantes.BACKOFF_MILLI_SECONDS +
	// Constantes.RANDOM.nextInt(1000);
	// // Once GCM returns a registration id, we need to register it in the
	// // demo server. As the server might be down, we will retry it a couple
	// // times.
	// for (int i = 1; i <= Constantes.MAX_ATTEMPTS; i++) {
	// try {
	// post(serverUrl, params);
	//
	// return;
	// } catch (IOException e) {
	// // Here we are simplifying and retrying on any error; in a real
	// // application, it should retry only on unrecoverable errors
	// // (like HTTP error code 503).
	//
	// if (i == Constantes.MAX_ATTEMPTS) {
	// break;
	// }
	// try {
	//
	// Thread.sleep(backoff);
	// } catch (InterruptedException e1) {
	// Thread.currentThread().interrupt();
	// return;
	// }
	// // increase backoff exponentially
	// backoff *= 2;
	// }
	// }
	// }

	public static JSONObject getJSONFromUrl(String url) {
		InputStream is = null;
		JSONObject jObj = null;
		String json = "";
		// Making HTTP request
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}

		// try parse the string to a JSON object
		try {
			System.out.println("json:");
			System.out.println(json);
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		System.out.println("jObj:");
		System.out.println(jObj);
		// return JSON String
		return jObj;

	}

	public static JSONObject getJSONFromUrl(String url, Map<String, Object> params) {
		InputStream is = null;
		JSONObject jObj = null;
		String json = "";
		try {
			Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
			List<NameValuePair> pairs = new ArrayList<NameValuePair>();
			while (iterator.hasNext()) {
				Entry<String, Object> param = iterator.next();
				pairs.add(new BasicNameValuePair(param.getKey(), (String) param.getValue()));

			}
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(new UrlEncodedFormEntity(pairs));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}

		// try parse the string to a JSON object
		try {
			System.out.println("json:");
			System.out.println(json);
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		System.out.println("jObj:");
		System.out.println(jObj);
		// return JSON String
		return jObj;

	}

	public static void post(String endpoint, Map<String, Object> params) throws IOException {
		System.out.println("post!!!");
		System.out.println("endpoint:" + endpoint);
		System.out.println("params:" + params);
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
			int status = conn.getResponseCode();
			System.out.println("getResponseCode post status!!!:" + status);
			if (status != 200) {
				System.out.println("registro con exito");
				throw new IOException("Post failed with error code " + status);
			}
			InputStream is2 = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is2, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("sb:" + sb.toString());
			is2.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally post!!!");
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	public static JSONObject resppost(String endpoint, Map<String, Object> params) throws IOException {
		JSONObject obJson = null;
		System.out.println("post!!!");
		System.out.println("endpoint:" + endpoint);
		System.out.println("params:" + params);
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
			int status = conn.getResponseCode();
			System.out.println("getResponseCode post status!!!:" + status);
			if (status != 200) {
				System.out.println("registro con exito");
				throw new IOException("Post failed with error code " + status);
			}
			InputStream is2 = conn.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is2, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println("sb:" + sb.toString());

			System.out.println("json:");
			obJson = new JSONObject(sb.toString());
			System.out.println(obJson);

			is2.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally post!!!");
			if (conn != null) {
				conn.disconnect();
			}
		}
		return obJson;
	}

}
