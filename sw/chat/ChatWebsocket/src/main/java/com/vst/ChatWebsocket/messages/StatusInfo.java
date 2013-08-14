package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class StatusInfo {

	private Usuario user;

	private STATUS status;

	private int sta;

	public StatusInfo(Usuario user, STATUS status, int sta) {
		this.user = user;
		this.status = status;
		this.sta = sta;
	}

	public int getSta() {
		return sta;
	}

	public Usuario getUser() {
		return user;
	}

	public STATUS getStatus() {
		return status;
	}
}