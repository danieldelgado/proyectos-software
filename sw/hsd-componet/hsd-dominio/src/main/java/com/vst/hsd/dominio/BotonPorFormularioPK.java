package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class BotonPorFormularioPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_formulario", nullable = false, insertable = false, updatable = false)
	private Formulario menu;

	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false, insertable = false, updatable = false)
	private Boton boton;

	
	public BotonPorFormularioPK() {
	}

	public Formulario getMenu() {
		return menu;
	}
	
	public void setMenu(Formulario menu) {
		this.menu = menu;
	}

	public Boton getBoton() {
		return boton;
	}

	public void setBoton(Boton boton) {
		this.boton = boton;
	}

}