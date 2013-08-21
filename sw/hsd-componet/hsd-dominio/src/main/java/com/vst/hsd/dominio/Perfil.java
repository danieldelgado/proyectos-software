package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.persistence.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_perfil")
	private Integer id;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The descripcion. */
	@Column(name = "descripcion", length = 250, nullable = false)
	private String descripcion;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	/** The estado. */
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	/** The fecha creacion. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	/** The nombre. */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name = "usuario_por_perfil", joinColumns = { @JoinColumn(name
	 * = "id_perfil") }, inverseJoinColumns = { @JoinColumn(name = "id_usuario")
	 * }) private List<Usuario> usuarios;
	 */

	/*
	 * @ManyToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinTable( name="recurso_por_perfil" , joinColumns={
	 * 
	 * @JoinColumn(name="perfil_id_perfil") } , inverseJoinColumns={
	 * 
	 * @JoinColumn(name="recurso_id_recurso") } ) private List<Recurso>
	 * recursos;
	 */

	/**
	 * Instantiates a new perfil.
	 */
	public Perfil() {
	}

	/**
	 * Instantiates a new perfil.
	 * 
	 * @param id
	 *            the id
	 * @param codigo
	 *            the codigo
	 * @param nombre
	 *            the nombre
	 */
	public Perfil(Integer id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
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
	 * @param codigo
	 *            the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * public List<Usuario> getUsuarios() { return usuarios; }
	 * 
	 * public void setUsuarios(List<Usuario> usuarios) { this.usuarios =
	 * usuarios; }
	 */
	/*
	 * public List<Recurso> getRecursos() { return recursos; }
	 * 
	 * public void setRecursos(List<Recurso> recursos) { this.recursos =
	 * recursos; }
	 */

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