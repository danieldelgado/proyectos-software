package com.vst.lie.main;

import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

import com.vst.lie.gui.impl.Principal;

public class FireMain {

	public static void main(String[] args) {
		// JXFrame.setDefaultLookAndFeelDecorated(true);
		// JXDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			@SuppressWarnings("deprecation")
			public void run() {
				SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
				Principal principal = new Principal("FI-RE");
				principal.show();
			}
		});
	}

}
