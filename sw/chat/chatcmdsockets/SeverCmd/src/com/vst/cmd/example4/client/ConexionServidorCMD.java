package com.vst.cmd.example4.client;

import java.io.IOException;
import java.net.Socket;

public class ConexionServidorCMD {

//	private final static int PORT = 6677;
//	private final static String HOST = "localhost";
	
	public static Boolean debug = false;
	
	public static void mensajesConsola(Object o) {
		if (debug) {
			System.out.println(o);
		}
	}
		
	public static void main(String[] args) throws IOException {
		System.out.println("Servidor cmd, ingrese los sigueinte datos");
		Integer puerto = 6677;
		String serverhost = "127.0.0.1", usuario = "usuario01";
		debug = true;
		// Scanner scan = new Scanner(System.in);
		// System.out.println("Servidor:");
		// serverhost = scan.next();
		// System.out.println("Puerto:");
		// puerto = scan.nextInt();
		// System.out.println("usuario:");
		// usuario = scan.next();
		// System.out.println("DEBUG:");
		// debug = scan.nextBoolean();
		try {
			mensajesConsola("Estableciento servidor:" +serverhost+ " puerto "+puerto +  " servicio iniciado por :" + usuario);
			mensajesConsola("Inicializado conexion" );
			Socket s = new Socket(serverhost, puerto);		
			mensajesConsola("Conexion establecida" );
			mensajesConsola("Configurando conexion... " );
			ConexionServidor client = new ConexionServidor(s);
			Thread t = new Thread(client);
			mensajesConsola("Configurando terminada" );
			t.start();
			mensajesConsola("Inicio de servicio cmd" );
		} catch (Exception noServer) {
			System.out.println("The server might not be up at this time.");
			System.out.println("Please try again later.");
		}
	}
}
