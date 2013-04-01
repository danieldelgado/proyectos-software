package pe.com.sf.re.fi.memory;

import java.io.Serializable;

public class MemoryApp implements Serializable{

	private String ruta ;
	private String apariencia ;
	
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getApariencia() {
		return apariencia;
	}
	public void setApariencia(String apariencia) {
		this.apariencia = apariencia;
	}
	
	

}
