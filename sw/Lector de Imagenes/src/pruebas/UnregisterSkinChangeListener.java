package pruebas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;
import org.pushingpixels.substance.api.skin.SkinChangeListener;
import org.pushingpixels.substance.api.skin.SkinInfo;

public class UnregisterSkinChangeListener extends JFrame {
	private SkinChangeListener listener;

	public UnregisterSkinChangeListener() {
		super("Register skin change listener");

		setLayout(new BorderLayout());

		JPanel panel = new JPanel(new FlowLayout());

		@SuppressWarnings("rawtypes")
		JComboBox cb = new JComboBox(new Vector(SubstanceLookAndFeel.getAllSkins().keySet()));

		cb.setSelectedIndex(-1);

		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				final Object item = evt.getItem();

				if (evt.getStateChange() == 1)
					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							try {
								SkinInfo skinInfo = (SkinInfo) SubstanceLookAndFeel.getAllSkins().get(item);

								SubstanceLookAndFeel.setSkin(skinInfo.getClassName());

								SwingUtilities.updateComponentTreeUI(UnregisterSkinChangeListener.this);
							} catch (Exception exc) {
							}
						}
					});
			}
		});
		panel.add(new JLabel("All skins:"));
		panel.add(cb);

		JPanel controls = new JPanel(new FlowLayout(2));
		final JButton unregisterListener = new JButton("Unregister listener");
		unregisterListener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						// UnregisterSkinChangeListener.2.this.val$unregisterListener.setEnabled(false);

						SubstanceLookAndFeel.unregisterSkinChangeListener(UnregisterSkinChangeListener.this.listener);
					}
				});
			}
		});
		controls.add(unregisterListener);
		add(controls, "South");

		add(panel, "Center");

		SubstanceLookAndFeel.registerSkinChangeListener(this.listener = new SkinChangeListener() {
			public void skinChanged() {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						JOptionPane.showMessageDialog(UnregisterSkinChangeListener.this, "Skin changed");
					}
				});
			}
		});
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
				new UnregisterSkinChangeListener().setVisible(true);
			}
		});
	}
}