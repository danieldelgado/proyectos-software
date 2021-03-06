package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.io.Serializable;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXFrame;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;

import pe.com.sf.re.fi.main.ReFi;
import pe.com.sf.re.fi.memory.GuardarMemoryApp;
import pe.com.sf.re.fi.memory.LeerMemoryApp;
import pe.com.sf.re.fi.memory.MemoryApp;
import pe.com.sf.re.fi.util.Propes;

public class Principal extends JXFrame implements Serializable, WindowListener, ComponentListener, WindowStateListener, WindowFocusListener {

	private static final long serialVersionUID = -4550679687084521316L;

	public int ancho_pantalla;
	public int alto_pantalla;

	public PanelNorte panNorte = null;
	public PanelCentral panCentral = null;
	public MemoryApp memoryApp = LeerMemoryApp.leerMemoryApp();

	private final static Logger _log = Logger.getLogger(Principal.class.getName());

	public Principal(String title) {
		super(title);
		_log.info("inicializando app");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponet();
	}

	@SuppressWarnings("deprecation")
	private void initComponet() {
		_log.info("Cargando componentes...");
		this.addWindowListener(this);
		this.addComponentListener(this);
		this.addWindowStateListener(this);
		this.setIconImage(new ImageIcon("rss_reader.ico").getImage());
		if (memoryApp != null) {
			_log.info("Leyendo temporales...");
			ancho_pantalla = memoryApp.getAnchoPantalla();
			_log.info("Ancho pantalla :" + ancho_pantalla + "px");
			alto_pantalla = memoryApp.getAltoPantalla();
			_log.info("Alto pantalla :" + alto_pantalla + "px");
			this.setMinimumSize(new Dimension(ancho_pantalla / 2, alto_pantalla / 2));
			this.setSize(ancho_pantalla, alto_pantalla);
			this.setPreferredSize(new Dimension(ancho_pantalla, alto_pantalla));
			// this.setLocation(ancho_pantalla - (ancho_pantalla/2),
			// alto_pantalla - (alto_pantalla/2));
		} else {
			_log.info("No se encontro temporales, cargando valores por default ...");
			ancho_pantalla = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
			_log.info("Ancho pantalla :" + ancho_pantalla + "px");
			alto_pantalla = Toolkit.getDefaultToolkit().getScreenSize().height - 150;
			_log.info("Alto pantalla :" + alto_pantalla + "px");
			this.setMinimumSize(new Dimension(ancho_pantalla / 2, alto_pantalla / 2));
			this.setSize(ancho_pantalla, alto_pantalla);
			this.setPreferredSize(new Dimension(ancho_pantalla, alto_pantalla));
			memoryApp = new MemoryApp();
			// this.setLocation(ancho_pantalla - (ancho_pantalla/2),
			// alto_pantalla - (alto_pantalla/2));
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
		_log.info("Termino cargar panel norte");
		panCentral = new PanelCentral(this);
		panCentral.setVisible(true);
		_log.info("Termino cargar panel central");
		this.add(panNorte, BorderLayout.NORTH);
		this.add(panCentral, BorderLayout.CENTER);
		ReFi.terminarCargar();
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
//		System.out.println(" windowOpened ");
	}

	public void windowClosing(WindowEvent e) {
		ancho_pantalla = getWidth();
		alto_pantalla = getHeight();
		memoryApp.setAnchoPantalla(ancho_pantalla);
		memoryApp.setAltoPantalla(alto_pantalla);
		guardarMemoryApp();
//		System.out.println(" windowClosing ");
	}

	public void windowClosed(WindowEvent e) {
//		System.out.println(" windowClosed ");
	}

	public void windowIconified(WindowEvent e) {
//		System.out.println(" windowIconified ");
	}

	public void windowDeiconified(WindowEvent e) {
//		System.out.println(" windowDeiconified ");
	}

	public void windowActivated(WindowEvent e) {
//		System.out.println(" windowActivated ");
	}

	public void windowDeactivated(WindowEvent e) {
//		System.out.println(" windowDeactivated ");
	}

	public void componentResized(ComponentEvent e) {
//		System.out.println(" componentResized ");
	}

	public void componentMoved(ComponentEvent e) {
//		System.out.println(" componentMoved ");
	}

	public void componentShown(ComponentEvent e) {
//		System.out.println(" componentShown ");
	}

	public void componentHidden(ComponentEvent e) {
//		System.out.println(" componentHidden ");
	}

	public void windowGainedFocus(WindowEvent e) {
//		System.out.println(" windowGainedFocus ");
	}

	public void windowLostFocus(WindowEvent e) {
		System.out.println(" windowLostFocus ");
	}

	public void windowStateChanged(WindowEvent e) {
		if (e.getNewState() == JFrame.MAXIMIZED_BOTH) {
			System.out.println(" MAXIMIZED_BOTH ");
		}
		System.out.println(" windowStateChanged ");
	}

}
