package com.vst.lie.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vst.lie.funciones.AnalizarArchivoFunction;

public class AnalizarArchivoController {

	public static File[] files;
	public static Integer identifiador;
	public static AnalizarArchivoFunction analizarArchivoFunction ;
	
	static{
		analizarArchivoFunction = new AnalizarArchivoFunction();
	}
	
	public static File obenerArchivo(String str, Boolean isFile) throws Exception{		
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
		limpiarRutasDeArchivos();	
		return f;
	}

	private static void limpiarRutasDeArchivos() {
		if(files!=null && files.length>0)	{
			List<File> f = new ArrayList<File>();
			for (int i = 0; i < files.length; i++) {
				File e = files[i];
				if(e.isFile() && e.canRead()){
					f.add(e);
				}			
			}	
			files  = f.toArray(new File[f.size()]);
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
			identifiador = 0;
		} 
		identifiador++;		
		return files[identifiador];
	}
	
	public static void identificadorReset(){
		identifiador = 0;
	}
	
	public static int cantidadArchivosInstanciados(){
		if(files!=null && files.length>0)		
			return files.length;
		return 0;
	}
	
}
