package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "boton_por_menu")
public class BotonPorMenu implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private BotonPorMenuPK id;

	/**
	 * Instantiates a new boton por pagina.
	 */
	public BotonPorMenu() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public BotonPorMenuPK getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(BotonPorMenuPK id) {
		this.id = id;
	}

}