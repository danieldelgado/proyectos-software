package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "boton_por_formulario")
public class BotonPorFormulario implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private BotonPorFormularioPK id;

	/**
	 * Instantiates a new boton por pagina.
	 */
	public BotonPorFormulario() {
	}

	public BotonPorFormularioPK getId() {
		return id;
	}

	public void setId(BotonPorFormularioPK id) {
		this.id = id;
	}

	
	
}