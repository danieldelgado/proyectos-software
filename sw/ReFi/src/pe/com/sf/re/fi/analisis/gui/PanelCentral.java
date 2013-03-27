package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;

import pe.com.sf.re.fi.analisis.gui.componet.CustomButton;
import pe.com.sf.re.fi.analisis.gui.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.gui.componet.CustomToggleButton;

/**
 * @author SHOCKIE
 */
@SuppressWarnings("serial")
public class PanelCentral extends CustomPanel {

	CustomPanel pnlContenedorListadoImagenesMiniaruta;
	CustomPanel pnlListadoImagenesMiniaruta;
	CustomPanel pnlApuntadorPagina;
	CustomLabel lblApuntador;
	JSpinner spnApuntadorPagina;
	CustomPanel pnlSpliptPreviewImage;
	JSplitPane splitContenedor;
	CustomPanel pnlPreviewIzquierda;
	JProgressBar prgBarIzq;
	CustomPanel pnlPreviewDerecha;
	JProgressBar prgBarDer;
	CustomPanel panel7;
	CustomPanel panel8;
	CustomButton button2;
	CustomButton button3;
	CustomToggleButton toggleButton1;
	CustomButton button1;
	CustomToggleButton toggleButton2;
	CustomToggleButton toggleButton3;
	CustomToggleButton toggleButton4;
	CustomButton button4;
	CustomButton button5;
	CustomToggleButton toggleButton5;
	CustomButton button6;
	CustomToggleButton toggleButton6;
	Principal principal = null;

	public PanelCentral(Principal principal) {
		this.principal = principal;
		initComponents();
		inicializarComponenetes();
	}

	private void inicializarComponenetes() {
		
	}

	public void initComponents() {
		
		pnlContenedorListadoImagenesMiniaruta = new CustomPanel();
		pnlListadoImagenesMiniaruta = new CustomPanel();
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
		pnlListadoImagenesMiniaruta.setLayout(new BoxLayout(pnlListadoImagenesMiniaruta, BoxLayout.X_AXIS));
		pnlContenedorListadoImagenesMiniaruta.add(pnlListadoImagenesMiniaruta, BorderLayout.NORTH);
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

}
