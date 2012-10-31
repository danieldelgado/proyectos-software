package com.vst.validar;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement 
@XmlType(name = "CamposValidar", propOrder = {"nombreCampo","entero","decimal","cadena","fecha","valorFormat","format","tipo","valid"})   
public class CamposValidar  implements Serializable{
	
	String nombreCampo;

	Integer tipo;
	
	Integer entero;
	
	Double decimal;
	
	String cadena;
	
	Date fecha;
	
	String valorFormat;
	
	String format;
	
	Boolean valid;
	
	public String getNombreCampo() {
		return nombreCampo;
	}
	public void setNombreCampo(String nombreCampo) {
		this.nombreCampo = nombreCampo;
	}
	public Integer getEntero() {
		return entero;
	}
	public void setEntero(Integer entero) {
		this.entero = entero;
	}
	public Double getDecimal() {
		return decimal;
	}
	public void setDecimal(Double decimal) {
		this.decimal = decimal;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getValorFormat() {
		return valorFormat;
	}
	public void setValorFormat(String valorFormat) {
		this.valorFormat = valorFormat;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public Integer getTipo() {
		return tipo;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
	
	
}
