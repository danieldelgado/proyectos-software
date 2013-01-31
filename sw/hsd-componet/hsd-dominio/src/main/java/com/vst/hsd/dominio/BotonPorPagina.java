package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name = "boton_por_pagina")
public class BotonPorPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BotonPorPaginaPK id;

	public BotonPorPagina() {
	}

	public BotonPorPaginaPK getId() {
		return this.id;
	}

	public void setId(BotonPorPaginaPK id) {
		this.id = id;
	}

}