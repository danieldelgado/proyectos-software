package com.vst.lie.gui.ejemplos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sat Mar 16 19:48:47 CET 2013
 */



/**
 * @author SHOCKIE
 */
public class panelIzquierda extends JPanel {
	public panelIzquierda() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		label1 = new JLabel();
		textField1 = new JTextField();
		progressBar1 = new JProgressBar();
		separator1 = new JSeparator();
		scrollPane1 = new JScrollPane();
		panel1 = new JPanel();

		setBorder(new LineBorder(Color.black));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		label1.setText("Archivo o  carpeta:");
		label1.setMaximumSize(new Dimension(500, 14));
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		label1.setHorizontalTextPosition(SwingConstants.LEFT);
		add(label1);

		textField1.setMaximumSize(new Dimension(2147483647, 20));
		add(textField1);
		add(progressBar1);

		separator1.setMaximumSize(new Dimension(32767, 15));
		add(separator1);


		panel1.setMaximumSize(new Dimension(516846, 468468));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		scrollPane1.setViewportView(panel1);
		add(scrollPane1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JLabel label1;
	private JTextField textField1;
	private JProgressBar progressBar1;
	private JSeparator separator1;
	private JScrollPane scrollPane1;
	private JPanel panel1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
