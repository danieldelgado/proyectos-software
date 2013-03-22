package com.vst.lie.gui.impl;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.vst.lie.gui.custom.CustomPanel;

@SuppressWarnings("serial")
public class PanelCentral extends CustomPanel {

	Principal mainFrame = null;

	private JLabel label1;
	private JSplitPane splitPane1;
	private JPanel panel1;
	private JPanel panel2;
	
	public PanelCentral(Principal frame) {
		mainFrame = frame;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}
	
	private void initComponents() {
		label1 = new JLabel();
		splitPane1 = new JSplitPane();
		panel1 = new JPanel();
		panel2 = new JPanel();

		label1.setText("text");
		add(label1);


		panel1.setLayout(new FlowLayout());
		splitPane1.setLeftComponent(panel1);

		panel2.setLayout(new FlowLayout());
		splitPane1.setRightComponent(panel2);
		add(splitPane1);
	}
	
	
	
}
