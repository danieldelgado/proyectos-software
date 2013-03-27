package pe.com.sf.re.fi.analisis.gui;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri Mar 22 05:55:23 CET 2013
 */



/**
 * @author SHOCKIE
 */
public class PanelCentral extends JPanel {
	public PanelCentral() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		label1 = new JLabel();
		spinner1 = new JSpinner();
		panel2 = new JPanel();
		splitPane1 = new JSplitPane();
		panel3 = new JPanel();
		progressBar1 = new JProgressBar();
		panel4 = new JPanel();
		progressBar2 = new JProgressBar();
		panel7 = new JPanel();
		panel8 = new JPanel();
		button2 = new JButton();
		button3 = new JButton();
		toggleButton1 = new JToggleButton();
		button1 = new JButton();
		toggleButton2 = new JToggleButton();
		toggleButton3 = new JToggleButton();
		toggleButton4 = new JToggleButton();
		button4 = new JButton();
		button5 = new JButton();
		toggleButton5 = new JToggleButton();
		button6 = new JButton();
		toggleButton6 = new JToggleButton();

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
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel panel1;
	private JPanel panel5;
	private JPanel panel6;
	private JLabel label1;
	private JSpinner spinner1;
	private JPanel panel2;
	private JSplitPane splitPane1;
	private JPanel panel3;
	private JProgressBar progressBar1;
	private JPanel panel4;
	private JProgressBar progressBar2;
	private JPanel panel7;
	private JPanel panel8;
	private JButton button2;
	private JButton button3;
	private JToggleButton toggleButton1;
	private JButton button1;
	private JToggleButton toggleButton2;
	private JToggleButton toggleButton3;
	private JToggleButton toggleButton4;
	private JButton button4;
	private JButton button5;
	private JToggleButton toggleButton5;
	private JButton button6;
	private JToggleButton toggleButton6;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
