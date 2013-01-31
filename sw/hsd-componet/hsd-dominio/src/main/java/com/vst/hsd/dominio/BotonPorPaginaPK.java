package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the boton_por_pagina database table.
 * 
 */
@Embeddable
public class BotonPorPaginaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="id_pagina", nullable=false)
	private Pagina pagina;
	
	@ManyToOne
	@JoinColumn(name="id_recurso", nullable=false)
	private Boton boton;

    public BotonPorPaginaPK() {
    }

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

	public Boton getBoton() {
		return boton;
	}

	public void setBoton(Boton boton) {
		this.boton = boton;
	}
	
    
    
    
}