package pe.com.sf.re.fi.memory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

import pe.com.sf.re.fi.util.Constantes;

public class GuardarMemoryApp {

	private final static Logger _log = Logger.getLogger(GuardarMemoryApp.class.getName());

	public static void guardarMemoryApp(MemoryApp mapp) {
		_log.info(" guardarMemoryApp mapp:" + mapp);
		ObjectOutputStream out = null;
		FileOutputStream fos = null;
		try {
			File f = new File(Constantes.FILE_MemoryApp);
			if (f.exists()) {
				f.createNewFile();
			}
			fos = new FileOutputStream(new File(Constantes.FILE_MemoryApp));
			out = new ObjectOutputStream(fos);
			out.writeObject(mapp);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
