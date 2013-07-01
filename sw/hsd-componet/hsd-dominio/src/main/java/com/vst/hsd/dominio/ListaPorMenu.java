package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "lista_por_menu")
public class ListaPorMenu implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private ListaPorMenuPK id;

	/**
	 * Instantiates a new lista por pagina.
	 */
	public ListaPorMenu() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ListaPorMenuPK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ListaPorMenuPK id) {
		this.id = id;
	}

}