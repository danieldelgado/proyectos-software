package com.vst.lie.gui.impl;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

import com.jgoodies.forms.factories.Borders;
import com.vst.lie.controller.AnalizarArchivoController;
import com.vst.lie.gui.CustomButton;
import com.vst.lie.gui.CustomCombo;
import com.vst.lie.gui.CustomLabel;
import com.vst.lie.gui.CustomPanel;
import com.vst.lie.gui.CustomToggleButton;

@SuppressWarnings("serial")
public class PanelNorth extends CustomPanel {

	Principal mainFrame = null;
	public CustomPanel contenedor;
	public CustomPanel panelOpciones;
	public CustomPanel panelSeparador;
	public CustomButton btnSeelccioneArchivo;
	public CustomButton btnSelecionarDirectorio;
	public CustomToggleButton toggleButton3;
	public CustomToggleButton toggleButton4;
	public CustomPanel panelSeleccionInterfaz;
	public CustomLabel lblSelecioneINterfaz;
	public CustomCombo cboSeleccioneInterfaz;
	public JSeparator separador;

	public AnalizarArchivoController analizarArchivoController;

	public PanelNorth(Principal frame) {
		mainFrame = frame;
		analizarArchivoController = new AnalizarArchivoController();
		setLayout(new BorderLayout());
		initComponents();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initComponents() {
		contenedor = new CustomPanel();
		panelOpciones = new CustomPanel();
		panelSeparador = new CustomPanel();
		btnSeelccioneArchivo = new CustomButton();
		btnSelecionarDirectorio = new CustomButton();
		toggleButton3 = new CustomToggleButton();
		toggleButton4 = new CustomToggleButton();
		panelSeleccionInterfaz = new CustomPanel();
		lblSelecioneINterfaz = new CustomLabel();
		cboSeleccioneInterfaz = new CustomCombo(new Vector(SubstanceLookAndFeel.getAllSkins().keySet()));
		separador = new JSeparator();

		btnSeelccioneArchivo.addActionListener(this);
		btnSelecionarDirectorio.addActionListener(this);

		cboSeleccioneInterfaz.setSelectedIndex(-1);
		cboSeleccioneInterfaz.addItemListener(this);

		contenedor.setAlignmentX(2.0F);
		contenedor.setMinimumSize(new Dimension(500, 50));
		contenedor.setPreferredSize(new Dimension(500, 50));
		contenedor.setBorder(Borders.DLU4_BORDER);
		contenedor.setLayout(new BorderLayout());

		panelOpciones.setAlignmentX(0.6F);
		panelOpciones.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.X_AXIS));

		panelSeparador.setPreferredSize(new Dimension(10, 0));
		panelSeparador.setLayout(new BorderLayout());

		panelOpciones.add(panelSeparador);

		btnSeelccioneArchivo.setText("Seleccione Archivo");
		panelOpciones.add(btnSeelccioneArchivo);

		btnSelecionarDirectorio.setText("Selecione Directorio");
		panelOpciones.add(btnSelecionarDirectorio);

		toggleButton3.setText("text");
		panelOpciones.add(toggleButton3);

		toggleButton4.setText("text");
		panelOpciones.add(toggleButton4);

		contenedor.add(panelOpciones, BorderLayout.WEST);

		panelSeleccionInterfaz.setLayout(new FlowLayout(FlowLayout.RIGHT));

		lblSelecioneINterfaz.setText("Apariencia");
		panelSeleccionInterfaz.add(lblSelecioneINterfaz);
		panelSeleccionInterfaz.add(cboSeleccioneInterfaz);
		contenedor.add(panelSeleccionInterfaz, BorderLayout.EAST);
		contenedor.add(separador, BorderLayout.SOUTH);

		add(contenedor, BorderLayout.NORTH);

	}

	public void actionPerformed(ActionEvent e) {
		Object button = e.getSource();

		if (button == btnSeelccioneArchivo) {
			mainFrame.panelWEST.desActivarBotonCargar();
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Solo Imagenes", "jpg", "gif", "png", "jpeg");
			chooser.setFileFilter(filter);
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File ruta = null;
				try {
					ruta = analizarArchivoController.obenerArchivo(chooser.getSelectedFile().getAbsolutePath(), true);
					if(ruta!=null){
						mainFrame.panelWEST.txtArchivo.setText(ruta.getAbsolutePath());
						mainFrame.panelWEST.activarBotonCargar();					
					}
				} catch (Exception e1) {
					mainFrame.panelWEST.desActivarBotonCargar();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}
		if (button == btnSelecionarDirectorio) {
			mainFrame.panelWEST.desActivarBotonCargar();
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			int returnVal = chooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File ruta = null;
				try {
					ruta = analizarArchivoController.obenerArchivo(chooser.getSelectedFile().getAbsolutePath(), false);
					if(ruta!=null){
						mainFrame.panelWEST.txtArchivo.setText(ruta.getAbsolutePath());
						mainFrame.panelWEST.activarBotonCargar();					
					}
				} catch (Exception e1) {
					mainFrame.panelWEST.desActivarBotonCargar();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}

	}

	public void itemStateChanged(ItemEvent e) {
		Object cbo = e.getSource();
		if (cbo == cboSeleccioneInterfaz) {
			final Object item = e.getItem();
			if (e.getStateChange() == 1)
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							SkinInfo skinInfo = (SkinInfo) SubstanceLookAndFeel.getAllSkins().get(item);
							SubstanceLookAndFeel.setSkin(skinInfo.getClassName());
							SwingUtilities.updateComponentTreeUI(mainFrame);
						} catch (Exception exc) {
						}
					}
				});
		}

	}

	public void keyPressed(KeyEvent arg0) {

	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
