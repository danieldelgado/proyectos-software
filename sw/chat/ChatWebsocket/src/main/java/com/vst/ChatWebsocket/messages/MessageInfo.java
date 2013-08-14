package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class MessageInfo {

	private Usuario from;
	private String fromuserName;
	private Usuario to;
	private String touserName;
	private String message;

	public MessageInfo(Usuario from, Usuario to, String message) {
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public Usuario getFrom() {
		return from;
	}

	public Usuario getTo() {
		if (to == null)
			to = new Usuario();
		return to;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getFromuserName() {
		return fromuserName;
	}

	public void setFromuserName(String fromuserName) {
		this.fromuserName = fromuserName;
	}

	public String getTouserName() {
		return touserName;
	}

	public void setTouserName(String touserName) {
		this.touserName = touserName;
	}

	public void setFrom(Usuario from) {
		this.from = from;
	}

	public void setTo(Usuario to) {
		this.to = to;
	}

}