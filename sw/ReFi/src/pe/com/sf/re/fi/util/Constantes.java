package pe.com.sf.re.fi.util;

public class Constantes {

	public static int TIEMPO_INTERACION = 100;
	public static String LIMITE_LECTURA_BUFFER = Propes.getProperty("limite.archivos.memoria.lectura");
	public static String EXTENSIONES_CAD_IMAGENES = Propes.getProperty("archivos.extension.imagenes");
	public static String[] EXTENSIONES_IMAGENES = EXTENSIONES_CAD_IMAGENES.split(",");
	public static String EXTENSIONES_CAD_ARCHIVOS_LECTURA = Propes.getProperty("archivos.extension.archivos");
	public static String[] EXTENSIONES_ARCHIVOS_LECTURA = EXTENSIONES_CAD_ARCHIVOS_LECTURA.split(",");

}
