package com.vst.lie.gui.ejemplos;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sat Mar 16 20:05:07 CET 2013
 */



/**
 * @author SHOCKIE
 */
public class panelCentral extends JPanel {
	public panelCentral() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		label1 = new JLabel();
		splitPane1 = new JSplitPane();
		panel1 = new JPanel();
		panel2 = new JPanel();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		label1.setText("text");
		add(label1);


		panel1.setLayout(new FlowLayout());
		splitPane1.setLeftComponent(panel1);

		panel2.setLayout(new FlowLayout());
		splitPane1.setRightComponent(panel2);
		add(splitPane1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JLabel label1;
	private JSplitPane splitPane1;
	private JPanel panel1;
	private JPanel panel2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
