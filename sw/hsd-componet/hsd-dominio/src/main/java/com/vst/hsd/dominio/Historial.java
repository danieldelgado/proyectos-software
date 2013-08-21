package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.vst.util.persistence.Entidad;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@Table(name = "historial")
public class Historial implements Entidad, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_historial")
	private Integer id;

	/** The codigo. */
	@Column(name = "codigo", length = 50)
	private String codigo;

	/** The codigo. */
	@Column(name = "objeto_json", length = 500)
	private String objeto_json;

	/** The descripcion. */
	@Lob()
	@Column(name = "descripcion")
	private String descripcion;

	/** The request. */
	@Lob()
	@Column(name = "request")
	private String request;

	/** The fecha registro. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	/**
	 * Instantiates a new historial.
	 */
	public Historial() {
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
	 * Gets the request.
	 * 
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * Sets the request.
	 * 
	 * @param request
	 *            the new request
	 */
	public void setRequest(String request) {
		this.request = request;
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
	 * Sets the fecha registro.
	 * 
	 * @param fechaRegistro
	 *            the new fecha registro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getObjeto_json() {
		return objeto_json;
	}

	public void setObjeto_json(String objeto_json) {
		this.objeto_json = objeto_json;
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

	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}

}