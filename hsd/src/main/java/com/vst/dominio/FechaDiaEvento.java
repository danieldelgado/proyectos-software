package com.vst.dominio;

import java.io.Serializable;
import javax.persistence.*;

import com.vst.util.Entidad;

import java.util.Date;


/**
 * The persistent class for the fecha_dia_eventos database table.
 * 
 */
@Entity
@Table(name="fecha_dia_evento")
public class FechaDiaEvento implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence", 
					pkColumnName = "sequence_recurso_name", 
					valueColumnName = "sequence_recurso_value")
	@Column(name="id_fecha_evento")
	private Integer id;

	@Column(name="activo")
	private Boolean activo;

	@Column(name="agrega")
	private Boolean agrega;

	@Column(name="descripcion",length=250)
	private String descripcion;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_evento")
	private Date fechaEvento;

    @Temporal( TemporalType.DATE)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

    @Column(name="nombre",length=100)
	private String nombre;

    public FechaDiaEvento() {
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

	public Boolean getAgrega() {
		return agrega;
	}

	public void setAgrega(Boolean agrega) {
		this.agrega = agrega;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLabel() {
		return null;
	}

	public String getNombreCompleto() {
		return null;
	}

    
    
}