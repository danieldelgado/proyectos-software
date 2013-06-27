package com.vst.cmd.client;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesoRecibe implements Runnable {
	private final ConexionServidorCMD main;
	private String mensaje;
	private ObjectInputStream entrada;
	private Socket cliente;

	public ProcesoRecibe(Socket cliente, ConexionServidorCMD main) {
		this.cliente = cliente;
		this.main = main;
	}

	public void mostrarMensaje(String mensaje) {
		main.areaTexto.append(mensaje);
	}

	public void run() {
		try {
			entrada = new ObjectInputStream(cliente.getInputStream());
		} catch (IOException ex) {
			Logger.getLogger(ProcesoRecibe.class.getName()).log(Level.SEVERE, null, ex);
		}
		do {
			try {
				mensaje = (String) entrada.readObject();
				main.mostrarMensaje("Server>>> "+ mensaje );
			} catch (SocketException ex) {
			} catch (EOFException eofException) {
				main.mostrarMensaje("Fin de la conexion");
				break;
			} catch (IOException ex) {
				Logger.getLogger(ProcesoRecibe.class.getName()).log(Level.SEVERE, null, ex);
			} catch (ClassNotFoundException classNotFoundException) {
				main.mostrarMensaje("Objeto desconocido");
			}

		} while ( !(mensaje.indexOf("TERMINATE")>0) );

		try {
			entrada.close();
			cliente.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

		main.mostrarMensaje("Fin de la conexion");
		System.exit(0);
	}
	
}