package pe.com.sf.re.fi.analisis.functions;

import java.io.File;

public class AnalizarArchivoFunction {

	@SuppressWarnings("unused")
	public  File obtenerArchivo(String path) throws NullPointerException {
		if (path != null && path.equals("")) {
			throw new NullPointerException(" El archivo no existe. 1");
		}
		File archivo = new File(path);
		if (archivo == null) {
			throw new NullPointerException(" El archivo no existe. 2");
		} else if (!archivo.exists()) {
			throw new NullPointerException(" El archivo no existe. 3");
		}else if (archivo.isDirectory()) {
			throw new NullPointerException(" Es un Directorio ");
		} else if (archivo.isHidden()) {
			throw new NullPointerException(" Es un archivo oculto");
		} else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer 1");
		} else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer 2 ");
		}else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer 3");
		}else if ( archivo.isFile()) {
			return archivo;
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	public  File obtenerDirectorio(String path) throws NullPointerException {
		if (path != null && path.equals("")) {
			throw new NullPointerException(" El archivo no existe. ");
		}
		File archivo = new File(path);
		if (archivo == null) {
			throw new NullPointerException(" El archivo no existe. ");
		} else if (archivo.isFile()) {
			throw new NullPointerException(" Es un Directorio ");
		} else if (archivo.isHidden()) {
			throw new NullPointerException(" Es un archivo oculto");
		} else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer");
		} else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer");
		}else if ( !archivo.canRead()) {
			throw new NullPointerException(" No se puede leer");
		}else if ( archivo.isDirectory()) {
			return archivo;
		}
		return null;
	}

}
