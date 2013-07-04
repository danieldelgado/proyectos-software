package com.vst.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Config {

	private static final Logger log = LoggerFactory.getLogger(Config.class);
	
	private static Properties propiedades;

	public static String getPropiedad(String propiedad) {
		log.debug("getPropiedad:"+propiedad);
		cargarConfiguracion();
		return propiedades.getProperty(propiedad);
	}

	public static int getPropiedadInt(String propiedad) {
		log.debug("getPropiedadInt:"+propiedad);
		cargarConfiguracion();
		String prop = propiedades.getProperty(propiedad);
		int valor = 0;
		if (prop != null)
			try {
				valor = Integer.parseInt(prop);
			} catch (NumberFormatException numberformatexception) {
			}
		return valor;
	}

	public static boolean getPropiedadBoolean(String propiedad) {
		log.debug("getPropiedadBoolean:"+propiedad);
		return getPropiedadBoolean(propiedad, false);
	}

	public static boolean getPropiedadBoolean(String propiedad, boolean porDefecto) {
		log.debug("getPropiedadBoolean:"+propiedad+" porDefecto:"+porDefecto);
		cargarConfiguracion();
		String prop = propiedades.getProperty(propiedad);
		if (prop != null) {
			prop = prop.trim();
			if (prop.equalsIgnoreCase("true") || prop.equalsIgnoreCase("yes") || prop.equalsIgnoreCase("verdad") || prop.equalsIgnoreCase("si"))
				return true;
		}
		return porDefecto;
	}

	private static void cargarConfiguracion() {
		cargarConfiguracion("");
	}

	public static void cargarConfiguracion(InputStream archivo) {
		log.debug("archivo:"+archivo);
		if (propiedades != null)
			return;
		if (archivo == null)
			throw new RuntimeException("No se pudo hallar el archivo de configuraci\363n.");
		try {
			propiedades = new Properties();
			propiedades.load(archivo);
			for (Enumeration<?> e = propiedades.propertyNames(); e.hasMoreElements();) {
				String key = (String) e.nextElement();
				String valor = interpolar(key, 1);
				if (valor != null)
					propiedades.setProperty(key, valor);
			}
		} catch (IOException ioe) {
			throw new RuntimeException("No se puede cargar la configuraci\363n.", ioe);
		}
	}

	@SuppressWarnings("resource")
	public static void cargarConfiguracion(String archivo) {
		log.debug("archivo:"+archivo);
		if (propiedades != null)
			return;
		String rutaArchivo = System.getProperty("chimera.configuracion");
		try {
			InputStream is;
			if (archivo != null && !archivo.equals("")) {
				is = new FileInputStream(archivo);
				// elArchivo = new File(archivo);
			} else if (rutaArchivo != null) {
				is = new FileInputStream(rutaArchivo);
				// elArchivo = new File(rutaArchivo);
			} else {
				is = Config.class.getResourceAsStream("/hsd.properties");
			}
			cargarConfiguracion(is);
		} catch (IOException ioe) {
			throw new RuntimeException("No se puede cargar la configuraci\363n.", ioe);
		}
	}

	private static String interpolar(String key, int nivel) {
		log.debug("interpolar key:"+key+" nivel:"+nivel);
		String valor = propiedades.getProperty(key);
		int desde = 0;
		StringBuffer resultado = null;
		int fin;
		for (; desde < valor.length(); desde = fin + 1) {
			int inicio = valor.indexOf("${", desde);
			if (inicio < 0)
				break;
			fin = valor.indexOf("}", inicio);
			if (fin < 0)
				break;
			String prop = valor.substring(inicio + 2, fin);
			if (resultado == null)
				resultado = new StringBuffer(valor.substring(desde, inicio));
			else
				resultado.append(valor.substring(desde, inicio));
			if (propiedades.containsKey(prop)) {
				String nValor = interpolar(prop, nivel + 1);
				if (nValor != null) {
					resultado.append(nValor);
					propiedades.setProperty(prop, nValor);
				} else {
					resultado.append(propiedades.getProperty(prop));
				}
			}
		}
		if (resultado != null && desde < valor.length())
			resultado.append(valor.substring(desde));
		return resultado != null ? resultado.toString() : null;
	}

}
