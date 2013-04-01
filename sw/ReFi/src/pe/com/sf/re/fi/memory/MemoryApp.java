package pe.com.sf.re.fi.memory;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemoryApp implements Serializable{

	private String ruta ;
	private String apariencia ;
	private int anchoPantalla;
	private int altoPantalla;
	
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
	public int getAnchoPantalla() {
		return anchoPantalla;
	}
	public int getAltoPantalla() {
		return altoPantalla;
	}
	public void setAnchoPantalla(int anchoPantalla) {
		this.anchoPantalla = anchoPantalla;
	}
	public void setAltoPantalla(int altoPantalla) {
		this.altoPantalla = altoPantalla;
	}
	
	

}
