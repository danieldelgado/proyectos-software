package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class StatusInfo {

	private final Usuario user;

	private final STATUS status;

	public StatusInfo(Usuario user, STATUS status) {
		this.user = user;
		this.status = status;
	}

	public Usuario getUser() {
		return user;
	}

	public STATUS getStatus() {
		return status;
	}
}