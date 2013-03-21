package pruebas;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXFrame;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

import com.jgoodies.forms.factories.Borders;
import com.vst.lie.gui.impl.Principal;

public class PanelDePrueba extends JPanel {
	Principal mainFrame = null;

	public PanelDePrueba(Principal mainFrame) {
		initComponents();
		this.mainFrame = mainFrame;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Open Source Project license - unknown
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel6 = new JPanel();
		toggleButton1 = new JToggleButton();
		toggleButton2 = new JToggleButton();
		toggleButton3 = new JToggleButton();
		toggleButton4 = new JToggleButton();
		panel5 = new JPanel();
		label1 = new JLabel();
		comboBox1 = new JComboBox(new Vector(SubstanceLookAndFeel.getAllSkins().keySet()));
		separator1 = new JSeparator();
		panel4 = new JPanel();
		splitPane1 = new JSplitPane();
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel7 = new JPanel();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		progressBar1 = new JProgressBar();
		panel8 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		button5 = new JButton();
		button6 = new JButton();
		button7 = new JButton();
		button8 = new JButton();
		button9 = new JButton();
		button10 = new JButton();
		button11 = new JButton();
		button12 = new JButton();
		button13 = new JButton();
		button14 = new JButton();
		button15 = new JButton();
		button16 = new JButton();
		panel13 = new JPanel();
		scrollPane2 = new JScrollPane();
		table1 = new JTable();

		// ======== this ========
		setLayout(new BorderLayout());

		comboBox1.setSelectedIndex(-1);

		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				final Object item = evt.getItem();

				if (evt.getStateChange() == 1)
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
		});

		// ======== panel1 ========
		{
			panel1.setAlignmentX(2.0F);
			panel1.setMinimumSize(new Dimension(500, 50));
			panel1.setPreferredSize(new Dimension(500, 50));
			panel1.setBorder(Borders.DLU4_BORDER);
			panel1.setLayout(new BorderLayout());

			// ======== panel2 ========
			{
				panel2.setAlignmentX(0.6F);
				panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

				// ======== panel6 ========
				{
					panel6.setPreferredSize(new Dimension(10, 0));
					panel6.setLayout(new BorderLayout());
				}
				panel2.add(panel6);

				// ---- toggleButton1 ----
				toggleButton1.setText("text");
				panel2.add(toggleButton1);

				// ---- toggleButton2 ----
				toggleButton2.setText("text");
				panel2.add(toggleButton2);

				// ---- toggleButton3 ----
				toggleButton3.setText("text");
				panel2.add(toggleButton3);

				// ---- toggleButton4 ----
				toggleButton4.setText("text");
				panel2.add(toggleButton4);
			}
			panel1.add(panel2, BorderLayout.WEST);

			// ======== panel5 ========
			{
				panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

				// ---- label1 ----
				label1.setText("text");
				panel5.add(label1);

				panel5.add(comboBox1);
			}
			panel1.add(panel5, BorderLayout.EAST);
			panel1.add(separator1, BorderLayout.SOUTH);
		}
		add(panel1, BorderLayout.NORTH);

		// ======== panel4 ========
		{
			panel4.setLayout(new BorderLayout());

			// ======== splitPane1 ========
			{

				// ======== panel9 ========
				{
					panel9.setLayout(new FlowLayout());
				}
				splitPane1.setLeftComponent(panel9);

				// ======== panel10 ========
				{
					panel10.setLayout(new FlowLayout());
				}
				splitPane1.setRightComponent(panel10);
			}
			panel4.add(splitPane1, BorderLayout.CENTER);

			// ======== panel7 ========
			{
				panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));

				// ======== scrollPane1 ========
				{
					scrollPane1.setViewportView(list1);
				}
				panel7.add(scrollPane1);
				panel7.add(progressBar1);

				// ======== panel8 ========
				{
					panel8.setLayout(new FlowLayout());
				}
				panel7.add(panel8);
			}
			panel4.add(panel7, BorderLayout.WEST);

			// ======== panel11 ========
			{
				panel11.setLayout(new GridLayout(2, 1));

				// ======== panel12 ========
				{
					panel12.setLayout(new GridLayout(7, 2));

					// ---- button5 ----
					button5.setText("text");
					panel12.add(button5);

					// ---- button6 ----
					button6.setText("text");
					panel12.add(button6);

					// ---- button7 ----
					button7.setText("text");
					panel12.add(button7);

					// ---- button8 ----
					button8.setText("text");
					panel12.add(button8);

					// ---- button9 ----
					button9.setText("text");
					panel12.add(button9);

					// ---- button10 ----
					button10.setText("text");
					panel12.add(button10);

					// ---- button11 ----
					button11.setText("text");
					panel12.add(button11);

					// ---- button12 ----
					button12.setText("text");
					panel12.add(button12);

					// ---- button13 ----
					button13.setText("text");
					panel12.add(button13);

					// ---- button14 ----
					button14.setText("text");
					panel12.add(button14);

					// ---- button15 ----
					button15.setText("text");
					panel12.add(button15);

					// ---- button16 ----
					button16.setText("text");
					panel12.add(button16);
				}
				panel11.add(panel12);

				// ======== panel13 ========
				{
					panel13.setLayout(new FlowLayout());

					// ======== scrollPane2 ========
					{

						// ---- table1 ----
						table1.setPreferredSize(new Dimension(50, 32));
						table1.setPreferredScrollableViewportSize(new Dimension(100, 100));
						scrollPane2.setViewportView(table1);
					}
					panel13.add(scrollPane2);
				}
				panel11.add(panel13);
			}
			panel4.add(panel11, BorderLayout.EAST);
		}
		add(panel4, BorderLayout.CENTER);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	// Generated using JFormDesigner Open Source Project license - unknown
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel6;
	private JToggleButton toggleButton1;
	private JToggleButton toggleButton2;
	private JToggleButton toggleButton3;
	private JToggleButton toggleButton4;
	private JPanel panel5;
	private JLabel label1;
	private JComboBox comboBox1;
	private JSeparator separator1;
	private JPanel panel4;
	private JSplitPane splitPane1;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel7;
	private JScrollPane scrollPane1;
	private JList list1;
	private JProgressBar progressBar1;
	private JPanel panel8;
	private JPanel panel11;
	private JPanel panel12;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button14;
	private JButton button15;
	private JButton button16;
	private JPanel panel13;
	private JScrollPane scrollPane2;
	private JTable table1;
	// JFormDesigner - End of variables declaration //GEN-END:variables

}
