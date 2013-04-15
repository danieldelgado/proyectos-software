package pe.com.sf.re.fi.analisis.gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CargaApp extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel messagePane = null;
	private JLabel lblMensaje = null;
	private String[] strCargando = { "Cargando Librerias", "Obteniendo Memoria" , "Terminando Carga" };

	public CargaApp(JFrame parent, String title) {
		super(parent, title, true);
		messagePane = new JPanel();
		lblMensaje = new JLabel("Cargando...");
		messagePane.add(lblMensaje);
		getContentPane().add(messagePane);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}

	public void terminarCarga() {
		setVisible(false);
		dispose();
	}

	public void cargar() {
//		System.out.println("cargando");
//		mostrarMensajesCarga();
		setVisible(true);
	}

	public void mostrarMensajesCarga() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("for");
					for (int i = 0; i < strCargando.length; i++) {
						lblMensaje.setText(strCargando[i]);
						Thread.sleep(150);
					}
				} catch (Exception e) {
				}
			}
		});
	}

}