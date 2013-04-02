package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;

import pe.com.sf.re.fi.analisis.controller.AnalizarArchivoController;
import pe.com.sf.re.fi.analisis.gui.componet.CustomButton;
import pe.com.sf.re.fi.analisis.gui.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomToggleButton;

/**
 * @author SHOCKIE
 */
@SuppressWarnings("serial")
public class PanelCentral extends CustomPanel {

	private Principal principal = null;
	private Map<Integer, File> lstArchivos;
	private File ftemp = null;
	private CustomPanel pnlContenedorListadoImagenesMiniaruta;
	public ListaImagenesName listaArchivos;
	private CustomPanel pnlApuntadorPagina;
	private CustomLabel lblApuntador;
	private JSpinner spnApuntadorPagina;
	private CustomPanel pnlSpliptPreviewImage;
	private JSplitPane splitContenedor;
	private CustomPanel pnlPreviewIzquierda;
	public ImagePreviewSelecionado customImagePreview;
	private JProgressBar prgBarIzq;
	private CustomPanel pnlPreviewDerecha;
	private JProgressBar prgBarDer;

	// ///////////////////////////////////

	private CustomPanel paneleDerechaBotones;
	private CustomPanel panelContenedorBotonesOociones;
	private CustomButton btnAumentarVista;
	private CustomButton btnDisminuirVista;
	private CustomToggleButton btnActivarBtnsVista;
	private boolean btnActivarBtn = false;

	// ///////////////////////////////////

	private CustomToggleButton toggleButton1;
	private CustomToggleButton toggleButton2;
	private CustomToggleButton toggleButton3;
	private CustomToggleButton toggleButton4;
	private CustomButton button4;
	private CustomButton button5;
	private CustomToggleButton toggleButton5;
	private CustomButton button6;
	private CustomToggleButton toggleButton6;

	private final static Logger _log = Logger.getLogger(PanelCentral.class.getName());

	public PanelCentral(Principal principal) {
		_log.info("Cargando... PanelCentral");
		this.principal = principal;
		initComponents();
	}

