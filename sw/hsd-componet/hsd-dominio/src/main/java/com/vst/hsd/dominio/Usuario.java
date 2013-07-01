package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Persona implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The login. */
	@Column(name = "login", length = 50, nullable = false)
	private String login;

	/** The clave. */
	@Column(name = "clave", length = 50, nullable = false)
	private String clave;

	/** The estado civil. */
	@Column(name = "estado_civil", length = 1, nullable = false)
	private Integer estadoCivil;

	/** The ruc. */
	@Column(name = "ruc", length = 11)
	private String ruc;

	/** The tipo_documento. */
	@Column(name = "tipo_documento", length = 1, nullable = false)
	private Integer tipo_documento;

	/** The numero_documento. */
	@Column(name = "numero_documento", length = 12, nullable = false)
	private String numero_documento;

	/*
	 * @ManyToMany(mappedBy="usuarios",fetch = FetchType.EAGER) private
	 * List<Perfil> perfils;
	 */

	/*
	 * @JoinTable( name = "usuario_por_perfil", joinColumns = { @JoinColumn(name
	 * = "id_perfil") }, inverseJoinColumns = { @JoinColumn(name = "id_usuario")
	 * })
	 */

	/** The perfiles. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_por_perfil", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = { @JoinColumn(name = "id_perfil") })
	private List<Perfil> perfiles;

	/** The perfil logueado. */
	private transient Perfil perfilLogueado;

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
	}

	/**
	 * Instantiates a new usuario.
	 * 
	 * @param id
	 *            the id
	 * @param nombre
	 *            the nombre
	 * @param apellidos
	 *            the apellidos
	 * @param estado
	 *            the estado
	 * @param activo
	 *            the activo
	 * @param codigo
	 *            the codigo
	 * @param login
	 *            the login
	 * @param clave
	 *            the clave
	 */
	public Usuario(Integer id, String nombre, String apellidos, Character estado, Boolean activo, String codigo, String login, String clave) {
		super(id, nombre, apellidos, estado, activo);
		setCodigo(codigo);
		this.login = login;
		this.clave = clave;
	}

	/**
	 * Gets the login.
	 * 
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 * 
	 * @param login
	 *            the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the clave.
	 * 
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * Sets the clave.
	 * 
	 * @param clave
	 *            the new clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
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
	 * @param estadoCivil
	 *            the new estado civil
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
	 * @param ruc
	 *            the new ruc
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
	 * @param tipo_documento
	 *            the new tipo_documento
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
	 * @param numero_documento
	 *            the new numero_documento
	 */
	public void setNumero_documento(String numero_documento) {
		this.numero_documento = numero_documento;
	}

	/*
	 * public List<Perfil> getPerfils() { return perfils; }
	 * 
	 * 
	 * public void setPerfils(List<Perfil> perfils) { this.perfils = perfils; }
	 */

	/**
	 * Gets the perfiles.
	 * 
	 * @return the perfiles
	 */
	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	/**
	 * Sets the perfiles.
	 * 
	 * @param perfiles
	 *            the new perfiles
	 */
	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	/**
	 * Gets the perfil logueado.
	 * 
	 * @return the perfil logueado
	 */
	public Perfil getPerfilLogueado() {
		return perfilLogueado;
	}

	/**
	 * Sets the perfil logueado.
	 * 
	 * @param perfilLogueado
	 *            the new perfil logueado
	 */
	public void setPerfilLogueado(Perfil perfilLogueado) {
		this.perfilLogueado = perfilLogueado;
	}

}