package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class StatusInfoMessage {

	private final StatusInfo statusInfo;

	public StatusInfoMessage(Usuario user, STATUS status) {
		this.statusInfo = new StatusInfo(user, status);
	}

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

}
