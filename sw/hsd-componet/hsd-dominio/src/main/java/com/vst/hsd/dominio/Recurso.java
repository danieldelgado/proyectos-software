package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the recurso database table.
 * 
 */
@Entity
@Table(name = "recurso")
@Inheritance(strategy = InheritanceType.JOINED)
public class Recurso implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_recurso")
	private Integer id;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	/** The descripcion. */
	@Column(name = "descripcion", length = 250, nullable = false)
	private String descripcion;

	/** The estado. */
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	/** The fecha creacion. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	public String codigo;

	/*
	 * @ManyToMany(mappedBy="recursos") private List<Perfil> perfils;
	 */

	/**
	 * Instantiates a new recurso.
	 */
	public Recurso() {
	}

	/*
	 * public List<Perfil> getPerfils() { return perfils; }
	 * 
	 * 
	 * 
	 * public void setPerfils(List<Perfil> perfils) { this.perfils = perfils; }
	 */

	/**
	 * Instantiates a new recurso.
	 * 
	 * @param id
	 *            the id
	 * @param activo
	 *            the activo
	 * @param descripcion
	 *            the descripcion
	 * @param estado
	 *            the estado
	 * @param fechaActualizacion
	 *            the fecha actualizacion
	 * @param fechaCreacion
	 *            the fecha creacion
	 */
	public Recurso(Integer id, Boolean activo, String descripcion, Character estado, Date fechaActualizacion, Date fechaCreacion) {
		super();
		this.id = id;
		this.activo = activo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaActualizacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Instantiates a new recurso.
	 * 
	 * @param id
	 *            the id
	 */
	public Recurso(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Instantiates a new recurso.
	 * 
	 * @param id
	 *            the id
	 * @param activo
	 *            the activo
	 * @param estado
	 *            the estado
	 */
	public Recurso(Integer id, Boolean activo, Character estado) {
		super();
		this.id = id;
		this.activo = activo;
		this.estado = estado;
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
	 * Gets the estado.
	 * 
	 * @return the estado
	 */
	public Character getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 * 
	 * @param estado
	 *            the new estado
	 */
	public void setEstado(Character estado) {
		this.estado = estado;
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
	 * Gets the fecha creacion.
	 * 
	 * @return the fecha creacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Sets the fecha creacion.
	 * 
	 * @param fechaCreacion
	 *            the new fecha creacion
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

}