package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class ListaPorPaginaPK implements Serializable {
	// default serial version id, required for serializable classes.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pagina. */
	@ManyToOne
	@JoinColumn(name = "id_pagina", nullable = false)
	private Pagina pagina;

	/** The lista. */
	@ManyToOne
	@JoinColumn(name = "id_lista", nullable = false)
	private Lista lista;

	/**
	 * Instantiates a new lista por pagina pk.
	 */
	public ListaPorPaginaPK() {
	}

	/**
	 * Gets the pagina.
	 *
	 * @return the pagina
	 */
	public Pagina getPagina() {
		return pagina;
	}

	/**
	 * Sets the pagina.
	 *
	 * @param pagina the new pagina
	 */
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
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