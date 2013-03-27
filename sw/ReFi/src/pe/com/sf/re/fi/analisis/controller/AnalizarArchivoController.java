package pe.com.sf.re.fi.analisis.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import pe.com.sf.re.fi.analisis.functions.AnalizarArchivoFunction;

public class AnalizarArchivoController {

	public static File[] files;
	public static Integer identifiador;
	public static AnalizarArchivoFunction analizarArchivoFunction ;
	public static List<BufferedImage> lstBufferedImages;
	
	static{
		analizarArchivoFunction = new AnalizarArchivoFunction();
	}
	
	public static File obtenerArchivo(String str, Boolean isFile) throws Exception{		
		File f = null;
		files = null;
		if(isFile){
			f = analizarArchivoFunction.obtenerArchivo(str);
			files = new File[1];		
			files[0] = f;
		}else{
			f = analizarArchivoFunction.obtenerDirectorio(str);	
			files = f.listFiles();	
		}	 
		soloArchivosLectura();	
		return f;
	}

	private static void soloArchivosLectura() {
		if(files!=null && files.length>0)	{
			List<File> f = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				File e = files[i];
				if(e.isFile() && e.canRead()){
					f.add(e);
				}			
			}	
			files  = f.toArray(new File[f.size()]);
			System.out.println("files:"+files.length);
		}	
	}

	public static File[] getFiles() {
		return files;
	}

	public static void setFiles(File[] files) {
		AnalizarArchivoController.files = files;
	}

	public static File getFileInteractor() {
		if(identifiador==null){
			identifiador = -1;
		} 
		identifiador++;		
		System.out.println("identifiador:"+identifiador+ "  files:"+files.length);
		return files[identifiador];
	}
	
	public static void identificadorReset(){
		identifiador = -1;
	}
	
	public static int cantidadArchivosInstanciados(){
		if(files!=null && files.length>0)		
			return files.length;
		return 0;
	}

	public static void agregarBufferImageList(BufferedImage readFile) {
		
	}
	
}
