package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the parametro_por_parametro database table.
 * 
 */
@Entity
@Table(name = "parametro_por_parametro")
public class ParametroPorParametro implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@EmbeddedId
	private ParametroPorParametroPK id;

	/** The orden. */
	@Column(name = "orden", nullable = false)
	private Integer orden;

	// bi-directional many-to-one association to Parametro
	/** The parametro padre. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parametro_id_parametro_padre", insertable = false, updatable = false)
	private Parametro parametroPadre;

	// bi-directional many-to-one association to Parametro
	/** The parametro hijo. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parametro_id_parametro_hijo", insertable = false, updatable = false)
	private Parametro parametroHijo;

	/**
	 * Instantiates a new parametro por parametro.
	 *
	 * @param idpadre the idpadre
	 * @param idhijo the idhijo
	 */
	public ParametroPorParametro(Integer idpadre, Integer idhijo) {
		id = new ParametroPorParametroPK(idpadre, idhijo);
	}

	/**
	 * Instantiates a new parametro por parametro.
	 */
	public ParametroPorParametro() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public ParametroPorParametroPK getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(ParametroPorParametroPK id) {
		this.id = id;
	}

	/**
	 * Gets the parametro padre.
	 *
	 * @return the parametro padre
	 */
	public Parametro getParametroPadre() {
		return parametroPadre;
	}

	/**
	 * Sets the parametro padre.
	 *
	 * @param parametroPadre the new parametro padre
	 */
	public void setParametroPadre(Parametro parametroPadre) {
		this.parametroPadre = parametroPadre;
	}

	/**
	 * Gets the parametro hijo.
	 *
	 * @return the parametro hijo
	 */
	public Parametro getParametroHijo() {
		return parametroHijo;
	}

	/**
	 * Sets the parametro hijo.
	 *
	 * @param parametroHijo the new parametro hijo
	 */
	public void setParametroHijo(Parametro parametroHijo) {
		this.parametroHijo = parametroHijo;
	}

	/**
	 * Gets the orden.
	 *
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * Sets the orden.
	 *
	 * @param orden the new orden
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

}