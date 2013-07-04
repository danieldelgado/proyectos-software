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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persona")
public class Persona implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_persona")
	private Integer id;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaActualizacion")
	private Date fechaActualizacion;

	/** The fecha creacion. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	/** The fecha nacimiento. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	/** The nombre. */
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	/** The apellidos. */
	@Column(name = "apellidos", length = 100, nullable = false)
	private String apellidos;

	/** The estado. */
	@Column(name = "estado", length = 1, nullable = false)
	private Character estado;

	/** The activo. */
	@Column(name = "activo", nullable = false)
	private Boolean activo;

	@Column(name = "codigo", length = 50, nullable = false)
	public String codigo;

	@Column(name = "telefono_fijo", length = 9)
	private String telefono_fijo;

	@Column(name = "celular", length = 11)
	private String celular;
	
	@Lob()	
	private  byte[] api_key;

	/**
	 * Instantiates a new persona.
	 */
	public Persona() {
	}

	/**
	 * Instantiates a new persona.
	 * 
	 * @param id
	 *            the id
	 * @param nombre
	 *            the nombre
	 * @param apellidos
	 *            the apellidos
	 * @param estado
	 *            the estado
	 * @param activo
	 *            the activo
	 */
	public Persona(Integer id, String nombre, String apellidos, Character estado, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estado = estado;
		this.activo = activo;
	}

	/**
	 * Instantiates a new persona.
	 * 
	 * @param fechaActualizacion
	 *            the fecha actualizacion
	 * @param fechaCreacion
	 *            the fecha creacion
	 * @param fechaNacimiento
	 *            the fecha nacimiento
	 * @param nombre
	 *            the nombre
	 * @param apellidos
	 *            the apellidos
	 * @param estado
	 *            the estado
	 * @param activo
	 *            the activo
	 */
	public Persona(Date fechaActualizacion, Date fechaCreacion, Date fechaNacimiento, String nombre, String apellidos, Character estado, Boolean activo) {
		this.fechaActualizacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estado = estado;
		this.activo = activo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTelefono_fijo() {
		return telefono_fijo;
	}

	public void setTelefono_fijo(String telefono_fijo) {
		this.telefono_fijo = telefono_fijo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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

	/**
	 * Gets the fecha nacimiento.
	 * 
	 * @return the fecha nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 * 
	 * @param fechaNacimiento
	 *            the new fecha nacimiento
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	/**
	 * Gets the apellidos.
	 * 
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 * 
	 * @param apellidos
	 *            the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public byte[] getApi_key() {
		return api_key;
	}

	public void setApi_key(byte[] api_key) {
		this.api_key = api_key;
	}

	
	
}