package com.vst.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the lista database table.
 * 
 */
@Entity
@Table(name="lista")
public class Lista  extends Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="codigo",length=10)
	private String codigo;

	@Column(name="descripcion",length=250)
	private String descripcion;

	@Column(name="id_menu",length=4)
	private Integer idMenu;

	@Column(name="tabla",length=40)
	private String tabla;

    @ManyToMany
	@JoinTable(
		name="columna_por_lista"
		, joinColumns={
			@JoinColumn(name="lista_id_recurso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="columna_id_columna")
			}
		)
	private List<Columna> columnas;

    @ManyToMany
	@JoinTable(
		name="lista_por_menu"
		, joinColumns={
			@JoinColumn(name="lista_id_recurso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_menu")
			}
		)
	private List<Menu> menus;
    
    public Lista() {
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public List<Columna> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<Columna> columnas) {
		this.columnas = columnas;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	

	
}