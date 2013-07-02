package com.vst.hsd.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.vst.util.Entidad;

@Entity
@Table(name = "Formulario")
public class Formulario extends Recurso implements Entidad {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "titulo", length = 50)
	private String titulo;
	
	@Column(name = "descripcion", length = 50)
	private String descripcion;
	
	public Formulario() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	

}
