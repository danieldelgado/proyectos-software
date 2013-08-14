package com.vst.ChatWebsocket.bean;

public class Conexion {

	private String connectionId;
	private String origin;

	public Conexion(String connectionId, String origin) {
		this.connectionId = connectionId;
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

}
