package com.vst.util;

import java.io.Serializable;
import java.util.List;

public class ValidateMap implements Serializable {

	String atributo;
	String value;
	Object var;
	List lstValues;
	
	public String getAtributo() {
		return atributo;
	}
	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Object getVar() {
		return var;
	}
	public void setVar(Object var) {
		this.var = var;
	}
	public List getLstValues() {
		return lstValues;
	}
	public void setLstValues(List lstValues) {
		this.lstValues = lstValues;
	}
	
	
	
	
}
