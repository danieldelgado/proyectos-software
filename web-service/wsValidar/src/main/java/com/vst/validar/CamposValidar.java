package com.vst.validar;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.vst.util.Util;

@XmlRootElement 
@XmlType(name = "CamposValidar", propOrder = {"nombreCampo","entero","decimal","cadena","fecha","valorFormat","format"})   
public class CamposValidar  implements Serializable{
	
	String nombreCampo;

	Integer entero;
	
	double decimal;
	
	String cadena;
	
	Date fecha;
	
	String valorFormat;
	
	String format;
	
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
	public double getDecimal() {
		return decimal;
	}
	public void setDecimal(double decimal) {
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
	
	
	
}
