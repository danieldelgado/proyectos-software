package pe.com.sf.re.fi.util;

public class Constantes {

	public static String[] EXTENSIONES_IMAGENES = getExtensiones();
	public static String[] EXTENSIONES_ARCHIVOS_LECTURA = getExtensionesArchivos();

	private static String[] getExtensiones() {
		return Propes.getProperty("archivos.extension.imagenes").split(",") ;
	}
	
	private static String[] getExtensionesArchivos() {
		return Propes.getProperty("archivos.extension.archivos").split(",") ;
	}

}
