package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the boton_por_pagina database table.
 * 
 */
@Entity
@Table(name="columna_por_lista")
public class ColumnaPorLista implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ColumnaPorListaPK id;

    public ColumnaPorLista() {
    }

	public ColumnaPorListaPK getId() {
		return id;
	}

	public void setId(ColumnaPorListaPK id) {
		this.id = id;
	}

    

	
}