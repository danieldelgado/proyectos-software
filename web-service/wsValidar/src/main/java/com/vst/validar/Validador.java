package com.vst.validar;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@SuppressWarnings("serial")
@XmlRootElement()
@XmlType(name = "Validador", propOrder = {"respuesta", "codigosErrors" })
public class Validador implements Serializable{

	int respuesta;
	
	List<Integer>  codigosErrors;

	public int getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(int respuesta) {
		this.respuesta = respuesta;
	}

	public List<Integer> getCodigosErrors() {
		return codigosErrors;
	}

	public void setCodigosErrors(List<Integer> codigosErrors) {
		this.codigosErrors = codigosErrors;
	}

	

	
	
	
	
}
