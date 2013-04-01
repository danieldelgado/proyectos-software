package pe.com.sf.re.fi.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

import pe.com.sf.re.fi.analisis.gui.Principal;
import pe.com.sf.re.fi.util.Propes;

public class ReFi {

	static{
		try{
			FileInputStream fis = new FileInputStream(new File("logging.properties"));			
		    LogManager.getLogManager().readConfiguration(fis);
		}
		catch (final IOException e){
		    Logger.getAnonymousLogger().severe("No encunetra el  logging.properties file");
		    Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}
	
	
	public static void main(String[] args) {
//		JXFrame.setDefaultLookAndFeelDecorated(true);
//		JXDialog.setDefaultLookAndFeelDecorated(true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
				new Principal(Propes.getProperty("titulo"));
			}
		});
	}

}
