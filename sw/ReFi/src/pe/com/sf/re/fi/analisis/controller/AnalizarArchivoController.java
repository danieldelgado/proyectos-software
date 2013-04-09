package pe.com.sf.re.fi.analisis.controller;

import java.io.File;
import java.util.Map;
import java.util.logging.Logger;

import pe.com.sf.re.fi.analisis.functions.AnalizarArchivoFunction;

public class AnalizarArchivoController {

	public static Map<Integer, File> lstArchivos;
	public static AnalizarArchivoFunction analizarArchivoFunction = new AnalizarArchivoFunction();

	private final static Logger _log = Logger.getLogger(AnalizarArchivoController.class.getName());

	public static boolean extensionPermitida(File file) {
		_log.info(" evaluando extension  :" + file.getName());
		return analizarArchivoFunction.extensionPermitida(file);
	}

}
