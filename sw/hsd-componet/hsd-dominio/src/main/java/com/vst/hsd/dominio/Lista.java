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

  
    public Lista() {
    }
    
   
    public Lista(Integer id,String codigo, String nombre, String tabla, Integer idMenu) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.tabla = tabla;
		this.idMenu = idMenu;
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

	
	
}