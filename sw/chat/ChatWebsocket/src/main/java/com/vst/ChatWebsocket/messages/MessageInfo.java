package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class MessageInfo {

	private final Usuario from;

	private final Usuario to;

	private final String message;

	public MessageInfo(Usuario from, Usuario to, String message) {
		this.from = from;
		this.to = to;
		this.message = message;
	}

	public Usuario getFrom() {
		return from;
	}

	public Usuario getTo() {
		return to;
	}

	public String getMessage() {
		return message;
	}
}