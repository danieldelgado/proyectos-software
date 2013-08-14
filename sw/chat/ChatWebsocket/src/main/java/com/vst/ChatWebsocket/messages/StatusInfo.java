package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class StatusInfo {

	private final Usuario user;

	private final STATUS status;

	private final int sta;

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