package com.autentia.tutorial.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Mensaje")
public class Mensaje implements Entidad {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_Mensaje")
	private Integer id;

	/** The fecha actualizacion. */
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaActualizacion")
	private Date fechaActualizacion;

	/** The fecha creacion. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "id_usuario_from")
	private Integer id_usuario_from;

	@Column(name = "id_usuario_to")
	private Integer id_usuario_to;
	
	@Column(name = "status")
	private String status;

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

	public Integer getId_usuario_from() {
		return id_usuario_from;
	}

	public void setId_usuario_from(Integer id_usuario_from) {
		this.id_usuario_from = id_usuario_from;
	}

	public Integer getId_usuario_to() {
		return id_usuario_to;
	}

	public void setId_usuario_to(Integer id_usuario_to) {
		this.id_usuario_to = id_usuario_to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
		
}
