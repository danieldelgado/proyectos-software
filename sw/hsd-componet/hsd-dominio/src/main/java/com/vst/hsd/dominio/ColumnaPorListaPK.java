package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class ColumnaPorListaPK implements Serializable {
	// default serial version id, required for serializable classes.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The columna. */
	@ManyToOne
	@JoinColumn(name = "id_columna", nullable = false)
	private Columna columna;

	/** The lista. */
	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false)
	private Lista lista;

	/**
	 * Instantiates a new columna por lista pk.
	 */
	public ColumnaPorListaPK() {
	}

	/**
	 * Gets the columna.
	 *
	 * @return the columna
	 */
	public Columna getColumna() {
		return columna;
	}

	/**
	 * Sets the columna.
	 *
	 * @param columna the new columna
	 */
	public void setColumna(Columna columna) {
		this.columna = columna;
	}

	/**
	 * Gets the lista.
	 *
	 * @return the lista
	 */
	public Lista getLista() {
		return lista;
	}

	/**
	 * Sets the lista.
	 *
	 * @param lista the new lista
	 */
	public void setLista(Lista lista) {
		this.lista = lista;
	}

}