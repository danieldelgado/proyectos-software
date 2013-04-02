package pe.com.sf.re.fi.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

import pe.com.sf.re.fi.analisis.gui.Principal;
import pe.com.sf.re.fi.util.Constantes;

public class LeerMemoryApp {
	private final static Logger _log = Logger.getLogger(LeerMemoryApp.class.getName());
		
	public static MemoryApp leerMemoryApp(){
		_log.info("cargando temporales...");
		MemoryApp mapp = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			File f= new File(Constantes.FILE_MemoryApp);
			if(f.exists()){
				fis = new FileInputStream(f);
				in = new ObjectInputStream(fis);
				mapp =  (MemoryApp) in.readObject();
				in.close();
			}		
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return mapp;
	}
	

}
