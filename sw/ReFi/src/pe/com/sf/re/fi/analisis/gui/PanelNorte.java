package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

import pe.com.sf.re.fi.analisis.controller.AnalizarArchivoController;
import pe.com.sf.re.fi.analisis.gui.componet.CustomButton;
import pe.com.sf.re.fi.analisis.gui.componet.CustomCombo;
import pe.com.sf.re.fi.analisis.gui.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomToggleButton;
import pe.com.sf.re.fi.util.Constantes;
import pe.com.sf.re.fi.util.Propes;

@SuppressWarnings("serial")
public class PanelNorte extends CustomPanel {

	CustomPanel panleContenedor;
	CustomPanel panelConnedorBarraProgreso;
	JProgressBar progressBar;
	CustomPanel panelToolBarApariencia;
	CustomPanel panelApariencia;
	JToolBar toolbarApariencia;
	CustomLabel lblApariencia;
	CustomCombo cboApariencia;
	CustomPanel pnlToolBarsOpciones;
	JToolBar tbOpcionesArchivos;
	CustomButton btnSelecionarArchivo;
	CustomButton btnSelccionarDirectorio;
	CustomButton btnCargarArchivos;
	JToolBar tbOpciones;
	CustomButton button2;
	CustomToggleButton toggleButton3;
	CustomToggleButton toggleButton4;
	Principal principal = null;
	JFileChooser chooser = new JFileChooser();
	FileNameExtensionFilter filter = null;

	public PanelNorte(Principal principal) {
		this.principal = principal;
		initComponents();
		inicializarComponentes();
	}

	@SuppressWarnings("unchecked")
	public void initComponents() {
		setLayout(new BorderLayout());
		panleContenedor = new CustomPanel();
		panelConnedorBarraProgreso = new CustomPanel();
		progressBar = new JProgressBar();
		panelToolBarApariencia = new CustomPanel();
		panelApariencia = new CustomPanel();
		toolbarApariencia = new JToolBar();
		lblApariencia = new CustomLabel();
		cboApariencia = new CustomCombo(new Vector(SubstanceLookAndFeel.getAllSkins().keySet()));
		pnlToolBarsOpciones = new CustomPanel();
		tbOpcionesArchivos = new JToolBar();
		btnSelecionarArchivo = new CustomButton();
		btnSelccionarDirectorio = new CustomButton();
		btnCargarArchivos = new CustomButton();
		tbOpciones = new JToolBar();
		button2 = new CustomButton();
		toggleButton3 = new CustomToggleButton();
		toggleButton4 = new CustomToggleButton();
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
		add(panleContenedor, BorderLayout.CENTER);
	}

	private void inicializarComponentes() {
		progressBar.setVisible(false);
		lblApariencia.setText(Propes.getProperty("lbl.apariencia"));
		btnSelecionarArchivo.setText(Propes.getProperty("btn.seleccionar.archivo"));
		btnSelccionarDirectorio.setText(Propes.getProperty("btn.seleccionar.directorio"));
		btnCargarArchivos.setEnabled(false);
		btnCargarArchivos.setText(Propes.getProperty("btn.cargar"));
		toggleButton4.setText("text");
		toggleButton3.setText("text");
		button2.setText("text");
		desactivarProgressBarCarga();
	}

	public void itemStateChanged(ItemEvent e) {
		Object cbo = e.getSource();
		if (cbo == cboApariencia) {
			final Object item = e.getItem();
			if (e.getStateChange() == 1)
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							SkinInfo skinInfo = (SkinInfo) SubstanceLookAndFeel.getAllSkins().get(item);
							SubstanceLookAndFeel.setSkin(skinInfo.getClassName());
							SwingUtilities.updateComponentTreeUI(principal);
						} catch (Exception exc) {
						}
					}
				});
		}

	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if (button == btnSelecionarArchivo) {
			desactivarProgressBarCarga();
			filter = null;
			filter = new FileNameExtensionFilter("Solo Imagenes", Constantes.EXTENSIONES_IMAGENES);
			chooser.setFileFilter(filter);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File ruta = null;
				try {
					ruta = chooser.getSelectedFile();
					ruta = AnalizarArchivoController.obtenerArchivo(ruta.getAbsolutePath(), true);
					if (ruta != null) {
						cambiarTitulo(ruta.getAbsolutePath());
						activarProgressBarCarga();
					} else {
						principal.resertTitulo();
						desactivarProgressBarCarga();
					}
					ruta = null;
				} catch (Exception e1) {
					principal.resertTitulo();
					desactivarProgressBarCarga();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			returnVal = 0;
			filter = null;
		} else if (button == btnSelccionarDirectorio) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File ruta = null;
				try {
					ruta = chooser.getSelectedFile();
					ruta = AnalizarArchivoController.obtenerArchivo(ruta.getAbsolutePath(), false);
					if (ruta != null) {
						cambiarTitulo(ruta.getAbsolutePath());
						activarProgressBarCarga();
					}else {
						principal.resertTitulo();
						desactivarProgressBarCarga();
					}
				} catch (Exception e1) {
					principal.resertTitulo();
					desactivarProgressBarCarga();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
	}

	private void activarProgressBarCarga() {
		progressBar.setVisible(true);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		btnCargarArchivos.setEnabled(true);
	}

	private void desactivarProgressBarCarga() {
		progressBar.setVisible(false);
		progressBar.setMinimum(0);
		progressBar.setValue(0);
		btnCargarArchivos.setEnabled(false);
	}

	private void cambiarTitulo(String title) {
		principal.cambiarTitulo(title);
	}

}
