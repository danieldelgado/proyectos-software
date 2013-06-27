package com.vst.cmd.servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class ServidorCMD extends JFrame {
	public JTextField campoTexto;
	public JTextArea areaTexto;
	private static ServerSocket servidor;
	private static Socket conexion;
	static boolean debug = false;
	
	public ServidorCMD( boolean d ) {
		super("Servidor CMD consola");
		mensajesConsola("Creando interfaz ... ");
		debug = d;
		campoTexto = new JTextField();
		campoTexto.setEditable(false);
		add(campoTexto, BorderLayout.NORTH);
		areaTexto = new JTextArea();
		areaTexto.setEditable(false);
		add(new JScrollPane(areaTexto), BorderLayout.CENTER);
		areaTexto.setBackground(Color.orange);
		areaTexto.setForeground(Color.BLACK);
		campoTexto.setForeground(Color.BLACK);
		JMenu menuArchivo = new JMenu("Archivo");
		JMenuItem salir = new JMenuItem("Salir");
		menuArchivo.add(salir);
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(menuArchivo);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setSize(300, 320);
		setVisible(true);
	}

	public void mostrarMensaje(String mensaje) {
		areaTexto.append(mensaje + "\n");
		mensajesConsola(mensaje);
	}

	public void habilitarTexto(boolean editable) {
		campoTexto.setEditable(editable);
	}

	public static void mensajesConsola(Object o) {
		if (debug) {
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Servidor cmd, ingrese los sigueinte datos");
		Integer puerto = 123, maximoConexiones = 10;
		String usuario = "daniel";
		Boolean debug = true;
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Puerto:");
//		puerto = scan.nextInt();
//		System.out.println("Cantidad Usuario:");
//		maximoConexiones = scan.nextInt();
//		System.out.println("usuario:");
//		usuario = scan.next();
//		System.out.println("DEBUG:");
//		debug = scan.nextBoolean();		
		ServidorCMD main = new ServidorCMD(debug);
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExecutorService executor = Executors.newCachedThreadPool();
		try {
			main.mostrarMensaje("Estableciento puerto "+puerto + " cantidad de usuarios "+ maximoConexiones + " servicio iniciado por :" + usuario);
			servidor = new ServerSocket(puerto, maximoConexiones);
			main.mostrarMensaje("Esperando Cliente ...");
			while (true) {
				try {
					conexion = servidor.accept();
					main.mostrarMensaje("Conectado a : " + conexion.getInetAddress().getHostName());
					main.habilitarTexto(true);
					executor.execute( new ProcesoRecibe(conexion, main) );
					executor.execute( new ProcesoEnvio(conexion, main) );
				} catch (IOException ex) {
					Logger.getLogger(ServidorCMD.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(ServidorCMD.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
		}
		executor.shutdown();
	}
}
