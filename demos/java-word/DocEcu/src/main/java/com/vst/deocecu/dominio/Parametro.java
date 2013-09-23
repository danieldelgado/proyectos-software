package com.vst.deocecu.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vst.deocecu.util.Entidad;

@Entity
@Table(name = "Parametro")
public class Parametro implements Entidad{

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_parametro")
	private Integer id;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "key_parametro")
	private String key_parametro;
	
	@Column(name = "value_parametro")
	private String value_parametro; 

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaRegistro")
	private Date fechaRegistro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaActua")
	private Date fechaActua;

	
	public Parametro(){
		
	}

	


	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getKey_parametro() {
		return key_parametro;
	}




	public void setKey_parametro(String key_parametro) {
		this.key_parametro = key_parametro;
	}




	public String getValue_parametro() {
		return value_parametro;
	}




	public void setValue_parametro(String value_parametro) {
		this.value_parametro = value_parametro;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public Date getFechaRegistro() {
		return fechaRegistro;
	}




	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}




	public Date getFechaActua() {
		return fechaActua;
	}




	public void setFechaActua(Date fechaActua) {
		this.fechaActua = fechaActua;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}


	public Boolean getActivo() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

}
