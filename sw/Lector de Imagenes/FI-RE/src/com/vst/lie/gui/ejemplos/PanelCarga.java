package com.vst.lie.gui.ejemplos;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Mar 22 05:50:31 CET 2013
 */



/**
 * @author SHOCKIE
 */
public class PanelCarga extends JPanel {
	public PanelCarga() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		label1 = new JLabel();
		progressBar1 = new JProgressBar();

		setLayout(new BorderLayout());

		panel1.setLayout(new BorderLayout());

		label1.setText("text");
		panel1.add(label1, BorderLayout.CENTER);

		progressBar1.setValue(50);
		panel1.add(progressBar1, BorderLayout.SOUTH);
		add(panel1, BorderLayout.CENTER);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel panel1;
	private JLabel label1;
	private JProgressBar progressBar1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
