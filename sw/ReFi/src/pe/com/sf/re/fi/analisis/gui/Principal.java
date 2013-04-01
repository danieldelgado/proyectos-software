package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXFrame;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import pe.com.sf.re.fi.memory.GuardarMemoryApp;
import pe.com.sf.re.fi.memory.LeerMemoryApp;
import pe.com.sf.re.fi.memory.MemoryApp;
import pe.com.sf.re.fi.util.Propes;

public class Principal extends JXFrame implements Serializable, WindowListener, ComponentListener {

	private static final long serialVersionUID = -4550679687084521316L;

	public int ancho_pantalla;
	public int alto_pantalla;

	public PanelNorte panNorte = null;
	public PanelCentral panCentral = null;
	public MemoryApp memoryApp = LeerMemoryApp.leerMemoryApp();

	@SuppressWarnings("deprecation")
	public Principal(String title) {
		super(title);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
		this.addComponentListener(this);
		if (memoryApp != null) {
			ancho_pantalla = memoryApp.getAnchoPantalla();
			alto_pantalla = memoryApp.getAltoPantalla();
			this.setMinimumSize(new Dimension(ancho_pantalla / 2, alto_pantalla / 2));
			this.setSize(ancho_pantalla, alto_pantalla);
			this.setPreferredSize(new Dimension(ancho_pantalla, alto_pantalla));
			// this.setLocation(ancho_pantalla - (ancho_pantalla/2), alto_pantalla -
			// (alto_pantalla/2));
		} else {
			ancho_pantalla = Toolkit.getDefaultToolkit().getScreenSize().width;
			alto_pantalla = Toolkit.getDefaultToolkit().getScreenSize().height;
			this.setMinimumSize(new Dimension(ancho_pantalla / 2, alto_pantalla / 2));
			this.setSize(ancho_pantalla, alto_pantalla);
			this.setPreferredSize(new Dimension(ancho_pantalla, alto_pantalla));
			memoryApp = new MemoryApp();
			// this.setLocation(ancho_pantalla - (ancho_pantalla/2), alto_pantalla -
			// (alto_pantalla/2));
		}
		componetPanels();
		cargarMemoryApp();
		this.pack();
		this.show();// levanta el jframe
		// this.setVisible(true);// lo hace visible
	}

	private void componetPanels() {
		panNorte = new PanelNorte(this);
		panNorte.setVisible(true);
		panCentral = new PanelCentral(this);
		panCentral.setVisible(true);
		this.add(panNorte, BorderLayout.NORTH);
		this.add(panCentral, BorderLayout.CENTER);
	}

	public void cambiarTitulo(String title) {
		setTitle(Propes.getProperty("titulo") + " - " + title);
	}

	public void resertTitulo() {
		setTitle(Propes.getProperty("titulo"));
	}

	public void cargarMemoryApp() {
		if (memoryApp != null) {
			if (memoryApp.getRuta() != null) {
				panNorte.chooser.setCurrentDirectory(new File(memoryApp.getRuta()));
			}
			if (memoryApp.getApariencia() != null) {
				SubstanceLookAndFeel.setSkin(memoryApp.getApariencia());
				SwingUtilities.updateComponentTreeUI(this);
			}
		}
	}

	public void guardarMemoryApp() {
		GuardarMemoryApp.guardarMemoryApp(memoryApp);
	}

	public void windowOpened(WindowEvent e) {
		System.out.println(" windowOpened ");
	}

	public void windowClosing(WindowEvent e) {
		ancho_pantalla = getWidth();
		alto_pantalla = getHeight();
		memoryApp.setAnchoPantalla(ancho_pantalla);
		memoryApp.setAltoPantalla(alto_pantalla);
		guardarMemoryApp();
		System.out.println(" windowClosing ");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println(" windowClosed ");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println(" windowIconified ");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println(" windowDeiconified ");
	}

	public void windowActivated(WindowEvent e) {
		System.out.println(" windowActivated ");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println(" windowDeactivated ");
	}

	public void componentResized(ComponentEvent e) {
		System.out.println(" componentResized ");
	}

	public void componentMoved(ComponentEvent e) {
		System.out.println(" componentMoved ");
	}

	public void componentShown(ComponentEvent e) {
		System.out.println(" componentShown ");
	}

	public void componentHidden(ComponentEvent e) {
		System.out.println(" componentHidden ");
	}

}
