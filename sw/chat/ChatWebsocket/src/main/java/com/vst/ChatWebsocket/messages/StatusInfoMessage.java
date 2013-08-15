package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.Entitys.StatusInfo;
import com.vst.ChatWebsocket.Entitys.Usuario;


public class StatusInfoMessage {

	private StatusInfo statusInfo;

	public StatusInfoMessage(Usuario user, STATUS status, int sta) {
		this.statusInfo = new StatusInfo(user, status, sta);
	}

	public StatusInfo getStatusInfo() {
		return statusInfo;
	}

}
