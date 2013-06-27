package com.vst.cmd.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ProcesoEnvio implements Runnable {
	private final ConexionServidorCMD main;
	private ObjectOutputStream salida;
	private String mensaje;
	private Socket conexion;

	public ProcesoEnvio(Socket conexion, final ConexionServidorCMD main) {
		this.conexion = conexion;
		this.main = main;

		main.campoTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				mensaje = event.getActionCommand();
				enviarDatos(mensaje);
				main.campoTexto.setText("");
			}
		});
	}

	private void enviarDatos(String mensaje) {
		try {
			ConexionServidorCMD.mensajesConsola("enviando mensaje :" + mensaje + " al host "+conexion.getInetAddress().getHostName()+ " por el puerto :"+conexion.getPort());
			salida.writeObject(" Envia "+conexion.getInetAddress().getHostName()+":"+conexion.getPort()+" - "+ main.getUsuario() +":" +  mensaje);
			salida.flush();
			main.mostrarMensaje(" Para "+conexion.getInetAddress().getHostName()+":"+conexion.getPort()+" - msj:" +  mensaje);
		}catch (IOException ioException) {
			main.mostrarMensaje("Error escribiendo Mensaje");
		}
	}

	public void terminarConexion() {
		try {
			salida.writeObject("Cliente>>> TERMINATE");
			salida.flush();
		}catch (IOException ioException) {
			main.mostrarMensaje("Error escribiendo Mensaje");
		}
	}
	
	public void mostrarMensaje(String mensaje) {
		main.areaTexto.append(mensaje);
	}

	public void run() {
		try {
			salida = new ObjectOutputStream(conexion.getOutputStream());
			salida.flush();
		} catch (SocketException ex) {
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (NullPointerException ex) {
		}
	}

}
