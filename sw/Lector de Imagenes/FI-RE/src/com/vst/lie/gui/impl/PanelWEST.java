package com.vst.lie.gui.impl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import com.vst.lie.controller.AnalizarArchivoController;
import com.vst.lie.gui.custom.CustomButton;
import com.vst.lie.gui.custom.CustomPanel;
import com.vst.lie.plugins.BufferFile;
import com.vst.lie.plugins.ThreadInterativo;
import com.vst.lie.util.Constantes;

@SuppressWarnings("serial")
public class PanelWEST extends CustomPanel {

	Principal mainFrame = null;
	public JLabel lblArchibo;
	public JTextField txtArchivo;
	public CustomButton btnCarga;
	public JProgressBar prgBarCargar;
	public JSeparator separator1;
	public JScrollPane scrollPane1;
	public JPanel panelVisualizador;
	public Timer timer;
	public ThreadInterativo task;
	public List<BufferedImage> lstBufferedImages = null;

	public PanelWEST(Principal frame) {
		mainFrame = frame;
		setBorder(new LineBorder(Color.black));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}

	public void initComponents() {

		lblArchibo = new JLabel();
		txtArchivo = new JTextField();
		btnCarga = new CustomButton();
		prgBarCargar = new JProgressBar();
		separator1 = new JSeparator();
		scrollPane1 = new JScrollPane();
		panelVisualizador = new JPanel();
		task = new ThreadInterativo();

		timer = new Timer(Constantes.TIEMPO_INTERACION, this);

		prgBarCargar.setStringPainted(true);
		txtArchivo.setEditable(false);
		btnCarga.addActionListener(this);
		btnCarga.setEnabled(false);
		btnCarga.setText("Carga");
		lblArchibo.setText("Archivo o  carpeta:");
		lblArchibo.setMaximumSize(new Dimension(500, 14));
		lblArchibo.setHorizontalAlignment(SwingConstants.LEFT);
		lblArchibo.setHorizontalTextPosition(SwingConstants.LEFT);
		add(lblArchibo);

		txtArchivo.setMaximumSize(new Dimension(2147483647, 20));

		add(txtArchivo);
		add(btnCarga);
		add(prgBarCargar);

		separator1.setMaximumSize(new Dimension(32767, 15));
		add(separator1);

		panelVisualizador.setMaximumSize(new Dimension(516846, 468468));
		panelVisualizador.setLayout(new BoxLayout(panelVisualizador, BoxLayout.Y_AXIS));
		scrollPane1.setViewportView(panelVisualizador);
		add(scrollPane1);

	}

	public void activarBotonCargar() {
		btnCarga.setEnabled(true);
	}

	public void desActivarBotonCargar() {
		btnCarga.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		Object btn = e.getSource();

		if (btn == btnCarga) {
			iniciarCargarProgressBar();
		} else if (btn == timer) {
			iniciarProcesoCargar();
		}
	}

	private void iniciarProcesoCargar() {
		prgBarCargar.setValue(task.getCurrent());
		if (task.isStart()) {	
				lstBufferedImages.add(BufferFile.readFile(AnalizarArchivoController.getFileInteractor()));
		}
		if (task.isDone()) {
			timer.stop();
			btnCarga.setEnabled(true);
			setCursor(null);
			AnalizarArchivoController.identificadorReset();
			AnalizarArchivoController.lstBufferedImages = lstBufferedImages ;
		}
	}

	private void iniciarCargarProgressBar() {
		if (AnalizarArchivoController.files != null) {
			if (AnalizarArchivoController.files.length > 0) {
				if (AnalizarArchivoController.cantidadArchivosInstanciados() > 1) {
					prgBarCargar.setMinimum(0);
					prgBarCargar.setMaximum(AnalizarArchivoController.cantidadArchivosInstanciados() - 1);
					task.setLengthOfTask(AnalizarArchivoController.cantidadArchivosInstanciados());
				} else if (AnalizarArchivoController.cantidadArchivosInstanciados() == 1) {
					prgBarCargar.setMinimum(0);
					prgBarCargar.setMaximum(1);
					task.setLengthOfTask(1);
				}
				lstBufferedImages = new ArrayList<BufferedImage>();
				btnCarga.setEnabled(false);
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				task.go();
				timer.start();
			}
		}
	}
	
}
