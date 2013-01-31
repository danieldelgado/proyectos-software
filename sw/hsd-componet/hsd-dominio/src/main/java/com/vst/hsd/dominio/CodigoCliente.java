package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the codigo_cliente database table.
 * 
 */
@Entity
@Table(name = "codigo_cliente")
public class CodigoCliente extends Cliente implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/**
	 * Instantiates a new codigo cliente.
	 */
	public CodigoCliente() {
	}

	/* (non-Javadoc)
	 * @see com.vst.hsd.dominio.Cliente#getCodigo()
	 */
	public String getCodigo() {
		return this.codigo;
	}

}