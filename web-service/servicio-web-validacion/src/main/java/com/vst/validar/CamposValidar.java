package com.vst.validar;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement 
@XmlType(name = "CamposValidar", propOrder = {
		"tipo","entidad","campo","valor","format","valid"
})   
public class CamposValidar  implements Serializable{
	

	String tipo;
	
	String entidad;
	
	String campo;
		
	String valor;		
	
	String format;	
	
	Boolean valid;
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public String getEntidad() {
		return entidad;
	}
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
