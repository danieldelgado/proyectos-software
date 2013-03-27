package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

import pe.com.sf.re.fi.analisis.gui.componet.CustomButton;
import pe.com.sf.re.fi.analisis.gui.componet.CustomCombo;
import pe.com.sf.re.fi.analisis.gui.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomToggleButton;
import pe.com.sf.re.fi.util.Constantes;
import pe.com.sf.re.fi.util.Propes;

@SuppressWarnings("serial")
public class PanelNorte extends CustomPanel {

	private Principal principal;
	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private SkinInfo skinInfo;
	private static Set<String> stApariencias;
	private File rutaCarga;
	private List<File> lstArchivos;
	private int countProgress = 0;
	/**
	 * Componentes
	 */
	private CustomPanel panleContenedor;
	private CustomPanel panelConnedorBarraProgreso;
	private JProgressBar progressBar;
	private CustomPanel panelToolBarApariencia;
	private CustomPanel panelApariencia;
	private JToolBar toolbarApariencia;
	private CustomLabel lblApariencia;
	private CustomCombo cboApariencia;
	private CustomPanel pnlToolBarsOpciones;
	private JToolBar tbOpcionesArchivos;
	private CustomButton btnSelecionarArchivo;
	private CustomButton btnSelccionarDirectorio;
	private CustomButton btnCargarArchivos;
	private JToolBar tbOpciones;
	private CustomButton button2;
	private CustomToggleButton toggleButton3;
	private CustomToggleButton toggleButton4;

	static {
		stApariencias = SubstanceLookAndFeel.getAllSkins().keySet();
	}

	private final static Logger _log = Logger.getLogger(PanelNorte.class.getName());

	public PanelNorte(Principal principal) {
		this.principal = principal;
		initComponents();
		inicializarComponentes();
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		panleContenedor = new CustomPanel();
		panelConnedorBarraProgreso = new CustomPanel();
		progressBar = new JProgressBar();
		panelToolBarApariencia = new CustomPanel();
		panelApariencia = new CustomPanel();
		toolbarApariencia = new JToolBar();
		lblApariencia = new CustomLabel();
		cboApariencia = new CustomCombo(new Vector<String>(stApariencias));
		pnlToolBarsOpciones = new CustomPanel();
		tbOpcionesArchivos = new JToolBar();
		btnSelecionarArchivo = new CustomButton();
		btnSelccionarDirectorio = new CustomButton();
		btnCargarArchivos = new CustomButton();
		tbOpciones = new JToolBar();
		button2 = new CustomButton();
		toggleButton3 = new CustomToggleButton();
		toggleButton4 = new CustomToggleButton();
		chooser = new JFileChooser();
		btnSelecionarArchivo.addActionListener(this);
		btnSelccionarDirectorio.addActionListener(this);
		btnCargarArchivos.addActionListener(this);
		cboApariencia.addItemListener(this);
		panleContenedor.setLayout(new BorderLayout());
		panelConnedorBarraProgreso.setLayout(new BoxLayout(panelConnedorBarraProgreso, BoxLayout.X_AXIS));
		panelConnedorBarraProgreso.add(progressBar);
		panleContenedor.add(panelConnedorBarraProgreso, BorderLayout.SOUTH);
		panelToolBarApariencia.setLayout(new BorderLayout());
		panelApariencia.setLayout(new FlowLayout(FlowLayout.RIGHT));
		toolbarApariencia.add(lblApariencia);
		toolbarApariencia.add(cboApariencia);
		panelApariencia.add(toolbarApariencia);
		panelToolBarApariencia.add(panelApariencia, BorderLayout.CENTER);
		pnlToolBarsOpciones.setLayout(new FlowLayout(FlowLayout.LEFT));
		tbOpcionesArchivos.add(btnSelecionarArchivo);
		tbOpcionesArchivos.add(btnSelccionarDirectorio);
		tbOpcionesArchivos.add(btnCargarArchivos);
		pnlToolBarsOpciones.add(tbOpcionesArchivos);
		tbOpciones.add(button2);
		tbOpciones.add(toggleButton3);
		tbOpciones.add(toggleButton4);
		pnlToolBarsOpciones.add(tbOpciones);
		panelToolBarApariencia.add(pnlToolBarsOpciones, BorderLayout.WEST);
		panleContenedor.add(panelToolBarApariencia, BorderLayout.CENTER);
		_log.info("componentes creados");
		add(panleContenedor, BorderLayout.CENTER);
	}

	private void inicializarComponentes() {
		progressBar.setVisible(false);
		progressBar.setStringPainted(true);
		lblApariencia.setText(Propes.getProperty("lbl.apariencia"));
		btnSelecionarArchivo.setText(Propes.getProperty("btn.seleccionar.archivo"));
		btnSelccionarDirectorio.setText(Propes.getProperty("btn.seleccionar.directorio"));
		btnCargarArchivos.setEnabled(false);
		btnCargarArchivos.setText(Propes.getProperty("btn.cargar"));
		toggleButton4.setText("text");
		toggleButton3.setText("text");
		button2.setText("text");
		_log.info("componentes inicializados");
		desactivarProgressBarCarga();
	}

