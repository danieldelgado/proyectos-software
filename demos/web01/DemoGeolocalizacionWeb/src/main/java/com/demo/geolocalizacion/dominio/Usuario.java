package com.demo.geolocalizacion.dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.demo.geolocalizacion.util.Entidad;

/**
 * The persistent class for the usuario database table.
 * 
 */
@XmlRootElement(name = "usuario")  
@XmlAccessorType(XmlAccessType.FIELD)  
//@XmlType(propOrder={"fechaNacimientoTransent"})
@Entity
@Table(name = "usuario" )
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Entidad, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	@XmlElement(name = "id",required=false)
	private Integer id;

	@Column(name = "nombres_completo", length = 100, nullable = false)
	@XmlElement(name = "nombresCompleto")
	private String nombresCompleto;

	@Column(name = "apellidos_completos", length = 100, nullable = false)
	@XmlElement(name = "apellidosCompletos")
	private String apellidosCompletos;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	@XmlElement(name = "fecha_registro",required=false)
	private Date fechaRegistro;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actualizacion")
	@XmlElement(name = "fechaActualizacion",required=false)
	private Date fechaActualizacion;

	// Para registrar telefono por web es con el registro [1990/10/10 00:00:00] no es lo mismo que en el web services
	@DateTimeFormat(pattern="dd/MM/yyyy hh:mm:ss") 
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	@XmlElement(name = "fecha_nacimiento",required=false)
	private Date fechaNacimiento;
	
//	public transient String fechaNacimientoTransent;
		
	public Usuario() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getApellidosCompletos() {
		return this.apellidosCompletos;
	}

	public void setApellidosCompletos(String apellidosCompletos) {
		this.apellidosCompletos = apellidosCompletos;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombresCompleto() {
		return this.nombresCompleto;
	}

	public void setNombresCompleto(String nombresCompleto) {
		this.nombresCompleto = nombresCompleto;
	}
	
//	public String getFechaNacimientoTransent() {
//		return fechaNacimientoTransent;
//	}
//
//	public void setFechaNacimientoTransent(String fechaNacimientoTransent) {
//		this.fechaNacimientoTransent = fechaNacimientoTransent;
//	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getNombreCompleto() {
		return null;
	}

}