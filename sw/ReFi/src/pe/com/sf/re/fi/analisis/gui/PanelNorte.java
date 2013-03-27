package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;

import pe.com.sf.re.fi.analisis.componet.CustomButton;
import pe.com.sf.re.fi.analisis.componet.CustomCombo;
import pe.com.sf.re.fi.analisis.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.componet.CustomToggleButton;

public class PanelNorte extends CustomPanel {

	CustomPanel panel1;
	CustomPanel panel3;
	JProgressBar progressBar1;
	CustomPanel panel4;
	CustomPanel panel5;
	JToolBar toolBar3;
	CustomLabel label1;
	CustomCombo comboBox1;
	CustomPanel panel2;
	JToolBar toolBar1;
	CustomButton button1;
	CustomToggleButton toggleButton2;
	CustomToggleButton toggleButton1;
	JToolBar toolBar2;
	CustomButton button2;
	CustomToggleButton toggleButton3;
	CustomToggleButton toggleButton4;
	Principal principal = null; 
	
	public PanelNorte(Principal principal) {
		this.principal = principal;
		initComponents();
	}

	public void initComponents() {
		panel1 = new CustomPanel();
		panel3 = new CustomPanel();
		progressBar1 = new JProgressBar();
		panel4 = new CustomPanel();
		panel5 = new CustomPanel();
		toolBar3 = new JToolBar();
		label1 = new CustomLabel();
		comboBox1 = new CustomCombo();
		panel2 = new CustomPanel();
		toolBar1 = new JToolBar();
		button1 = new CustomButton();
		toggleButton2 = new CustomToggleButton();
		toggleButton1 = new CustomToggleButton();
		toolBar2 = new JToolBar();
		button2 = new CustomButton();
		toggleButton3 = new CustomToggleButton();
		toggleButton4 = new CustomToggleButton();

		setLayout(new BorderLayout());
		panel1.setLayout(new BorderLayout());

		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));

		progressBar1.setValue(50);
		panel3.add(progressBar1);
		panel1.add(panel3, BorderLayout.SOUTH);

		panel4.setLayout(new BorderLayout());

		panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

		label1.setText("text");
		toolBar3.add(label1);
		toolBar3.add(comboBox1);
		panel5.add(toolBar3);
		panel4.add(panel5, BorderLayout.CENTER);

		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

		button1.setText("text");
		toolBar1.add(button1);

		toggleButton2.setText("text");
		toolBar1.add(toggleButton2);

		toggleButton1.setText("text");
		toolBar1.add(toggleButton1);
		panel2.add(toolBar1);

		button2.setText("text");
		toolBar2.add(button2);

		toggleButton3.setText("text");
		toolBar2.add(toggleButton3);

		toggleButton4.setText("text");
		toolBar2.add(toggleButton4);
		panel2.add(toolBar2);
		panel4.add(panel2, BorderLayout.WEST);
		panel1.add(panel4, BorderLayout.CENTER);
		add(panel1, BorderLayout.CENTER);
	}

}
