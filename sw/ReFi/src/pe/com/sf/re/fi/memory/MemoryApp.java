package pe.com.sf.re.fi.memory;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemoryApp implements Serializable{

	private String ruta ;
	private String apariencia ;
	private Integer anchoPantalla;
	private Integer altoPantalla;
	
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
	public Integer getAnchoPantalla() {
		return anchoPantalla;
	}
	public void setAnchoPantalla(Integer anchoPantalla) {
		this.anchoPantalla = anchoPantalla;
	}
	public Integer getAltoPantalla() {
		return altoPantalla;
	}
	public void setAltoPantalla(Integer altoPantalla) {
		this.altoPantalla = altoPantalla;
	}

}
