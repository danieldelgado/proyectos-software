package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class BotonPorMenuPK implements Serializable {
	// default serial version id, required for serializable classes.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pagina. */
	@ManyToOne
	@JoinColumn(name = "id_menu", nullable = false, insertable=false, updatable=false)
	private Menu menu;

	/** The boton. */
	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false, insertable=false, updatable=false)
	private Boton boton;

	/**
	 * Instantiates a new boton por pagina pk.
	 */
	public BotonPorMenuPK() {
	}

	

	public Menu getMenu() {
		return menu;
	}



	public void setMenu(Menu menu) {
		this.menu = menu;
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