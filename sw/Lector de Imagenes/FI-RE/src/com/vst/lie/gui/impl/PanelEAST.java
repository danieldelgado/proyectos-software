package com.vst.lie.gui.impl;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

import com.vst.lie.gui.custom.CustomPanel;

@SuppressWarnings("serial")
public class PanelEAST extends CustomPanel {

	Principal mainFrame = null;
	public JLabel label1;
	public JSeparator separator2;
	public JPanel panel1;
	public JButton button1;
	public JButton button2;
	public JButton button3;
	public JButton button4;
	public JButton button5;
	public JButton button6;
	public JButton button7;
	public JButton button8;
	public JButton button9;
	public JButton button10;
	public JButton button12;
	public JButton button13;
	public JButton button14;
	public JButton button15;
	public JSeparator separator1;
	public JProgressBar progressBar1;
	
	public PanelEAST(Principal frame) {
		mainFrame = frame;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		initComponents();
	}

	
	public void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		label1 = new JLabel();
		separator2 = new JSeparator();
		panel1 = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		separator1 = new JSeparator();
		progressBar1 = new JProgressBar();


		label1.setText("Editar imagen :");
		add(label1);

		separator2.setMaximumSize(new Dimension(32767, 50));
		add(separator2);

		panel1.setLayout(new GridLayout(7, 2));

		button1.setText("text");
		panel1.add(button1);

		button2.setText("text");
		panel1.add(button2);

		button3.setText("text");
		panel1.add(button3);

		button4.setText("text");
		panel1.add(button4);

		button5.setText("text");
		panel1.add(button5);

		button6.setText("text");
		panel1.add(button6);

		button7.setText("text");
		panel1.add(button7);

		button8.setText("text");
		panel1.add(button8);

		button9.setText("text");
		panel1.add(button9);

		button10.setText("text");
		panel1.add(button10);

		button12.setText("text");
		panel1.add(button12);

		button13.setText("text");
		panel1.add(button13);

		button14.setText("text");
		panel1.add(button14);

		button15.setText("text");
		panel1.add(button15);
		add(panel1);
		add(separator1);
		add(progressBar1);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

}
