package com.vst.cmd.example4.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCMD {

	public static Boolean debug = false;
	
	public static void mensajesConsola(Object o) {
		if (debug) {
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) throws IOException {	
		System.out.println("Servidor cmd, ingrese los sigueinte datos ");
		Integer puerto = 6677, maximoConexiones = 10;
		String usuario = "daniel";
		debug = true;
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Puerto:");
//		puerto = scan.nextInt();
//		System.out.println("Cantidad Usuario:");
//		maximoConexiones = scan.nextInt();
//		System.out.println("usuario:");
//		usuario = scan.next();
//		System.out.println("DEBUG:");
//		debug = scan.nextBoolean();	
				
		try {			
			ServerSocket server = new ServerSocket(puerto,maximoConexiones);
			mensajesConsola("Estableciento puerto "+puerto + " cantidad de usuarios "+ maximoConexiones + " servicio iniciado por :" + usuario);
			mensajesConsola("Inicializado y esperando conexiones de usuarios" );
			while (true) {
				Socket s = server.accept();
				mensajesConsola("Usuario iniciado host:"+s.getInetAddress().getHostName() + " puerto:"+s.getPort() );
				mensajesConsola("Configurando conexion" );
				ConexionClienteCMD chat = new ConexionClienteCMD(s);
				Thread t = new Thread(chat);
				mensajesConsola("Configurando terminada" );
				t.start();
				mensajesConsola("Inicio de servicio cmd" );
			}			
		} catch (Exception e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}		
	}

}
