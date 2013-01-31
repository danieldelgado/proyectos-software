package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class ListaPorPaginaPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_pagina", nullable = false)
	private Pagina pagina;

	@ManyToOne
	@JoinColumn(name = "id_lista", nullable = false)
	private Lista lista;

	public ListaPorPaginaPK() {
	}

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

}