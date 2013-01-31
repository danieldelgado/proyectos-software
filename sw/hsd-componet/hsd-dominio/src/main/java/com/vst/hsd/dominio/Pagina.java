package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the pagina database table.
 * 
 */
@Entity
@Table(name = "pagina")
public class Pagina extends Recurso implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nombre. */
	private String nombre;

	/** The query string. */
	private String queryString;

	/** The titulo. */
	private String titulo;

	/** The url. */
	private String url;

	// bi-directional many-to-one association to Menu
	/** The menu. */
	@ManyToOne
	@JoinColumn(name = "id_menu_padre")
	private Menu menu;

	/**
	 * Instantiates a new pagina.
	 */
	public Pagina() {
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the query string.
	 *
	 * @return the query string
	 */
	public String getQueryString() {
		return this.queryString;
	}

	/**
	 * Sets the query string.
	 *
	 * @param queryString the new query string
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return this.titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the menu.
	 *
	 * @return the menu
	 */
	public Menu getMenu() {
		return this.menu;
	}

	/**
	 * Sets the menu.
	 *
	 * @param menu the new menu
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}