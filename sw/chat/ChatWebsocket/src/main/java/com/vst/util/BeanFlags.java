package com.vst.util;

public class BeanFlags {

	int id;
	Boolean conUsuario;
	Boolean conEstado;
	Boolean conAction;
	Boolean conBusqueda;
	Boolean copiado;

	public Boolean getCopiado() {
		return copiado;
	}

	public void setCopiado(Boolean copiado) {
		this.copiado = copiado;
	}

	public BeanFlags() {
	}

	public BeanFlags(Boolean conUsuario, Boolean conEstado, Boolean conAction, Boolean conBusqueda, Boolean copiado) {
		super();
		this.conUsuario = conUsuario;
		this.conEstado = conEstado;
		this.conAction = conAction;
		this.conBusqueda = conBusqueda;
		this.copiado = copiado;

	}

	public int getId() {
		return id;
	}

	public Boolean getConUsuario() {
		return conUsuario;
	}

	public Boolean getConEstado() {
		return conEstado;
	}

	public Boolean getConAction() {
		return conAction;
	}

	public Boolean getConBusqueda() {
		return conBusqueda;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setConUsuario(Boolean conUsuario) {
		this.conUsuario = conUsuario;
	}

	public void setConEstado(Boolean conEstado) {
		this.conEstado = conEstado;
	}

	public void setConAction(Boolean conAction) {
		this.conAction = conAction;
	}

	public void setConBusqueda(Boolean conBusqueda) {
		this.conBusqueda = conBusqueda;
	}

}