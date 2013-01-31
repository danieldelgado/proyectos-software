package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "cliente")
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente extends Persona implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/** The estado civil. */
	@Column(name = "estado_civil", length = 1, nullable = false)
	private Integer estadoCivil;

	/** The ruc. */
	@Column(name = "ruc", length = 11, nullable = false)
	private String ruc;

	/** The tipo_documento. */
	@Column(name = "tipo_documento", length = 1, nullable = false)
	private Integer tipo_documento;

	/** The numero_documento. */
	@Column(name = "numero_documento", length = 12, nullable = false)
	private String numero_documento;

	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
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
	 * Gets the estado civil.
	 *
	 * @return the estado civil
	 */
	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * Sets the estado civil.
	 *
	 * @param estadoCivil the new estado civil
	 */
	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * Gets the ruc.
	 *
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * Sets the ruc.
	 *
	 * @param ruc the new ruc
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	/**
	 * Gets the tipo_documento.
	 *
	 * @return the tipo_documento
	 */
	public Integer getTipo_documento() {
		return tipo_documento;
	}

	/**
	 * Sets the tipo_documento.
	 *
	 * @param tipo_documento the new tipo_documento
	 */
	public void setTipo_documento(Integer tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	/**
	 * Gets the numero_documento.
	 *
	 * @return the numero_documento
	 */
	public String getNumero_documento() {
		return numero_documento;
	}

	/**
	 * Sets the numero_documento.
	 *
	 * @param numero_documento the new numero_documento
	 */
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

}