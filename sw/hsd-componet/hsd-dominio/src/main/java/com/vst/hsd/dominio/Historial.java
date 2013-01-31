package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.vst.util.Entidad;

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

	/** The clase. */
	@Column(name = "clase", length = 200)
	private String clase;

	/** The metodo. */
	@Column(name = "metodo", length = 200)
	private String metodo;

	/** The descripcion. */
	@Lob()
	@Column(name = "descripcion")
	private String descripcion;

	/** The valor. */
	@Lob()
	@Column(name = "valor")
	private String valor;

	/** The request. */
	@Lob()
	@Column(name = "request")
	private String request;

	/** The fecha registro. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;

	/** The persona_id. */
	@Column(name = "persona_id")
	private Integer persona_id;

	/**
	 * Instantiates a new historial.
	 */
	public Historial() {
	}

	/* (non-Javadoc)
	 * @see com.vst.util.Entidad#getId()
	 */
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
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
	 * @param descripcion the new descripcion
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
	 * @param request the new request
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
	 * @param codigo the new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Sets the fecha registro.
	 *
	 * @param fechaRegistro the new fecha registro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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
	 * Gets the clase.
	 *
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * Sets the clase.
	 *
	 * @param clase the new clase
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	/**
	 * Gets the metodo.
	 *
	 * @return the metodo
	 */
	public String getMetodo() {
		return metodo;
	}

	/**
	 * Sets the metodo.
	 *
	 * @param metodo the new metodo
	 */
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * Gets the persona_id.
	 *
	 * @return the persona_id
	 */
	public Integer getPersona_id() {
		return persona_id;
	}

	/**
	 * Sets the persona_id.
	 *
	 * @param persona_id the new persona_id
	 */
	public void setPersona_id(Integer persona_id) {
		this.persona_id = persona_id;
	}

	/* (non-Javadoc)
	 * @see com.vst.util.Entidad#getLabel()
	 */
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vst.util.Entidad#getNombreCompleto()
	 */
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

}