package com.vst.hsd.dominio;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RecursoPorPerfil.
 */
@Entity
@Table(name = "recurso_por_perfil")
public class RecursoPorPerfil implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7810555155845794831L;

	/** The id. */
	@EmbeddedId
	private RecursoPorPerfilPK id;

	/** The responsable. */
	private Boolean responsable;

	/**
	 * Gets the responsable.
	 *
	 * @return the responsable
	 */
	public Boolean getResponsable() {
		return responsable;
	}

	/**
	 * Sets the responsable.
	 *
	 * @param responsable the new responsable
	 */
	public void setResponsable(Boolean responsable) {
		this.responsable = responsable;
	}

	/**
	 * Instantiates a new recurso por perfil.
	 */
	public RecursoPorPerfil() {
		super();
	}

	/**
	 * Instantiates a new recurso por perfil.
	 *
	 * @param recurso the recurso
	 * @param perfil the perfil
	 */
	public RecursoPorPerfil(Recurso recurso, Perfil perfil) {
		id = new RecursoPorPerfilPK(recurso, perfil);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public RecursoPorPerfilPK getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(RecursoPorPerfilPK id) {
		this.id = id;
	}

}
