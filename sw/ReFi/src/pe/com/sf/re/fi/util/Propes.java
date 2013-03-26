package pe.com.sf.re.fi.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propes {

	private static Properties properties = new Properties();

	static {
		cargarPorperties();
	}

	private static void cargarPorperties() {
		FileInputStream in;
		File a = new File("ReFi.properties");
		try {
			in = new FileInputStream(a);
			properties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
	
//	public static void main(String[] args) {
//		System.out.println(Propes.getProperty("dataBaseServer"));
//	}

}
