package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class RecursoPorPerfilPK.
 */
@Embeddable
public class RecursoPorPerfilPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1133740396497094500L;

	/** The recurso. */
	@ManyToOne
	@JoinColumn(name = "id_recurso", nullable = false)
	private Recurso recurso;

	/** The perfil. */
	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = false)
	private Perfil perfil;

	/**
	 * Instantiates a new recurso por perfil pk.
	 */
	public RecursoPorPerfilPK() {
		super();
	}

	/**
	 * Instantiates a new recurso por perfil pk.
	 *
	 * @param recurso the recurso
	 * @param perfil the perfil
	 */
	public RecursoPorPerfilPK(Recurso recurso, Perfil perfil) {
		super();
		this.recurso = recurso;
		this.perfil = perfil;
	}

	/**
	 * Gets the recurso.
	 *
	 * @return the recurso
	 */
	public Recurso getRecurso() {
		return recurso;
	}

	/**
	 * Sets the recurso.
	 *
	 * @param recurso the new recurso
	 */
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	/**
	 * Gets the perfil.
	 *
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * Sets the perfil.
	 *
	 * @param perfil the new perfil
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((recurso == null) ? 0 : recurso.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecursoPorPerfilPK other = (RecursoPorPerfilPK) obj;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (recurso == null) {
			if (other.recurso != null)
				return false;
		} else if (!recurso.equals(other.recurso))
			return false;
		return true;
	}

}
