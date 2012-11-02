package com.vst.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;



/**
 * The persistent class for the recurso database table.
 * 
 */
@Entity
@Table(name="recurso")
@Inheritance(strategy=InheritanceType.JOINED)
public class Recurso implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_recurso")	
	private Integer id;

	@Column(name="activo",nullable=false)
	private Boolean activo;

	@Column(name="descripcion",length=250,nullable=false)
	private String descripcion;

	@Column(name="estado",length=1,nullable=false)
	private Character estado;


    @Temporal( TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@ManyToMany(mappedBy="recursos")
	private List<Perfil> perfils;



    public Recurso() {
    }



	public List<Perfil> getPerfils() {
		return perfils;
	}



	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Boolean getActivo() {
		return activo;
	}



	public void setActivo(Boolean activo) {
		this.activo = activo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public Character getEstado() {
		return estado;
	}



	public void setEstado(Character estado) {
		this.estado = estado;
	}



	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}



	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getLabel() {
		return null;
	}


	public String getNombreCompleto() {
		return null;
	}


	
	
}