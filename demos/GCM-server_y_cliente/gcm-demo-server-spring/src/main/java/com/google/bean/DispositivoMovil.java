package com.google.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gcm.util.Entidad;

@Entity
@Table(name = "DispositivoMovil")
public class DispositivoMovil implements Entidad{
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id_Generator")
	@TableGenerator(name = "id_Generator", table = "sequence_table", pkColumnName = "sequence_name", valueColumnName = "sequence_value")
	@Column(name = "id_dispositivoMovil")
	private Integer id;
	
	@Column(name = "key_device")
	private String key_device;

	@Column(name = "activo", nullable=true)
	private Boolean activo;
	
	@Column(name = "numero_movil", nullable=true)
	private String numeromovil;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro", nullable=true)
	private Date fecha_registro;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", nullable=true)
	private Usuario usuario;


	
	public DispositivoMovil(Integer id, String key_device, Boolean activo,
			String numeromovil) {
		this.id = id;
		this.key_device = key_device;
		this.activo = activo;
		this.numeromovil = numeromovil;
	}

	
	public DispositivoMovil( String key_device, String numeromovil) {
		this.key_device = key_device;
		this.numeromovil = numeromovil;
	}

	public DispositivoMovil() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey_device() {
		return key_device;
	}

	public void setKey_device(String key_device) {
		this.key_device = key_device;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

	public String getNumeromovil() {
		return numeromovil;
	}

	public void setNumeromovil(String numeromovil) {
		this.numeromovil = numeromovil;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
