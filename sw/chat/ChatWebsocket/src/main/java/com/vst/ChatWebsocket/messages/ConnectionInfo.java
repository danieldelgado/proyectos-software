package com.vst.ChatWebsocket.messages;

import java.util.List;

import com.vst.ChatWebsocket.bean.Usuario;

public class ConnectionInfo {

	private final Usuario user;

	private final List<Usuario> activeUsers;
	
	private final List<Usuario> activeUsersDesconectados;

//	public ConnectionInfo(Usuario user, List<Usuario> activeUsers) {
//		this.user = user;
//		this.activeUsers = activeUsers;
//	}

	public ConnectionInfo(Usuario usuario, List<Usuario> activeUsers, List<Usuario> activeUsersDesconectados) {
		this.user = usuario;
		this.activeUsers = activeUsers;
		this.activeUsersDesconectados = activeUsersDesconectados;
	}

	public Usuario getUser() {
		return user;
	}

	public List<Usuario> getActiveUsers() {
		return activeUsers;
	}

	public List<Usuario> getActiveUsersDesconectados() {
		return activeUsersDesconectados;
	}
	
	
	
}