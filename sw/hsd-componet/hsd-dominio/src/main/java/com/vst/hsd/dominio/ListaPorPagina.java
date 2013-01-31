package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name="lista_por_pagina")
public class ListaPorPagina implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListaPorPaginaPK id;

    public ListaPorPagina() {
    }

	public ListaPorPaginaPK getId() {
		return id;
	}

	public void setId(ListaPorPaginaPK id) {
		this.id = id;
	}

	
	
}