package pruebas.serializablees;

public class PruebaCompilador {

	public PruebaCompilador() {
		
	}
	
	public String msg(String hola){
		return " hola  "+ hola;
	}

	
	public static void main(String[] args) {
		System.out.println(" hola mundo ");
		System.out.println(new PruebaCompilador().msg(" pruebas " ));
	}

}
