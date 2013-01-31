package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the codigo_usuario database table.
 * 
 */
@Entity
@Table(name = "codigo_usuario")
public class CodigoUsuario extends Usuario implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The codigo. */
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;

	/**
	 * Instantiates a new codigo usuario.
	 */
	public CodigoUsuario() {
	}

	/* (non-Javadoc)
	 * @see com.vst.hsd.dominio.Usuario#getCodigo()
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/* (non-Javadoc)
	 * @see com.vst.hsd.dominio.Usuario#setCodigo(java.lang.String)
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}