package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;

import pe.com.sf.re.fi.analisis.controller.AnalizarArchivoController;
import pe.com.sf.re.fi.analisis.gui.componet.CustomButton;
import pe.com.sf.re.fi.analisis.gui.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomToggleButton;
import pe.com.sf.re.fi.analisis.gui.componet.ListaImagenesName;

/**
 * @author SHOCKIE
 */
@SuppressWarnings("serial")
public class PanelCentral extends CustomPanel {

	

	private Principal principal = null;
	private Map<Integer, File> lstArchivos;	
	
	private CustomPanel pnlContenedorListadoImagenesMiniaruta;
	private ListaImagenesName listaArchivos;
	private CustomPanel pnlApuntadorPagina;
	private CustomLabel lblApuntador;
	private JSpinner spnApuntadorPagina;
	private CustomPanel pnlSpliptPreviewImage;
	private JSplitPane splitContenedor;
	private CustomPanel pnlPreviewIzquierda;
	private JProgressBar prgBarIzq;
	private CustomPanel pnlPreviewDerecha;
	private JProgressBar prgBarDer;
	private CustomPanel panel7;
	private CustomPanel panel8;
	private CustomButton button2;
	private CustomButton button3;
	private CustomToggleButton toggleButton1;
	private CustomButton button1;
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
		this.principal = principal;
		initComponents();
		inicializarComponenetes();
	}

	private void inicializarComponenetes() {
		
	}

	public void initComponents() {
		
		pnlContenedorListadoImagenesMiniaruta = new CustomPanel();
		listaArchivos = new ListaImagenesName();
		pnlApuntadorPagina = new CustomPanel();
		lblApuntador = new CustomLabel();		
		spnApuntadorPagina = new JSpinner();
		pnlSpliptPreviewImage = new CustomPanel();
		splitContenedor = new JSplitPane();
		pnlPreviewIzquierda = new CustomPanel();
		prgBarIzq = new JProgressBar();
		pnlPreviewDerecha = new CustomPanel();
		prgBarDer = new JProgressBar();
		panel7 = new CustomPanel();
		panel8 = new CustomPanel();
		button2 = new CustomButton();
		button3 = new CustomButton();
		toggleButton1 = new CustomToggleButton();
		button1 = new CustomButton();
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
		pnlPreviewIzquierda.add(prgBarIzq, BorderLayout.SOUTH);
		splitContenedor.setLeftComponent(pnlPreviewIzquierda);
		pnlPreviewDerecha.setLayout(new BorderLayout());
		prgBarDer.setValue(50);
		pnlPreviewDerecha.add(prgBarDer, BorderLayout.SOUTH);
		splitContenedor.setRightComponent(pnlPreviewDerecha);
		pnlSpliptPreviewImage.add(splitContenedor);
		add(pnlSpliptPreviewImage, BorderLayout.CENTER);
		
		/////////////////////////////////////
				
		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));
		panel8.setAlignmentY(0.0F);
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.Y_AXIS));
		button2.setText("text");
		panel8.add(button2);
		button3.setText("text");
		panel8.add(button3);
		toggleButton1.setText("text");
		panel8.add(toggleButton1);
		button1.setText("text");
		panel8.add(button1);
		toggleButton2.setText("text");
		panel8.add(toggleButton2);
		toggleButton3.setText("text");
		panel8.add(toggleButton3);
		toggleButton4.setText("text");
		panel8.add(toggleButton4);
		button4.setText("text");
		panel8.add(button4);
		button5.setText("text");
		panel8.add(button5);
		toggleButton5.setText("text");
		panel8.add(toggleButton5);
		button6.setText("text");
		panel8.add(button6);
		toggleButton6.setText("text");
		panel8.add(toggleButton6);
		panel7.add(panel8);
		add(panel7, BorderLayout.EAST);
		
	}

	public void cargarImagenesDescriptivas() {
		lstArchivos = AnalizarArchivoController.lstArchivos;
		_log.info("  lstArchivos :" +lstArchivos);
		listaArchivos.cargarListaImagenes(lstArchivos);
		
		
	}
	
	
	
	

}
