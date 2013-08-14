package com.vst.ChatWebsocket.bean;

public class Conexion {

	private String connectionId;
	private String origin;
	private Usuario usuario;
	
	public Conexion() {
		
	}
	
	public Conexion(String connectionId, Usuario usuario) {
		this.connectionId = connectionId;
		this.usuario = usuario;
	}	
	
	public Conexion(String connectionId,String origin, Usuario usuario) {
		this.connectionId = connectionId;
		this.usuario = usuario;
		this.origin = origin;
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
