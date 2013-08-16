package com.vst.temp;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class ChatConnection extends MessageInbound {
	public static Logger log = LoggerFactory.getLogger(ChatConnection.class);
	private ChatService chatService = null;
	private static final Map<String, ChatConnection> connections = new HashMap<String, ChatConnection>();
	public Gson jsonProcessor;
	Usuario usuario = null;
	Conexion c = null;

	public ChatConnection(String connectionId, String userName, String origin) {
		this.jsonProcessor = new Gson();
		chatService = InstanstBeans.getChatService();
		if (!chatService.existeUsuario(userName)) {
			usuario = new Usuario(chatService.listaUsuarios().size() + 1, userName, userName, userName, userName);
			chatService.guardarUsuario(usuario);
		} else {
			usuario = chatService.getUsuario(userName);
		}
	
		c = new Conexion(connectionId, origin);
		c.setUser(usuario);
		chatService.guardarConexion(c);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		sendConnectionInfo(outbound);
		StatusInfoMessage statusInfoMessage = new StatusInfoMessage(usuario, STATUS.CONNECTED, -1);
		sendStatusInfoToOtherUsers(statusInfoMessage);
		chatService.guardarStatusInfo(statusInfoMessage.getStatusInfo());
		connections.put(c.getConnectionId(), this);
	}

	@Override
	protected void onClose(int status) {
		StatusInfoMessage statusInfoMessage = new StatusInfoMessage(usuario, STATUS.DISCONNECTED, status);
		sendStatusInfoToOtherUsers(statusInfoMessage);
		chatService.guardarStatusInfo(statusInfoMessage.getStatusInfo());
		connections.remove(c.getConnectionId());
	}

	@Override
	protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
		System.out.println("onBinaryMessage:" + byteBuffer);
		throw new UnsupportedOperationException("Binary messages not supported");
	}

	@Override
	protected void onTextMessage(CharBuffer charBuffer) throws IOException {
		MessageInfoMessage message = (MessageInfoMessage) obtenerObjetoJson(charBuffer, MessageInfoMessage.class);
		MessageInfo ms = message.getMessageInfo();
		ms.setFrom(chatService.getUsuario(ms.getFromuserName()));
		ms.setTo(chatService.getUsuario(ms.getTouserName()));
		ChatConnection destinationConnection = getDestinationUserConnection(message.getMessageInfo().getTo());
		if (destinationConnection != null) {
			sendMensaje(destinationConnection.getWsOutbound(), message);
			chatService.guardarMessageInfo(message.getMessageInfo());
		} else {
			log.warn("Se esta  intentando enviar un mensaje a un usuario no conectado");
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object obtenerObjetoJson(CharBuffer string, Class classObj) {
		return jsonProcessor.fromJson(string.toString(), classObj);
	}

	public String getUserName() {
		return usuario.getUserName();
	}

	public Usuario getUser() {
		return usuario;
	}

	public void sendConnectionInfo(WsOutbound outbound) {
		List<Usuario> activeUsers = getActiveUsers();
		List<Usuario> activeUsersDesconectados = getActiveUsersDesconectados();
		ConnectionInfoMessage connectionInfoMessage = new ConnectionInfoMessage(usuario, activeUsers, activeUsersDesconectados);
		try {
			sendMensaje(outbound, connectionInfoMessage);
//			chatService.guardarConnectionInfo(connectionInfoMessage.getConnectionInfo());
		} catch (IOException e) {
			log.error("No se pudo enviar el mensaje", e);
		}
	}

	private List<Usuario> getActiveUsersDesconectados() {
		List<Usuario> lusuariosDesc = new ArrayList<Usuario>();
		List<Usuario> lusuarios = chatService.listaUsuarios();
		System.out.println("usuario.getUserName():" + usuario.getUserName());
		boolean addDesconectado = false;
		for (Usuario u : lusuarios) {
			if (u.getUserName().equals(usuario.getUserName())) {
				continue;
			}
			addDesconectado = estaConectado(u);
			if (!addDesconectado) {
				lusuariosDesc.add(u);
			}
		}
		lusuarios = null;
		return lusuariosDesc;
	}

	private boolean estaConectado(Usuario u) {
		List<Usuario> lstUsuarioConectados = getActiveUsers();
		for (Usuario usuconec : lstUsuarioConectados) {
			if (u.getUserName().equals(usuconec.getUserName())) {
				return true;
			}
		}
		return false;
	}

	public List<Usuario> getActiveUsers() {
		List<Usuario> activeUsers = new ArrayList<Usuario>();
		for (ChatConnection connection : connections.values()) {
			activeUsers.add(connection.getUser());
		}
		return activeUsers;
	}

	public void sendStatusInfoToOtherUsers(StatusInfoMessage message) {
		chatService.guardarStatusInfo(message.getStatusInfo());
		Collection<ChatConnection> otherUsersConnections = getAllChatConnectionsExceptThis();
		for (ChatConnection connection : otherUsersConnections) {
			try {
				sendMensaje(connection.getWsOutbound(), message);
				chatService.guardarStatusInfo(message.getStatusInfo());
			} catch (IOException e) {
				log.error("No se pudo enviar el mensaje", e);
			}
		}
	}

	public void sendMensaje(WsOutbound wsOutbound, Object object) throws IOException {
		wsOutbound.writeTextMessage(CharBufferwrap(object));
	}

	public String toJson(Object obj) {
		return jsonProcessor.toJson(obj);
	}

	public CharBuffer CharBufferwrap(Object message) {
		return CharBuffer.wrap(toJson(message));
	}

	public Collection<ChatConnection> getAllChatConnectionsExceptThis() {
		Collection<ChatConnection> allConnections = connections.values();
		allConnections.remove(this);
		return allConnections;
	}

	public ChatConnection getDestinationUserConnection(Usuario destinationUser) {
		for (ChatConnection connection : connections.values()) {
			if (destinationUser.getUserName().equals(connection.getUserName())) {
				return connection;
			}
		}
		return null;
	}

}