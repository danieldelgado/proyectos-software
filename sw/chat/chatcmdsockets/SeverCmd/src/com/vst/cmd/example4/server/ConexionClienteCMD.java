package com.vst.cmd.example4.server;

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
					ServidorCMD.mensajesConsola(hostClient+":"+puerto+" text:"+input);
//					out.println("cmd:\n"+input);
//					out.println("Mendaje reenviado: "+input);
					input = "Mesnaje reenviado:"+input;
//					byte[] bytes = input.getBytes();					
					out.println(input);
					out.flush();
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	 public ByteArrayOutputStream saveTo(  OutputStream os,String str ) throws IOException {
//	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	        DataOutputStream dos = new DataOutputStream( baos );
//	        try{
//	            dos.writeBytes(str);
//	        }finally {
//	            dos.close();
//	        }
//	        baos.writeTo( os );
//	        return baos;
//	    }
//	

}
