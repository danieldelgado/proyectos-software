package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class BotonPorPaginaPK implements Serializable {
	// default serial version id, required for serializable classes.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pagina. */
	@ManyToOne
	@JoinColumn(name = "id_pagina", nullable = false)
	private Pagina pagina;

	/** The boton. */
	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false)
	private Boton boton;

	/**
	 * Instantiates a new boton por pagina pk.
	 */
	public BotonPorPaginaPK() {
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
	 * Gets the boton.
	 *
	 * @return the boton
	 */
	public Boton getBoton() {
		return boton;
	}

	/**
	 * Sets the boton.
	 *
	 * @param boton the new boton
	 */
	public void setBoton(Boton boton) {
		this.boton = boton;
	}

}