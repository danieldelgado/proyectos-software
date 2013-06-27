package com.vst.cmd.example4.client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ConexionServidor implements Runnable {

	private Socket socket;
	private String hostClient;
	private int puerto;
	
	public ConexionServidor(Socket s) {
		socket = s;
		hostClient = socket.getInetAddress().getHostName();
		puerto = socket.getPort();
	}

	@Override
	public void run(){
		try
		{
			Scanner chat = new Scanner(System.in);
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			ConexionServidorCMD.mensajesConsola("Conexion establecida a:"+hostClient+":"+puerto);
			while (true){						
//				String input = chat.nextLine();	
//				out.println(input);			
				String input = chat.nextLine();
				out.println(input);				
				out.flush();				
				if(in.hasNext()){										
					System.out.println("in.nextLine():"+in.nextLine());
					ConexionServidorCMD.mensajesConsola(in.nextLine());
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		} 
	}

}
