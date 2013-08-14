package com.vst.ChatWebsocket.bean;

public class Chat {

	private int id;
	private Conexion id_conexion;
	private Usuario id_usuario_from;
	private Usuario id_usuario_to;
//	private String origenConexion;
	private String mensaje;
		
	public Chat(int id, Conexion id_conexion, Usuario id_usuario_from, Usuario id_usuario_to, String mensaje) {
		super();
		this.id = id;
		this.id_conexion = id_conexion;
		this.id_usuario_from = id_usuario_from;
		this.id_usuario_to = id_usuario_to;
		this.mensaje = mensaje;
	}
	
	
	public Chat() {
	}

	public Chat(int cId, Conexion c, Usuario usuario, String userName, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getOrigenConexion() {
//		return origenConexion;
//	}
//
//	public void setOrigenConexion(String origenConexion) {
//		this.origenConexion = origenConexion;
//	}

	public Conexion getId_conexion() {
		return id_conexion;
	}

	public void setId_conexion(Conexion id_conexion) {
		this.id_conexion = id_conexion;
	}

	public Usuario getId_usuario_from() {
		return id_usuario_from;
	}

	public void setId_usuario_from(Usuario id_usuario_from) {
		this.id_usuario_from = id_usuario_from;
	}

	public Usuario getId_usuario_to() {
		return id_usuario_to;
	}

	public void setId_usuario_to(Usuario id_usuario_to) {
		this.id_usuario_to = id_usuario_to;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

}
