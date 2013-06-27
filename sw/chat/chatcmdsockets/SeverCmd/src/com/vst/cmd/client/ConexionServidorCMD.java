package com.vst.cmd.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
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
public class ConexionServidorCMD extends JFrame {
	public JTextField campoTexto;
	public JTextArea areaTexto;
	private static Socket cliente;
	static boolean debug = false;
	private String usuario = null;
	public static ConexionServidorCMD main;
	static ProcesoRecibe procesoRecibe;
	static ProcesoEnvio procesoEnvio;
	public ConexionServidorCMD(String usuario, boolean d) {
		super("Cliente CMD consola :" + usuario);
		mensajesConsola("Creando interfaz ... ");
		debug = d;
		this.usuario = usuario;
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
				procesoEnvio.terminarConexion();
				System.exit(0);
			}
		});
		
		procesoRecibe = new ProcesoRecibe(cliente, this);
		procesoEnvio = new ProcesoEnvio(cliente, this);
		
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

	public String getUsuario() {
		return usuario;
	}

	public static void main(String[] args) {
		System.out.println("Servidor cmd, ingrese los sigueinte datos");
		Integer puerto = 123;
		String serverhost = "127.0.0.1", usuario = "usuario01";
		Boolean debug = true;
		// Scanner scan = new Scanner(System.in);
		// System.out.println("Servidor:");
		// serverhost = scan.next();
		// System.out.println("Puerto:");
		// puerto = scan.nextInt();
		// System.out.println("usuario:");
		// usuario = scan.next();
		// System.out.println("DEBUG:");
		// debug = scan.nextBoolean();
		ConexionServidorCMD main = new ConexionServidorCMD(usuario, debug);
		main.setLocationRelativeTo(null);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ExecutorService executor = Executors.newCachedThreadPool();

		try {
			main.mostrarMensaje("Estableciento conexion serverhost " + serverhost + " puerto " + puerto + " usuario :" + usuario);
			main.mostrarMensaje("Buscando Servidor ...");
			cliente = new Socket(InetAddress.getByName(serverhost), puerto);
			main.mostrarMensaje("Conectado a :" + cliente.getInetAddress().getHostName());

			main.habilitarTexto(true);

			executor.execute(procesoRecibe);
			executor.execute(procesoEnvio);

		} catch (IOException ex) {
			Logger.getLogger(ConexionServidorCMD.class.getName()).log(Level.SEVERE, null, ex);
		} finally {

		}
		executor.shutdown();
	}
}
