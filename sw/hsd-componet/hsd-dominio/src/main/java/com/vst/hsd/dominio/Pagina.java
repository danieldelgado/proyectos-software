package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the pagina database table.
 * 
 */
@Entity
@Table(name = "pagina")
public class Pagina extends Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombre;

	private String queryString;

	private String titulo;

	private String url;

	// bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name = "id_menu_padre")
	private Menu menu;

	public Pagina() {
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getQueryString() {
		return this.queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}