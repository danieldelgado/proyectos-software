package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the lista database table.
 * 
 */
@Entity
@Table(name = "lista")
public class Lista extends Recurso implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The nombre. */
	@Column(name = "nombre", length = 250, nullable = false)
	private String nombre;

	/** The id menu. */
	@Column(name = "id_menu", length = 4, nullable = false)
	private Integer idMenu;

	/** The tabla. */
	@Column(name = "tabla", length = 40, nullable = false)
	private String tabla;

	/**
	 * Instantiates a new lista.
	 */
	public Lista() {
	}

	/**
	 * Instantiates a new lista.
	 *
	 * @param id the id
	 * @param codigo the codigo
	 * @param nombre the nombre
	 * @param tabla the tabla
	 * @param idMenu the id menu
	 */
	public Lista(Integer id, String codigo, String nombre, String tabla,
			Integer idMenu) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.tabla = tabla;
		this.idMenu = idMenu;
	}

	/**
	 * Gets the codigo.
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Sets the codigo.
	 *
	 * @param codigo the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
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
	 * Gets the id menu.
	 *
	 * @return the id menu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}

	/**
	 * Sets the id menu.
	 *
	 * @param idMenu the new id menu
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * Gets the tabla.
	 *
	 * @return the tabla
	 */
	public String getTabla() {
		return tabla;
	}

	/**
	 * Sets the tabla.
	 *
	 * @param tabla the new tabla
	 */
	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

}