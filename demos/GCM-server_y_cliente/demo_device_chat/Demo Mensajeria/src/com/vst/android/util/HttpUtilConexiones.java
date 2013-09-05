package com.vst.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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

public class HttpUtilConexiones {

	private static InputStream is = null;
	private static JSONObject jObj = null;
	private static String json = null;
	private static URL url = null;
	private static DefaultHttpClient httpClient = null;
	private static HttpPost httpPost = null;
	private static HttpResponse httpResponse = null;
	private static HttpEntity httpEntity = null;
	private static BufferedReader reader = null;
	private static HttpURLConnection conn = null;
	private static OutputStream out = null;

	private HttpUtilConexiones() {
		throw new UnsupportedOperationException();
	}

	public static JSONObject getJSONFromUrl(String url) throws ClientProtocolException, IOException, JSONException {
		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(url);
		httpResponse = httpClient.execute(httpPost);
		httpEntity = httpResponse.getEntity();
		is = httpEntity.getContent();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		json = sb.toString();
		jObj = new JSONObject(json);
		clean();
		return jObj;
	}

	private static void clean() {
		is = null;
		url = null;
		json = null;
		httpClient = null;
		httpPost = null;
		httpResponse = null;
		httpEntity = null;
		reader = null;
		conn = null;
		out = null;
	}

	private static List<NameValuePair> obtenerParams(Map<String, Object> params) {
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		while (iterator.hasNext()) {
			Entry<String, Object> param = iterator.next();
			pairs.add(new BasicNameValuePair(param.getKey(), (String) param.getValue()));
		}
		return pairs;
	}
//	09-05 04:56:50.657: W/System.err(1061): android.os.NetworkOnMainThreadException

	public static JSONObject getJSONFromUrl(String url, Map<String, Object> params) throws ClientProtocolException, IOException, JSONException {
		List<NameValuePair> pairs = obtenerParams(params);
		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(pairs));
		httpResponse = httpClient.execute(httpPost);
		httpEntity = httpResponse.getEntity();
		is = httpEntity.getContent();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		json = sb.toString();
		jObj = new JSONObject(json);
		clean();
		return jObj;
	}

	private static String obtenerBoby(Map<String, Object> params) {
		StringBuilder bodyBuilder = new StringBuilder();
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> param = iterator.next();
			bodyBuilder.append(param.getKey()).append('=').append(param.getValue());
			if (iterator.hasNext()) {
				bodyBuilder.append('&');
			}
		}
		return bodyBuilder.toString();
	}

	private static byte[] obtenerBytes(String str) {
		return str.getBytes();
	}

	public static void post(String endpoint, Map<String, Object> params) throws IOException {
		url = new URL(endpoint);
		String body = obtenerBoby(params);
		byte[] bytes = obtenerBytes(body);
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setFixedLengthStreamingMode(bytes.length);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		// post the request
		out = conn.getOutputStream();
		out.write(bytes);
		out.close();
		// handle the response
		int status = conn.getResponseCode();
		if (status != 200) {
			System.out.println("registro con exito");
			throw new IOException("Post failed with error code " + status);
		}
		is = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		if (conn != null) {
			conn.disconnect();
		}
		clean();
	}

	public static JSONObject resppost(String endpoint, Map<String, Object> params) throws IOException, JSONException {
		url = new URL(endpoint);
		String body = obtenerBoby(params);
		byte[] bytes = body.getBytes();
		conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setFixedLengthStreamingMode(bytes.length);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		// post the request
		out = conn.getOutputStream();
		out.write(bytes);
		out.close();
		// handle the response
		int status = conn.getResponseCode();
		if (status != 200) {
			System.out.println("registro con exito");
			throw new IOException("Post failed with error code " + status);
		}
		is = conn.getInputStream();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		jObj = new JSONObject(sb.toString());
		if (conn != null) {
			conn.disconnect();
		}
		clean();
		return jObj;
	}

}
