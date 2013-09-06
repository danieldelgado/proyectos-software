package com.vst.android.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import android.util.Log;

/**
 * HttpUtilConexiones clase que cuanta con las conexiones al servidor e envio de parametros
 * @author ddelgado
 *
 */
public class HttpUtilConexiones {

	private static InputStream is ;
	private static JSONObject jObj ;
	private static String json ;
//	private static String strToString = null;
//	private static URL url = null;
	private static DefaultHttpClient httpClient ;
	private static HttpPost httpPost ;
	private static HttpResponse httpResponse ;
	private static HttpEntity httpEntity ;
	private static BufferedReader reader ;
	private static StringBuilder sb ;
	private static String line ;
//	private static HttpURLConnection conn = null;
//	private static OutputStream out = null;

	//no puede crear el objeto HttpUtilConexiones
	private HttpUtilConexiones() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retorna un objeto JSONObject a la url servidor
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONObject getJSONFromUrl(String url) throws ClientProtocolException, IOException, JSONException {
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl url:"+url);
		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(url);
		httpResponse = httpClient.execute(httpPost);
		httpEntity = httpResponse.getEntity();
		is = httpEntity.getContent();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		sb = new StringBuilder();
		line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		json = sb.toString();
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl transformando a objeto ==> json:"+json);
		jObj = new JSONObject(json);
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl jObj:"+jObj);
		clean();
		return jObj;
	}

	// asigna null a todos las variables para liberar memoria
	private static void clean() {
		Log.v(HttpUtilConexiones.class.getName(), "clean");
		is = null;
//		url = null;
		json = null;
		httpClient = null;
		httpPost = null;
		httpResponse = null;
		httpEntity = null;
		reader = null;
//		conn = null;
//		out = null;
		sb = null;
		line = null;
	}
	//Metodo que convierte un Map a un List<NameValuePair> los parametros enviados al servidor
	private static List<NameValuePair> obtenerParams(Map<String, Object> params) {
		Log.v(HttpUtilConexiones.class.getName(), "obtenerParams : " + params);
		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		while (iterator.hasNext()) {
			Entry<String, Object> param = iterator.next();
			pairs.add(new BasicNameValuePair(param.getKey(), (String) param.getValue()));
		}
		return pairs;
	}

	/**
	 * Retorna un objeto JSONObject a la url servidor conb los parametros
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONObject getJSONFromUrl(String url, Map<String, Object> params) throws ClientProtocolException, IOException, JSONException {
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl url:"+url+" params:"+params);
		List<NameValuePair> pairs = obtenerParams(params);
		httpClient = new DefaultHttpClient();
		httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(pairs));
		httpResponse = httpClient.execute(httpPost);
		httpEntity = httpResponse.getEntity();
		is = httpEntity.getContent();
		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
		sb = new StringBuilder();
		line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		json = sb.toString();
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl transformando a objeto ==> json:"+json);
		jObj = new JSONObject(json);
		Log.v(HttpUtilConexiones.class.getName(), "getJSONFromUrl jObj:"+jObj);
		clean();
		return jObj;
	}

//	private static String obtenerBoby(Map<String, Object> params) {
//		Log.v(HttpUtilConexiones.class.getName(), "obtenerBoby params:"+params);
//		StringBuilder bodyBuilder = new StringBuilder();
//		Iterator<Entry<String, Object>> iterator = params.entrySet().iterator();
//		while (iterator.hasNext()) {
//			Entry<String, Object> param = iterator.next();
//			bodyBuilder.append(param.getKey()).append('=').append(param.getValue());
//			if (iterator.hasNext()) {
//				bodyBuilder.append('&');
//			}
//		}
//		strToString = bodyBuilder.toString();
//		Log.v(HttpUtilConexiones.class.getName(), "obtenerBoby strToString:"+strToString);
//		return strToString;
//	}

//	private static byte[] obtenerBytes(String str) {
//		return str.getBytes();
//	}

//	public static void post(String endpoint, Map<String, Object> params) throws IOException {
//		Log.v(HttpUtilConexiones.class.getName(), "post endpoint:"+endpoint+ " params:"+params);
//		url = new URL(endpoint);
//		String body = obtenerBoby(params);
//		byte[] bytes = obtenerBytes(body);
//		conn = (HttpURLConnection) url.openConnection();
//		conn.setDoOutput(true);
//		conn.setUseCaches(false);
//		conn.setFixedLengthStreamingMode(bytes.length);
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		// post the request
//		out = conn.getOutputStream();
//		out.write(bytes);
//		out.close();
//		// handle the response
//		int status = conn.getResponseCode();
//		if (status != 200) {
//			System.out.println("registro con exito");
//			throw new IOException("Post failed with error code " + status);
//		}
//		Log.v(HttpUtilConexiones.class.getName(), "post exito:");
//		is = conn.getInputStream();
//		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		while ((line = reader.readLine()) != null) {
//			sb.append(line + "\n");
//		}
//		is.close();
//		if (conn != null) {
//			conn.disconnect();
//		}
//		clean();
//	}

//	public static JSONObject resppost(String endpoint, Map<String, Object> params) throws IOException, JSONException {
//		Log.v(HttpUtilConexiones.class.getName(), "resppost endpoint:"+endpoint+" params:"+params);
//		url = new URL(endpoint);
//		String body = obtenerBoby(params);
//		byte[] bytes = body.getBytes();
//		conn = (HttpURLConnection) url.openConnection();
//		conn.setDoOutput(true);
//		conn.setUseCaches(false);
//		conn.setFixedLengthStreamingMode(bytes.length);
//		conn.setRequestMethod("POST");
//		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
//		// post the request
//		out = conn.getOutputStream();
//		out.write(bytes);
//		out.close();
//		// handle the response
//		int status = conn.getResponseCode();
//		if (status != 200) {
////			System.out.println("registro con exito");
//			throw new IOException("Post failed with error code " + status);
//		}
//		is = conn.getInputStream();
//		reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
//		StringBuilder sb = new StringBuilder();
//		String line = null;
//		while ((line = reader.readLine()) != null) {
//			sb.append(line + "\n");
//		}
//		is.close();
//		Log.v(HttpUtilConexiones.class.getName(), "resppost transformando a objeto ==> json:"+json);
//		jObj = new JSONObject(json);
//		Log.v(HttpUtilConexiones.class.getName(), "resppost jObj:"+jObj);
//		if (conn != null) {
//			conn.disconnect();
//		}
//		clean();
//		return jObj;
//	}

}
