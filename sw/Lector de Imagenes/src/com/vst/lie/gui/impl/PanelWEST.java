package com.vst.lie.gui.impl;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
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
import com.vst.lie.gui.CustomButton;
import com.vst.lie.gui.CustomPanel;
import com.vst.lie.plugins.LongTask;

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
	public LongTask task;
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
		task = new LongTask();
		
		timer = new Timer(1000,this);
		
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
			if (AnalizarArchivoController.files != null) {
				if (AnalizarArchivoController.files.length > 0) {
					prgBarCargar.setValue(prgBarCargar.getMinimum());
					System.out.println("syso:"+AnalizarArchivoController.cantidadArchivosInstanciados());
					prgBarCargar.setValue(AnalizarArchivoController.cantidadArchivosInstanciados());	
					lstBufferedImages = new ArrayList<BufferedImage>(); 
					btnCarga.setEnabled(false);
					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));				
					task.go();
					timer.start();		
				}
			}
		}else
			if (btn == timer) {
				prgBarCargar.setValue(task.getCurrent());
				String s = task.getMessage();
				System.out.println(" s "+s);
				if (s != null) {
					try {
						BufferedImage img = ImageIO.read(AnalizarArchivoController.getFileInteractor());
						lstBufferedImages.add(img);	
						System.out.println("tamaño:"+lstBufferedImages.size());
					} catch (IOException e1) {
						e1.printStackTrace();
					}	
				}
				if (task.isDone()) {
//					Toolkit.getDefaultToolkit().beep();
					timer.stop();
					btnCarga.setEnabled(true);
					setCursor(null);
					AnalizarArchivoController.identificadorReset();
				}
			}
		
		
		

	}

}
