package dasdtemp;

import java.util.List;



public class ConnectionInfo {

	private Usuario user;

	private List<Usuario> activeUsers;

	private List<Usuario> activeUsersDesconectados;

	// public ConnectionInfo(Usuario user, List<Usuario> activeUsers) {
	// this.user = user;
	// this.activeUsers = activeUsers;
	// }

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