package com.vst.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.util.Entidad;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
public class Perfil implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_perfil")
	private Integer id;
	
	@Column(name="codigo",length=50,nullable=false)
	private String codigo;

	@Column(name="descripcion",length=250,nullable=false)
	private String descripcion;

	@Temporal( TemporalType.DATE)	 
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Column(name="estado",length=1,nullable=false)
	private Character estado;

	@Column(name="activo",nullable=false)
	private Boolean activo;
	

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

    @Column(name="nombre",length=100,nullable=false)
	private String nombre;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_por_perfil", joinColumns = { @JoinColumn(name = "id_perfil") }, inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
	private List<Usuario> usuarios;
	
	@ManyToMany
	@JoinTable(
		name="recurso_por_perfil"
		, joinColumns={
			@JoinColumn(name="perfil_id_perfil")
			}
		, inverseJoinColumns={
			@JoinColumn(name="recurso_id_recurso")
			}
		)
	private List<Recurso> recursos;
	
    public Perfil() {
    }

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String getLabel() {
		return null;
	}

	public String getNombreCompleto() {
		return null;
	}

	

	
}