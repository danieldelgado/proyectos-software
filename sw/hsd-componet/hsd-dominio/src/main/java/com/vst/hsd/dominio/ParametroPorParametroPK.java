package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The primary key class for the parametro_por_parametro database table.
 * 
 */
@Embeddable
public class ParametroPorParametroPK implements Serializable {
	// default serial version id, required for serializable classes.
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The parametro id parametro padre. */
	@Column(name = "parametro_id_parametro_padre")
	private int parametroIdParametroPadre;

	/** The parametro id parametro hijo. */
	@Column(name = "parametro_id_parametro_hijo")
	private int parametroIdParametroHijo;

	/**
	 * Instantiates a new parametro por parametro pk.
	 */
	public ParametroPorParametroPK() {
	}

	/**
	 * Instantiates a new parametro por parametro pk.
	 *
	 * @param idpadre the idpadre
	 * @param idhijo the idhijo
	 */
	public ParametroPorParametroPK(Integer idpadre, Integer idhijo) {
		parametroIdParametroPadre = idpadre;
		parametroIdParametroHijo = idhijo;
	}

	/**
	 * Gets the parametro id parametro padre.
	 *
	 * @return the parametro id parametro padre
	 */
	public int getParametroIdParametroPadre() {
		return this.parametroIdParametroPadre;
	}

	/**
	 * Sets the parametro id parametro padre.
	 *
	 * @param parametroIdParametroPadre the new parametro id parametro padre
	 */
	public void setParametroIdParametroPadre(int parametroIdParametroPadre) {
		this.parametroIdParametroPadre = parametroIdParametroPadre;
	}

	/**
	 * Gets the parametro id parametro hijo.
	 *
	 * @return the parametro id parametro hijo
	 */
	public int getParametroIdParametroHijo() {
		return parametroIdParametroHijo;
	}

	/**
	 * Sets the parametro id parametro hijo.
	 *
	 * @param parametroIdParametroHijo the new parametro id parametro hijo
	 */
	public void setParametroIdParametroHijo(int parametroIdParametroHijo) {
		this.parametroIdParametroHijo = parametroIdParametroHijo;
	}

}