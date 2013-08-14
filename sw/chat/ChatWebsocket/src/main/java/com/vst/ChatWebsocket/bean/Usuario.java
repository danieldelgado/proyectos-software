package com.vst.ChatWebsocket.bean;

import java.util.List;

public class Usuario {

	private int id;
	private String userName;
	private String clave;
	private String nombre;
	private String apellido;
	private List<Conexion> listaConexionsid;
		
	public Usuario() {
		
	}
	
	public Usuario(int id, String userName, String clave, String nombre, String apellido) {
		super();
		this.id = id;
		this.userName = userName;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Conexion> getListaConexionsid() {
		return listaConexionsid;
	}

	public void setListaConexionsid(List<Conexion> listaConexionsid) {
		this.listaConexionsid = listaConexionsid;
	}

	

}
