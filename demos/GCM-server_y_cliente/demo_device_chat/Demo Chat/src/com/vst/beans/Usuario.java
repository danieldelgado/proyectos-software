package com.vst.beans;

public class Usuario {

	private Integer id;
	private String userName;
	private String clave;
	private String nombre;
	private String apellido;
	
	public Usuario() {
	}

	public Usuario(int id, String userName, String clave, String nombre, String apellido) {
		this.id = id;
		this.userName = userName;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Usuario(String userName, String clave, String nombre, String apellido) {
		this.userName = userName;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}