package com.vst.ChatWebsocket.messages;

import java.util.List;

import com.vst.ChatWebsocket.bean.Usuario;

public class ConnectionInfo {

	private final String user;

	private final List<Usuario> activeUsers;

	public ConnectionInfo(String user, List<Usuario> activeUsers) {
		this.user = user;
		this.activeUsers = activeUsers;
	}

	public String getUser() {
		return user;
	}

	public List<Usuario> getActiveUsers() {
		return activeUsers;
	}
}