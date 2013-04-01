package pe.com.sf.re.fi.memory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import pe.com.sf.re.fi.util.Constantes;

public class GuardarMemoryApp {

	
	public static void guardarMemoryApp(MemoryApp mapp){
		ObjectOutputStream out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(Constantes.FILE_MemoryApp);
			out = new ObjectOutputStream(fos);
			out.writeObject(mapp);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}

}
