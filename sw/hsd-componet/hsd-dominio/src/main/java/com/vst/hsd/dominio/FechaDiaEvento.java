package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

import com.vst.util.Entidad;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the fecha_dia_eventos database table.
 * 
 */
@Entity
@Table(name = "fecha_dia_evento")
public class FechaDiaEvento implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_fecha_evento")
	private Integer id;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	/** The agrega. */
	@Column(name = "agrega", nullable = false)
	private Boolean agrega;

	/** The descripcion. */
	@Column(name = "descripcion", length = 250, nullable = false)
	private String descripcion;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	/** The fecha evento. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_evento", nullable = false)
	private Date fechaEvento;

	/** The fecha registro. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable = false)
	private Date fechaRegistro;

	/** The nombre. */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	/**
	 * Instantiates a new fecha dia evento.
	 */
	public FechaDiaEvento() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getId()
	 */
	public Integer getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#setId(java.lang.Integer)
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the activo.
	 * 
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * Sets the activo.
	 * 
	 * @param activo
	 *            the new activo
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/**
	 * Gets the agrega.
	 * 
	 * @return the agrega
	 */
	public Boolean getAgrega() {
		return agrega;
	}

	/**
	 * Sets the agrega.
	 * 
	 * @param agrega
	 *            the new agrega
	 */
	public void setAgrega(Boolean agrega) {
		this.agrega = agrega;
	}

	/**
	 * Gets the descripcion.
	 * 
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 * 
	 * @param descripcion
	 *            the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the fecha actualizacion.
	 * 
	 * @return the fecha actualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * Sets the fecha actualizacion.
	 * 
	 * @param fechaActualizacion
	 *            the new fecha actualizacion
	 */
	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * Gets the fecha evento.
	 * 
	 * @return the fecha evento
	 */
	public Date getFechaEvento() {
		return fechaEvento;
	}

	/**
	 * Sets the fecha evento.
	 * 
	 * @param fechaEvento
	 *            the new fecha evento
	 */
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/**
	 * Gets the fecha registro.
	 * 
	 * @return the fecha registro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Sets the fecha registro.
	 * 
	 * @param fechaRegistro
	 *            the new fecha registro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * @param nombre
	 *            the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getLabel()
	 */
	public String getLabel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getNombreCompleto()
	 */
	public String getNombreCompleto() {
		return null;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

}