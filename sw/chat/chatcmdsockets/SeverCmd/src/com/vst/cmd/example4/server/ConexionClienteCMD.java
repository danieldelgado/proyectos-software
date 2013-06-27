package com.vst.cmd.example4.server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConexionClienteCMD implements Runnable {

	private Socket socket;
	private String hostClient;
	private int puerto;

	public ConexionClienteCMD(Socket s) {
		socket = s;
		hostClient = socket.getInetAddress().getHostName();
		puerto = socket.getPort();
	}

	@Override
	public void run() {
		try {
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			while (true) {
				if (in.hasNext()) {
					String input = in.nextLine();
					ServidorCMD.mensajesConsola(hostClient + ":" + puerto + " text:" + input);
					input = "Mensaje reenviado:" + input;
					out.println(input);
					out.flush();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
