package pe.com.sf.re.fi.analisis.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;

import pe.com.sf.re.fi.analisis.componet.CustomButton;
import pe.com.sf.re.fi.analisis.componet.CustomLabel;
import pe.com.sf.re.fi.analisis.componet.CustomPanel;
import pe.com.sf.re.fi.analisis.componet.CustomToggleButton;

/**
 * @author SHOCKIE
 */
@SuppressWarnings("serial")
public class PanelCentral extends CustomPanel {

	CustomPanel panel1;
	CustomPanel panel5;
	CustomPanel panel6;
	CustomLabel label1;
	JSpinner spinner1;
	CustomPanel panel2;
	JSplitPane splitPane1;
	CustomPanel panel3;
	JProgressBar progressBar1;
	CustomPanel panel4;
	JProgressBar progressBar2;
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
	}

	public void initComponents() {
		panel1 = new CustomPanel();
		panel5 = new CustomPanel();
		panel6 = new CustomPanel();
		label1 = new CustomLabel();
		spinner1 = new JSpinner();
		panel2 = new CustomPanel();
		splitPane1 = new JSplitPane();
		panel3 = new CustomPanel();
		progressBar1 = new JProgressBar();
		panel4 = new CustomPanel();
		progressBar2 = new JProgressBar();
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

		panel1.setLayout(new BorderLayout());

		panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));
		panel1.add(panel5, BorderLayout.NORTH);

		panel6.setLayout(new BoxLayout(panel6, BoxLayout.X_AXIS));

		label1.setText("text");
		panel6.add(label1);
		panel6.add(spinner1);
		panel1.add(panel6, BorderLayout.SOUTH);
		add(panel1, BorderLayout.WEST);

		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

		panel3.setLayout(new BorderLayout());

		progressBar1.setValue(50);
		panel3.add(progressBar1, BorderLayout.SOUTH);
		splitPane1.setLeftComponent(panel3);

		panel4.setLayout(new BorderLayout());

		progressBar2.setValue(50);
		panel4.add(progressBar2, BorderLayout.SOUTH);
		splitPane1.setRightComponent(panel4);
		panel2.add(splitPane1);
		add(panel2, BorderLayout.CENTER);

		panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));

		panel8.setAlignmentY(0.0F);
		panel8.setLayout(new BoxLayout(panel8, BoxLayout.Y_AXIS));

		button2.setText("text");
		panel8.add(button2);

		button3.setText("text");
		panel8.add(button3);

		toggleButton1.setText("text");
		toggleButton1.setPreferredSize(new Dimension(55, 23));
		toggleButton1.setMaximumSize(new Dimension(55, 23));
		toggleButton1.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton1);

		button1.setText("text");
		panel8.add(button1);

		toggleButton2.setText("text");
		toggleButton2.setPreferredSize(new Dimension(55, 23));
		toggleButton2.setMaximumSize(new Dimension(55, 23));
		toggleButton2.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton2);

		toggleButton3.setText("text");
		toggleButton3.setPreferredSize(new Dimension(55, 23));
		toggleButton3.setMaximumSize(new Dimension(55, 23));
		toggleButton3.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton3);

		toggleButton4.setText("text");
		toggleButton4.setPreferredSize(new Dimension(55, 23));
		toggleButton4.setMaximumSize(new Dimension(55, 23));
		toggleButton4.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton4);

		button4.setText("text");
		panel8.add(button4);

		button5.setText("text");
		panel8.add(button5);

		toggleButton5.setText("text");
		toggleButton5.setPreferredSize(new Dimension(55, 23));
		toggleButton5.setMaximumSize(new Dimension(55, 23));
		toggleButton5.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton5);

		button6.setText("text");
		panel8.add(button6);

		toggleButton6.setText("text");
		toggleButton6.setPreferredSize(new Dimension(55, 23));
		toggleButton6.setMaximumSize(new Dimension(55, 23));
		toggleButton6.setMinimumSize(new Dimension(55, 23));
		panel8.add(toggleButton6);
		panel7.add(panel8);
		add(panel7, BorderLayout.EAST);
	}

}
