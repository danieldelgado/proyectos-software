/**
 * 
 */
package com.vst.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author FMANDROSP
 * 
 */
@SuppressWarnings("restriction")
public class ArchivoUtil {

	private static final Logger log = LoggerFactory.getLogger(ArchivoUtil.class);

	public static File enFile(String nombreArchivo, byte[] arreglo) throws FileNotFoundException, IOException {
		log.debug("File nombreArchivo:" + nombreArchivo);
		if (TextoUtil.contieneAlgo(nombreArchivo) && arreglo != null) {
			File archivo = new File(nombreArchivo);
			OutputStream flujoSalida;
			flujoSalida = new FileOutputStream(archivo);
			flujoSalida.write(arreglo);
			flujoSalida.close();
			return archivo;
		}
		return null;
	}

	public static byte[] enArregloByte(File archivo) throws FileNotFoundException, IOException {
		log.debug("byte[] archivo:" + archivo);
		if (archivo != null) {
			InputStream flujoEntrada = new FileInputStream(archivo);
			int longitud = (int) archivo.length();
			byte[] arregloEntrada = new byte[longitud];
			flujoEntrada.read(arregloEntrada, 0, longitud);
			flujoEntrada.close();
			return arregloEntrada;
		}
		return null;
	}

	public static byte[] cargarImage(String rutaImagen) throws ImageFormatException, IOException {
		log.debug("byte[] cargarImage:" + rutaImagen);
		BufferedImage cargaImagen = loadImage(rutaImagen);
		return bufferedImageToByteArray(cargaImagen);
	}

	public static BufferedImage loadImage(String rutaImagen) throws IOException {
		log.debug("BufferedImage loadImage:" + rutaImagen);
		BufferedImage bimg = null;
		bimg = ImageIO.read(new File(rutaImagen));
		// bimg = ImageIO.read(new File(new
		// URL("file","172.33.15.40","D://repositorio//15-40628282-01.JPG").toURI()));
		// bimg = ImageIO.read(new File(new
		// URL("file://////Z://3-40628282-15.JPG").toURI()));
		// bimg = ImageIO.read(new File("file://////Z://3-40628282-15.JPG"));
		// bimg = ImageIO.read(new File("C:\\15-40628282-01.JPG"));
		// bimg = ImageIO.read(new
		// File("Z:\\172.33.15.40\\repositorio\\3-40628282-15.JPG"));
		return bimg;
	}

	public static byte[] bufferedImageToByteArray(BufferedImage img) throws ImageFormatException, IOException {
		log.debug("BufferedImage img:" + img);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(img);
		return os.toByteArray();
	}

	public static byte[] guardarImagen(byte[] fileBytes, String filename, String repositorio) throws IOException {
		log.debug("BufferedImage filename:" + filename + " repositorio:" + repositorio + " fileBytes: " + fileBytes);
		filename = new File(filename).getName();
		filename = repositorio + filename;
		FileOutputStream fileOut = new FileOutputStream(filename);
		fileOut.write(fileBytes, 0, fileBytes.length);
		fileOut.flush();
		fileOut.close();
		return fileBytes;
	}

	public static String obtenerNombreDeFile(String filename) {
		log.debug("BufferedImage obtenerNombreDeFile:" + filename);
		return filename = new File(filename).getName();
		/*
		 * String nombreArchivoImagenDeBD = imagenFoto; //obetener el nombre del
		 * archivo de imagenes int index =
		 * nombreArchivoImagenDeBD.lastIndexOf('/'); String soloNombreDeImagen;
		 * if ( index >= 0) { soloNombreDeImagen =
		 * nombreArchivoImagenDeBD.substring( index + 1 ); } else { // Try
		 * backslash index = nombreArchivoImagenDeBD.lastIndexOf('\\'); if
		 * (index >= 0) { soloNombreDeImagen =
		 * nombreArchivoImagenDeBD.substring( index + 1 ); } else { // No
		 * forward or back slashes soloNombreDeImagen = nombreArchivoImagenDeBD;
		 * } }
		 */
	}

}
