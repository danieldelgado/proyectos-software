package com.vst.ChatWebsocket.messages;

import java.util.List;

import com.vst.ChatWebsocket.bean.Usuario;

public class ConnectionInfoMessage {

	private final ConnectionInfo connectionInfo;

	public ConnectionInfoMessage(String user, List<Usuario> activeUsers) {
		this.connectionInfo = new ConnectionInfo(user, activeUsers);
	}

	public ConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}
}
