package pruebas;

import java.io.File;

public class pruebapixel {

	public static void main(String[] args) {
		String pathImage = "/home/daniel/Escritorio/modificado/pruibaImg.jpg";
		try {
			File fileImage = new File(pathImage);
			Validate a = new ValidateImpl();
			if (fileImage.isDirectory()) {
				throw new Exception("Es un directorio");
			} else if (!fileImage.canRead()) {
				throw new Exception("No se puede leer el archivo por permisos o no existe");
			} else if (fileImage.isHidden()) {
				throw new Exception("Es un archivo oculto");
			} else if (!fileImage.isFile()) {
				throw new Exception("No es un archivo");
			} else if (!a.validaExtensionArchivoImagen(fileImage)) {
				throw new Exception("Extension de archivo no valido");
			}
			System.out.println("fileImage:" + fileImage);

		} catch (Exception e) {
			System.out.println("e:" + e);
		}
	}

}
