package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "boton_por_pagina")
public class BotonPorPagina implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private BotonPorPaginaPK id;

	/**
	 * Instantiates a new boton por pagina.
	 */
	public BotonPorPagina() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public BotonPorPaginaPK getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(BotonPorPaginaPK id) {
		this.id = id;
	}

}