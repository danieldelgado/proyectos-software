package com.vst.ChatWebsocket.bean;

public class Conexion {

	private int id;
	private String connectionId;
	private Usuario usuario;
	private String origin;
	public Conexion() {
		
	}
	
	public Conexion(int id, String connectionId, Usuario usuario) {
		super();
		this.id = id;
		this.connectionId = connectionId;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}




	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

	

}