	public void initComponents() {

		pnlContenedorListadoImagenesMiniaruta = new CustomPanel();
		listaArchivos = new ListaImagenesName(this);
		pnlApuntadorPagina = new CustomPanel();
		lblApuntador = new CustomLabel();
		spnApuntadorPagina = new JSpinner();
		pnlSpliptPreviewImage = new CustomPanel();
		splitContenedor = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlPreviewIzquierda = new CustomPanel();
		customImagePreview = new ImagePreviewSelecionado();
		prgBarIzq = new JProgressBar();
		pnlPreviewDerecha = new CustomPanel();
		prgBarDer = new JProgressBar();
		paneleDerechaBotones = new CustomPanel();
		panelContenedorBotonesOociones = new CustomPanel();
		btnAumentarVista = new CustomButton();
		btnDisminuirVista = new CustomButton();
		btnActivarBtnsVista = new CustomToggleButton();
		toggleButton1 = new CustomToggleButton();
		toggleButton2 = new CustomToggleButton();
		toggleButton3 = new CustomToggleButton();
		toggleButton4 = new CustomToggleButton();
		button4 = new CustomButton();
		button5 = new CustomButton();
		toggleButton5 = new CustomToggleButton();
		button6 = new CustomButton();
		toggleButton6 = new CustomToggleButton();

		setLayout(new BorderLayout());
		pnlContenedorListadoImagenesMiniaruta.setLayout(new BorderLayout());
		pnlContenedorListadoImagenesMiniaruta.add(listaArchivos, BorderLayout.CENTER);
		pnlApuntadorPagina.setLayout(new BoxLayout(pnlApuntadorPagina, BoxLayout.X_AXIS));
		lblApuntador.setText("text");
		pnlApuntadorPagina.add(lblApuntador);
		pnlApuntadorPagina.add(spnApuntadorPagina);
		pnlContenedorListadoImagenesMiniaruta.add(pnlApuntadorPagina, BorderLayout.SOUTH);
		add(pnlContenedorListadoImagenesMiniaruta, BorderLayout.WEST);
		pnlSpliptPreviewImage.setLayout(new BoxLayout(pnlSpliptPreviewImage, BoxLayout.X_AXIS));
		pnlPreviewIzquierda.setLayout(new BorderLayout());
		prgBarIzq.setValue(50);

		customImagePreview.setBackground(Color.BLACK);
		customImagePreview.setBorder(new LineBorder(Color.BLACK));
		pnlPreviewIzquierda.add(customImagePreview, BorderLayout.CENTER);
		pnlPreviewIzquierda.add(prgBarIzq, BorderLayout.SOUTH);

		splitContenedor.setOneTouchExpandable(true);
		Dimension minimumSize = new Dimension(100, 50);
		pnlPreviewIzquierda.setMinimumSize(minimumSize);
		pnlPreviewDerecha.setMinimumSize(minimumSize);
		splitContenedor.setDividerLocation(150);
		splitContenedor.setDividerSize(10);

		pnlPreviewDerecha.setBackground(Color.BLACK);
		pnlPreviewDerecha.setBorder(new LineBorder(Color.BLACK));
		splitContenedor.setPreferredSize(new Dimension(400, 200));
		splitContenedor.setLeftComponent(pnlPreviewIzquierda);
		pnlPreviewDerecha.setLayout(new BorderLayout());
		prgBarDer.setValue(50);
		pnlPreviewDerecha.add(prgBarDer, BorderLayout.SOUTH);
		splitContenedor.setRightComponent(pnlPreviewDerecha);
		pnlSpliptPreviewImage.add(splitContenedor);
		add(pnlSpliptPreviewImage, BorderLayout.CENTER);

		// ///////////////////////////////////

		paneleDerechaBotones.setLayout(new BoxLayout(paneleDerechaBotones, BoxLayout.X_AXIS));
		panelContenedorBotonesOociones.setAlignmentY(0.0F);
		panelContenedorBotonesOociones.setLayout(new BoxLayout(panelContenedorBotonesOociones, BoxLayout.Y_AXIS));
		btnActivarBtnsVista.setEnabled(false);
		btnActivarBtnsVista.setText("+/-");
		btnActivarBtnsVista.addActionListener(this);
		panelContenedorBotonesOociones.add(btnActivarBtnsVista);
		btnAumentarVista.setEnabled(false);
		btnAumentarVista.setText("+");
		btnAumentarVista.addActionListener(this);
		panelContenedorBotonesOociones.add(btnAumentarVista);
		btnDisminuirVista.setEnabled(false);
		btnDisminuirVista.setText("-");
		btnDisminuirVista.addActionListener(this);
		panelContenedorBotonesOociones.add(btnDisminuirVista);
		toggleButton1.setText("text");
		panelContenedorBotonesOociones.add(toggleButton1);
		toggleButton2.setText("text");
		panelContenedorBotonesOociones.add(toggleButton2);
		toggleButton3.setText("text");
		panelContenedorBotonesOociones.add(toggleButton3);
		toggleButton4.setText("text");
		panelContenedorBotonesOociones.add(toggleButton4);
		button4.setText("text");
		panelContenedorBotonesOociones.add(button4);
		button5.setText("text");
		panelContenedorBotonesOociones.add(button5);
		toggleButton5.setText("text");
		panelContenedorBotonesOociones.add(toggleButton5);
		button6.setText("text");
		panelContenedorBotonesOociones.add(button6);
		toggleButton6.setText("text");
		panelContenedorBotonesOociones.add(toggleButton6);
		paneleDerechaBotones.add(panelContenedorBotonesOociones);
		add(paneleDerechaBotones, BorderLayout.EAST);

	}

	public void cargarImagenesDescriptivas() {
		lstArchivos = AnalizarArchivoController.lstArchivos;
		_log.info("  lstArchivos :" + lstArchivos);
		listaArchivos.cargarListaImagenes(lstArchivos);
	}

	public void mostrarImagenSeleccionada(Integer id) {
		ftemp = lstArchivos.get(id);
		principal.resertTitulo();
		principal.cambiarTitulo(ftemp.getName());
		customImagePreview.propertyChange(ftemp);
	}

	public void activarBtnVista(boolean v) {
		btnActivarBtnsVista.setEnabled(v);
	}

	public void activarBotonesVistaAumentaDisminuye(boolean v) {
		btnAumentarVista.setEnabled(v);
		btnDisminuirVista.setEnabled(v);
	}

	public void desactivarBotonesPanelDerecho() {
		btnActivarBtnsVista.setEnabled(false);
		btnAumentarVista.setEnabled(false);
		btnDisminuirVista.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();
		if (button == btnActivarBtnsVista) {
			btnActivarBtn = btnActivarBtnsVista.getModel().isSelected();
			if (btnActivarBtn) {
				activarBotonesVistaAumentaDisminuye(true);
			} else {
				activarBotonesVistaAumentaDisminuye(false);
			}
		} else if (button == btnAumentarVista) {

		} else if (button == btnDisminuirVista) {

		}
	}
}
