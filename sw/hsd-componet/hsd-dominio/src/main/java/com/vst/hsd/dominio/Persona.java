package com.vst.hsd.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.vst.util.Entidad;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="persona")
public class Persona implements Entidad , Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator",
					table = "sequence_table", 
					pkColumnName = "sequence_name", 
					valueColumnName = "sequence_value")
	@Column(name="id_persona")
	private Integer id;

	@Temporal( TemporalType.DATE)
	@Column(name="fechaActualizacion")
	private Date fechaActualizacion;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal( TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="nombre",length=100,nullable=false)
	private String nombre;

	@Column(name="apellidos",length=100,nullable=false)
	private String apellidos;

	
	@Column(name="estado",length=1,nullable=false)
	private Character estado;

	@Column(name="activo",nullable=false)
	private Boolean activo;
	
	
    public Persona() {
    }

	
    


	public Persona(Integer id, String nombre, String apellidos, Character estado, Boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estado = estado;
		this.activo = activo;
	}





	public Persona(Date fechaActualizacion, Date fechaCreacion, Date fechaNacimiento, String nombre, String apellidos, Character estado,
			Boolean activo) {
		this.fechaActualizacion = fechaActualizacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.estado = estado;
		this.activo = activo;
	}





	public Boolean getActivo() {
		return activo;
	}





	public void setActivo(Boolean activo) {
		this.activo = activo;
	}





	public Character getEstado() {
		return estado;
	}





	public void setEstado(Character estado) {
		this.estado = estado;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}





	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}





	public Date getFechaCreacion() {
		return fechaCreacion;
	}





	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}





	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}





	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellidos() {
		return apellidos;
	}





	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getLabel() {
		return null;
	}



	public String getNombreCompleto() {
		return null;
	}
	
}