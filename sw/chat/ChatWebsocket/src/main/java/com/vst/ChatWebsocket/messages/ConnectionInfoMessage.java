package com.vst.ChatWebsocket.messages;

import java.util.List;

import com.vst.ChatWebsocket.Entitys.Usuario;


public class ConnectionInfoMessage {

	private ConnectionInfo connectionInfo;

	// public ConnectionInfoMessage(Usuario user, List<Usuario> activeUsers) {
	// this.connectionInfo = new ConnectionInfo(user, activeUsers);
	// }

	public ConnectionInfoMessage(Usuario usuario, List<Usuario> activeUsers, List<Usuario> activeUsersDesconectados) {
		this.connectionInfo = new ConnectionInfo(usuario, activeUsers, activeUsersDesconectados);

	}

	public ConnectionInfo getConnectionInfo() {
		return connectionInfo;
	}
}
