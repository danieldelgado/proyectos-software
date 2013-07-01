package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name = "parametro")
public class Parametro implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_parametro")
	private Integer id;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The nombre. */
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;

	/** The estado. */
	@Column(name = "estado", length = 1)
	private Character estado;

	/** The activo. */
	@Column(name = "activo")
	private Boolean activo;

	/** The tipo. */
	@Column(name = "tipo", length = 200)
	private String tipo;

	/** The valor. */
	@Column(name = "valor", length = 200)
	private String valor;

	/** The descripcion. */
	@Column(name = "descripcion", length = 250)
	private String descripcion;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	private Date fechaActualizacion;

	/** The fecha registro. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	/** The parametros. */
	private transient List<Parametro> parametros;

	/** The parametro por parametros padre. */
	private transient List<ParametroPorParametro> parametroPorParametrosPadre;

	/** The parametro por parametros hijo. */
	private transient List<ParametroPorParametro> parametroPorParametrosHijo;

	/**
	 * Instantiates a new parametro.
	 */
	public Parametro() {
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
	 * Gets the tipo.
	 * 
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the tipo.
	 * 
	 * @param tipo
	 *            the new tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Gets the valor.
	 * 
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 * 
	 * @param valor
	 *            the new valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
	 * Gets the parametros.
	 * 
	 * @return the parametros
	 */
	public List<Parametro> getParametros() {
		return parametros;
	}

	/**
	 * Sets the parametros.
	 * 
	 * @param parametros
	 *            the new parametros
	 */
	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	/**
	 * Gets the parametro por parametros padre.
	 * 
	 * @return the parametro por parametros padre
	 */
	public List<ParametroPorParametro> getParametroPorParametrosPadre() {
		return parametroPorParametrosPadre;
	}

	/**
	 * Sets the parametro por parametros padre.
	 * 
	 * @param parametroPorParametrosPadre
	 *            the new parametro por parametros padre
	 */
	public void setParametroPorParametrosPadre(List<ParametroPorParametro> parametroPorParametrosPadre) {
		this.parametroPorParametrosPadre = parametroPorParametrosPadre;
	}

	/**
	 * Gets the parametro por parametros hijo.
	 * 
	 * @return the parametro por parametros hijo
	 */
	public List<ParametroPorParametro> getParametroPorParametrosHijo() {
		return parametroPorParametrosHijo;
	}

	/**
	 * Sets the parametro por parametros hijo.
	 * 
	 * @param parametroPorParametrosHijo
	 *            the new parametro por parametros hijo
	 */
	public void setParametroPorParametrosHijo(List<ParametroPorParametro> parametroPorParametrosHijo) {
		this.parametroPorParametrosHijo = parametroPorParametrosHijo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getLabel()
	 */
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vst.util.Entidad#getNombreCompleto()
	 */
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

}