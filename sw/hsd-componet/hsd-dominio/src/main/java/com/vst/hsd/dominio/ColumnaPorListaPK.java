package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class ColumnaPorListaPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_columna", nullable = false)
	private Columna columna;

	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false)
	private Lista lista;

	public ColumnaPorListaPK() {
	}

	public Columna getColumna() {
		return columna;
	}

	public void setColumna(Columna columna) {
		this.columna = columna;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

}