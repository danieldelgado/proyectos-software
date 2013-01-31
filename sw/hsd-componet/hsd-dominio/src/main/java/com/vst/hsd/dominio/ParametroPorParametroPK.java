package com.vst.hsd.dominio;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the parametro_por_parametro database table.
 * 
 */
@Embeddable
public class ParametroPorParametroPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "parametro_id_parametro_padre")
	private int parametroIdParametroPadre;

	@Column(name = "parametro_id_parametro_hijo")
	private int parametroIdParametroHijo;

	public ParametroPorParametroPK() {
	}

	public ParametroPorParametroPK(Integer idpadre, Integer idhijo) {
		parametroIdParametroPadre = idpadre;
		parametroIdParametroHijo = idhijo;
	}

	public int getParametroIdParametroPadre() {
		return this.parametroIdParametroPadre;
	}

	public void setParametroIdParametroPadre(int parametroIdParametroPadre) {
		this.parametroIdParametroPadre = parametroIdParametroPadre;
	}

	public int getParametroIdParametroHijo() {
		return parametroIdParametroHijo;
	}

	public void setParametroIdParametroHijo(int parametroIdParametroHijo) {
		this.parametroIdParametroHijo = parametroIdParametroHijo;
	}

}