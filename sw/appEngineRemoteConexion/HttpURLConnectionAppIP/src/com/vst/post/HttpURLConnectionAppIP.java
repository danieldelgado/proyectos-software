package com.vst.post;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class HttpURLConnectionAppIP {

	private static Logger _log = Logger.getLogger(HttpURLConnectionAppIP.class.getName());

	private void sendGet( String url ) {
		_log.info(" sendGet ");
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			_log.info(" responseCode: "+responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			_log.info(" response: "+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendPost( String url,  String comands ) {
		_log.info(" sendPost ");
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(comands);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			_log.info(" responseCode: "+responseCode);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			_log.info(" response: "+response.toString());
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		String url1 = "http://appsample010101.appspot.com/appsamplepost";
//		String url2 = "http://appsample010101.appspot.com/appsample";
//		String url1 = "http://127.0.0.1:8888/appsamplepost";
//		String url2 = "http://127.0.0.1:8888/appsample";
// 		String comandosExtrasQS = "CLEAR=true";
		_log.info("Iniciando HttpURL ... ");
		HttpURLConnectionAppIP http = new HttpURLConnectionAppIP();
		if (args != null && args.length == 3) {
			String urlPost = args[0];
			String urlGet = args[1];
			String comandos = args[2];
			_log.info("\n urlPost : "+urlPost + " comandos:"+comandos+"\n"+" urlGet : "+urlGet);
			_log.info("Connect ... ");
			while (true) {
				http.sendPost(urlPost, comandos);
				http.sendGet(urlGet);
				try {
					Thread.sleep(1000*60*30);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
		}else{
			_log.info("Requiere de parametros. Por ejemplo:"+
			"\nParama1 = http://appsample010101.appspot.com/appsamplepost\n"+	
			"Parama2 = http://appsample010101.appspot.com/appsample\n"	+
			"Parama3 = CLEAR=true\n");		
		}
	}

}