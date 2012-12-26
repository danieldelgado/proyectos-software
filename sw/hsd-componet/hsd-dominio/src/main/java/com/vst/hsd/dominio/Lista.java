package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

	@Column(name="codigo",length=50,nullable=false)
	private String codigo;

	@Column(name="nombre",length=250,nullable=false)
	private String nombre;

	@Column(name="id_menu",length=4,nullable=false)
	private Integer idMenu;

	@Column(name="tabla",length=40,nullable=false)
	private String tabla;

	@ManyToMany(fetch=FetchType.LAZY)
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

    @ManyToMany(fetch=FetchType.LAZY)
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
    
   
    public Lista(Integer id,String codigo, String nombre, String tabla) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.tabla = tabla;
	}

	public String getCodigo() {
		return codigo;
	}

	

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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