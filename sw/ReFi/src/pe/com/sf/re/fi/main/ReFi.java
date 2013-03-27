package pe.com.sf.re.fi.main;

import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXFrame;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

import pe.com.sf.re.fi.analisis.gui.Principal;
import pe.com.sf.re.fi.util.Propes;

public class ReFi {

	public static void main(String[] args) {
//		JXFrame.setDefaultLookAndFeelDecorated(true);
//		JXDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
				Principal principal = new Principal(Propes.getProperty("titulo"));
				principal.show();
			}
		});
	}

}
