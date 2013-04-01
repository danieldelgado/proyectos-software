package pe.com.sf.re.fi.memory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import pe.com.sf.re.fi.util.Constantes;

public class LeerMemoryApp {
	
	static MemoryApp mapp = null;
	
	public static MemoryApp leerMemoryApp(){
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(Constantes.FILE_MemoryApp);
			in = new ObjectInputStream(fis);
			mapp =  (MemoryApp) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return mapp;
	}
	

}
