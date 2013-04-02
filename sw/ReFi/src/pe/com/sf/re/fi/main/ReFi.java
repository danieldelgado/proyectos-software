package pe.com.sf.re.fi.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXDialog;
import org.jdesktop.swingx.JXFrame;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

import pe.com.sf.re.fi.analisis.gui.Principal;
import pe.com.sf.re.fi.util.Propes;

public class ReFi {

	private final static Logger _log = Logger.getLogger(ReFi.class.getName());
	
	static{
		try{
			File logProperties = new File("logging.properties");
			FileInputStream fis = new FileInputStream(logProperties);			
		    LogManager.getLogManager().readConfiguration(fis);
			_log.info("Cargando Logging propeties");
		}
		catch (final IOException e){
		    Logger.getAnonymousLogger().severe("No encunetra el  logging.properties file");
		    Logger.getAnonymousLogger().severe(e.getMessage());
		}
	}	

	
	public static void main(String[] args) {
		_log.info("Corriendo Programa "+Propes.getProperty("titulo"));
//		DefaultLookAndFeelDecoratedif(){
		JXFrame.setDefaultLookAndFeelDecorated(true);
		JXDialog.setDefaultLookAndFeelDecorated(true);
//		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				_log.info("SubstanceLookAndFeel Default "+new BusinessBlackSteelSkin());
				SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
				new Principal(Propes.getProperty("titulo"));
			}
		});
	}

}
