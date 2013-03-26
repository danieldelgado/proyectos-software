package pruebas.serializablees;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompiladorMain1 {

	public CompiladorMain1() {
	}

	public static void main(String[] args) {
//		File a = new File("pruebaCompilador.java");
//		System.out.println(a.getAbsolutePath());
	    Process pro1 = null;
		try {
			pro1 = Runtime.getRuntime().exec("javac pruebaCompilador.java");
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			pro1.waitFor();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    Process pro2 = null;
		try {
			pro2 = Runtime.getRuntime().exec("java pruebaCompilador");
		} catch (IOException e) {
			e.printStackTrace();
		}

	    BufferedReader in = new BufferedReader(new InputStreamReader(pro2.getInputStream()));
	    String line = null;

	    try {
	    	System.out.println(" antes del while");
			while ((line = in.readLine()) != null) {
			    System.out.println(line);
			}
	    	System.out.println(" termino del while");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
