package pruebas;

import java.io.File;

public class ValidateImpl implements Validate {

	public static String[] extensionesPermitidas = getExtensionesPermistidas();

	@Override
	public boolean validaExtensionArchivoImagen(File file) {
		String thisext = file.getName().substring(file.getName().lastIndexOf('.') + 1).toLowerCase();
		if (extensionesPermitidas.length > 0) {
			for (int i = 0; i < extensionesPermitidas.length; i++) {
				if (thisext.equals(extensionesPermitidas[i])) {
					return true;
				}
			}
		}
		return false;
	}

	private static String[] getExtensionesPermistidas() {
		String[] a = { "jpg", "jpeg", "png", "gif" };
		return a;
	}

}
