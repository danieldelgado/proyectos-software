package com.vst.android.beans;

import java.util.Date;


public class DispositivoMovil {

	private Integer id;
	
	private String key_device;

	private Boolean activo;
	
	private String numeromovil;
	
	private Date fecha_registro;
	
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
