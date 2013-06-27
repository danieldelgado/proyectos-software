package com.vst.cmd.servidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;

public class ProcesoEnvio implements Runnable {
	private final ServidorCMD main;
	private ObjectOutputStream salida;
	private String mensaje;
	private Socket conexion;

	public ProcesoEnvio(Socket conexion, final ServidorCMD main) {
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
			ServidorCMD.mensajesConsola("enviando mensaje :" + mensaje + " al host "+conexion.getInetAddress().getHostName()+ " por el puerto :"+conexion.getPort());
			salida.writeObject(" Para "+conexion.getInetAddress().getHostName()+":"+conexion.getPort()+" - msj:" +  mensaje);
			salida.flush();
			main.mostrarMensaje(" Para "+conexion.getInetAddress().getHostName()+":"+conexion.getPort()+" - msj:" +  mensaje);
		}catch (IOException ioException) {
			main.mostrarMensaje("Error escribiendo Mensaje");
		}
	}
	
	public void terminarConexion() {
		try {
			salida.writeObject("SERVIDOR>>> TERMINATE");
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