	public void itemStateChanged(ItemEvent e) {
		final Object item = e.getItem();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					skinInfo = (SkinInfo) SubstanceLookAndFeel.getAllSkins().get(item);
					_log.info("Apariencia seleccionada es :" + skinInfo.getClassName());
					SubstanceLookAndFeel.setSkin(skinInfo.getClassName());
					SwingUtilities.updateComponentTreeUI(principal);
					skinInfo = null;
				} catch (Exception exc) {
				}
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if (button == btnSelecionarArchivo) {
			seleccionarArchivo();
		} else if (button == btnSelccionarDirectorio) {
			seleccionarDirectorio();
		} else if (button == btnCargarArchivos) {
			iniciarCargarProgressBar();
		}
		button = null;
	}

	private void iniciarCargarProgressBar() {
		if (rutaCarga != null) {
			lstArchivos = obtenerArchivos(rutaCarga);
			if (lstArchivos != null && lstArchivos.size() > 0) {
				_log.info("cantidad de archvios por leer " + lstArchivos.size());				
			}
		}
	}

	private List<File> obtenerArchivos(File rt) {
		if (rt.canRead()) {
			if (rt.isFile()) {
				List<File> f = new ArrayList<File>();
				progressBar.setValue(countProgress);
				progressBar.setMinimum(countProgress);
				progressBar.setMaximum(1);
				cargarProgressBar();
				countProgress = 0;
				System.out.println(" countProgress :"+countProgress);
				f.add(rt);				
				return f;
			} else if (rt.isDirectory()) {
				File[] ls = rt.listFiles();
				if (ls != null && ls.length > 0) {
					progressBar.setValue(countProgress);
					progressBar.setMinimum(countProgress);
					progressBar.setMaximum(ls.length);
					List<File> f = new ArrayList<File>();
					for (int i = 0; i < ls.length; i++) {
						if (ls[i].canRead() && ls[i].isFile()) {
							f.add(ls[i]);
						}
						cargarProgressBar();
					}
					countProgress = 0;
					System.out.println(" countProgress :"+countProgress);
					return f;
				}
			}
		}
		return null;
	}

	private void cargarProgressBar() {
		new Thread(new Runnable() {
			public void run() {
				try {				
					SwingUtilities.invokeLater(new Runnable() {			
						public void run() {
							try {
								countProgress ++ ;
								System.out.println(" countProgress :"+countProgress);
								progressBar.setValue(countProgress);
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					});	
				} finally {
					
				}
			}
		}).start();
			
	}

	private void seleccionarDirectorio() {
		File ruta = null;
		rutaCarga = null;
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		principal.resertTitulo();
		Integer returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ruta = chooser.getSelectedFile();
				if (ruta != null) {
					_log.info("directorio seleccionado : " + ruta);
					cambiarTitulo(ruta.getAbsolutePath());
					activarProgressBarCarga();
					rutaCarga = ruta;
				} else {
					principal.resertTitulo();
					desactivarProgressBarCarga();
				}
			} catch (Exception e1) {
				principal.resertTitulo();
				desactivarProgressBarCarga();
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			ruta = null;
		} else {
			principal.resertTitulo();
		}
		returnVal = 0;
	}

	private void seleccionarArchivo() {
		File ruta = null;
		rutaCarga = null;
		filter = null;
		filter = new FileNameExtensionFilter("Solo " + Constantes.EXTENSIONES_CAD_IMAGENES, Constantes.EXTENSIONES_IMAGENES);
		principal.resertTitulo();
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		desactivarProgressBarCarga();
		Integer returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ruta = chooser.getSelectedFile();
				_log.info("archivo seleccionado : " + ruta);
				if (ruta != null) {
					cambiarTitulo(ruta.getAbsolutePath());
					activarProgressBarCarga();
					rutaCarga = ruta;
				} else {
					principal.resertTitulo();
					desactivarProgressBarCarga();
				}

			} catch (Exception e1) {
				principal.resertTitulo();
				desactivarProgressBarCarga();
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
			ruta = null;
		} else {
			principal.resertTitulo();
		}
		returnVal = 0;
		filter = null;

	}

	private void activarProgressBarCarga() {
		_log.info("activar Progress Bar Carga");
		progressBar.setVisible(true);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		btnCargarArchivos.setEnabled(true);
	}

	private void desactivarProgressBarCarga() {
		_log.info("desactivar Progress Bar Carga");
		progressBar.setVisible(false);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		btnCargarArchivos.setEnabled(false);
	}

	private void cambiarTitulo(String title) {
		principal.cambiarTitulo(title);
	}

}
