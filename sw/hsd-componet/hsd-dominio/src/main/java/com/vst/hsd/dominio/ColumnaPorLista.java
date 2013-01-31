package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "columna_por_lista")
public class ColumnaPorLista implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private ColumnaPorListaPK id;

	/**
	 * Instantiates a new columna por lista.
	 */
	public ColumnaPorLista() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ColumnaPorListaPK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ColumnaPorListaPK id) {
		this.id = id;
	}

}