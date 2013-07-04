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

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author FMANDROSP
 *
 */
public class ArchivoUtil {

	public static File enFile(String nombreArchivo, byte[] arreglo)  {
		if (TextoUtil.contieneAlgo(nombreArchivo) && arreglo!=null) {
			try {
				File archivo = new File(nombreArchivo);
				OutputStream flujoSalida;
				flujoSalida = new FileOutputStream(archivo);
				flujoSalida.write(arreglo);
				flujoSalida.close();
				return archivo;
			} catch (FileNotFoundException e) {
//				TraductorDeExcepciones.traducir(e);
			} catch (IOException e) {
//				TraductorDeExcepciones.traducir(e);
			}
		}
		return null;
	}

	public static byte[] enArregloByte(File archivo) {
		if (archivo != null) {
			try {
				InputStream flujoEntrada = new FileInputStream(archivo);
				int longitud = (int) archivo.length();
				byte[] arregloEntrada = new byte[longitud];
				flujoEntrada.read(arregloEntrada, 0, longitud);
				flujoEntrada.close();
				return arregloEntrada;
			} catch (FileNotFoundException e) {
//				TraductorDeExcepciones.traducir(e);
			} catch (IOException e) {
//				TraductorDeExcepciones.traducir(e);
			}
		}
		return null;
	}
	
	public static byte[] cargarImage(String rutaImagen) throws ImageFormatException, IOException {
		BufferedImage cargaImagen = loadImage(rutaImagen);
		return bufferedImageToByteArray(cargaImagen);
	}
	
	public static BufferedImage loadImage(String rutaImagen)throws IOException {
		BufferedImage bimg = null;
		try {
			bimg = ImageIO.read(new File(rutaImagen));
			//bimg = ImageIO.read(new File(new URL("file","172.33.15.40","D://repositorio//15-40628282-01.JPG").toURI()));
			//bimg = ImageIO.read(new File(new URL("file://////Z://3-40628282-15.JPG").toURI()));
			//bimg = ImageIO.read(new File("file://////Z://3-40628282-15.JPG"));
			//bimg = ImageIO.read(new File("C:\\15-40628282-01.JPG"));
			//bimg = ImageIO.read(new File("Z:\\172.33.15.40\\repositorio\\3-40628282-15.JPG"));
		} catch (IIOException e) {
//			TraductorDeExcepciones.traducir(e);
		}
		return bimg;
	}
	
	public static byte[] bufferedImageToByteArray(BufferedImage img) throws ImageFormatException, IOException{
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(img);
		return os.toByteArray();
	}
	
	public static byte[] guardarImagen(byte[] fileBytes, String filename, String repositorio) throws Exception {
		try {
			filename = new File(filename).getName();
			
			filename = repositorio + filename;
			FileOutputStream fileOut = new FileOutputStream(filename);
			fileOut.write(fileBytes, 0, fileBytes.length);
			fileOut.flush();
			fileOut.close();
			
		} catch (Exception e) {
//			TraductorDeExcepciones.traducir(e);
		}
		return fileBytes;
	}
	
	public static String obtenerNombreDeFile(String filename) {
		return filename = new File(filename).getName();
		
		/*String nombreArchivoImagenDeBD = imagenFoto; 
		//obetener el nombre del archivo de imagenes	
		int index = nombreArchivoImagenDeBD.lastIndexOf('/');
        String soloNombreDeImagen;
        if ( index >= 0) {
        	soloNombreDeImagen = nombreArchivoImagenDeBD.substring( index + 1 );
        } else {
            // Try backslash
            index = nombreArchivoImagenDeBD.lastIndexOf('\\');
            if (index >= 0) {
            	soloNombreDeImagen = nombreArchivoImagenDeBD.substring( index + 1 );
            } else {
                // No forward or back slashes
            	soloNombreDeImagen = nombreArchivoImagenDeBD;
            }
        }*/
		
	} 
	
}
