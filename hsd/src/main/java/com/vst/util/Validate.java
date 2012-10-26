package com.vst.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	
	List<Integer> lstErrores; 
	
	Map objValidate=null;
	
	public Validate(Map objValidate) {
		this.objValidate = objValidate;
		lstErrores = new ArrayList<Integer>();
	}
		
	public void validar(){
		boolean bUsuario = validarUsuario(objValidate.get("usuario"),3,100,"Usuario","Admin","Administrador");
		boolean bClave = validarClave(objValidate.get("clave"),1,20,"format");
		boolean vPerfil = validarSelector(objValidate.get("perfil"),0);		
	}

	private boolean validarUsuario(Object object, int rangMin, int rangoMAx,String... str) {
		String u = String.valueOf(object);
		if(u!=null){			
				if(u!="" || !(u.equals(""))){					
					if( ( u.length() >= rangMin ) && ( u.length() <= rangMin ) ){						
						for (int i = 0; i < str.length; i++) {							
							if(!(str[i].equals(u))){
								return true;
							}							
						}						
					}					
				}			
		}		
		return false;
	}
	
	private boolean validarSelector(Object object, int rangMin,String... str) {
		Integer s = Integer.parseInt( String.valueOf(object) );
		if(s!=null){			
				if(s>rangMin){										
						for (int i = 0; i < str.length; i++) {							
							if(!(str[i].equals(s))){
								return true;
							}							
						}			
				}			
		}		
		return false;
	}

	private boolean validarClave(Object object, int rangMin, int rangoMAx,String... str) {
		String c = String.valueOf(object);
		if(c!=null){			
				if(c!="" || !(c.equals(""))){					
					if( ( c.length() >= rangMin ) && ( c.length() <= rangMin ) ){						
						Pattern r = Pattern.compile("(\\d)\\w{1,10}");
						Matcher m = r.matcher(c);
						return m.matches();
					}					
				}			
		}		
		return false;
	}


	public List<Integer> obtenerRepuesta() {
		return null;
	}
	
	/*
	 public static void main( String args[] ){

	      // String to be scanned to find the pattern.
		 
	      // Create a Pattern object
	      Pattern r = Pattern.compile("(\\d)\\w{1,10}");

	      // Now create matcher object.
	      Matcher m = r.matcher("1asa1a");
	      
	      System.out.println("matches(): "+m.matches());
	       
	   }
*/
}
