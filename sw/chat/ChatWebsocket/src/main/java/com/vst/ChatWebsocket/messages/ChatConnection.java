package com.vst.ChatWebsocket.messages;

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
import com.vst.ChatWebsocket.bean.Chat;
import com.vst.ChatWebsocket.bean.Conexion;
import com.vst.ChatWebsocket.bean.Usuario;
import com.vst.ChatWebsocket.service.ChatService;
import com.vst.ChatWebsocket.util.InstanstBeans;

public class ChatConnection extends MessageInbound {
	public static final Logger log = LoggerFactory.getLogger(ChatConnection.class);
	private ChatService chatService = null;
	private static final Map<String, ChatConnection> connections = new HashMap<String, ChatConnection>();
	
	public final Gson jsonProcessor;

	Usuario usuario = null;
	Conexion c = null;
	Chat chat = null;
	
	public ChatConnection(String connectionId, String userName, String origin) {
		this.jsonProcessor = new Gson();
		chatService = InstanstBeans.getChatService();
		usuario = new Usuario(chatService.getId(), userName, "234", userName, "a" + userName);
		c = new Conexion(chatService.getId(), connectionId, usuario);
		chatService.addConexion(c);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		sendConnectionInfo(outbound);
		sendStatusInfoToOtherUsers(new StatusInfoMessage(usuario.getUserName(), StatusInfoMessage.STATUS.CONNECTED));
		connections.put(c.getConnectionId(), this);
	}

	@Override
	protected void onClose(int status) {
		sendStatusInfoToOtherUsers(new StatusInfoMessage(usuario.getUserName(), StatusInfoMessage.STATUS.DISCONNECTED));
		connections.remove(c.getConnectionId());
		chatService.quitConexion(c);
	}

	@Override
	protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
		throw new UnsupportedOperationException("Binary messages not supported");
	}

	@Override
	protected void onTextMessage(CharBuffer charBuffer) throws IOException {
		final MessageInfoMessage message = jsonProcessor.fromJson(charBuffer.toString(), MessageInfoMessage.class);
		final ChatConnection destinationConnection = getDestinationUserConnection(message.getMessageInfo().getTo());
		if (destinationConnection != null) {
			final CharBuffer jsonMessage = CharBuffer.wrap(jsonProcessor.toJson(message));			
			chat = new  Chat(chatService.getCId(), c, usuario, chatService.obtenerConexionPorUsuario(usuario.getUserName()).getUsuario() , charBuffer.toString());
			destinationConnection.getWsOutbound().writeTextMessage(jsonMessage);
		} else {
			chat = new  Chat(chatService.getCId(), c, usuario, chatService.obtenerConexionPorUsuario(usuario.getUserName()).getUsuario() , "Se esta  intentando enviar un mensaje a un usuario no conectado");			
			log.warn("Se esta  intentando enviar un mensaje a un usuario no conectado");
		}
	}

	public String getUserName() {
		return usuario.getUserName();
	}

	public void sendConnectionInfo(WsOutbound outbound) {
		final List<String> activeUsers = getActiveUsers();
		final ConnectionInfoMessage connectionInfoMessage = new ConnectionInfoMessage(usuario.getUserName(), activeUsers);
		try {
			outbound.writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(connectionInfoMessage)));
		} catch (IOException e) {
			log.error("No se pudo enviar el mensaje", e);
		}
	}

	public List<String> getActiveUsers() {
		final List<String> activeUsers = new ArrayList<String>();
		for (ChatConnection connection : connections.values()) {
			activeUsers.add(connection.getUserName());
		}
		return activeUsers;
	}

	public void sendStatusInfoToOtherUsers(StatusInfoMessage message) {
		final Collection<ChatConnection> otherUsersConnections = getAllChatConnectionsExceptThis();
		for (ChatConnection connection : otherUsersConnections) {
			try {
				connection.getWsOutbound().writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(message)));
			} catch (IOException e) {
				log.error("No se pudo enviar el mensaje", e);
			}
		}
	}

	public Collection<ChatConnection> getAllChatConnectionsExceptThis() {
		final Collection<ChatConnection> allConnections = connections.values();
		allConnections.remove(this);
		return allConnections;
	}

	public ChatConnection getDestinationUserConnection(String destinationUser) {
		for (ChatConnection connection : connections.values()) {
			if (destinationUser.equals(connection.getUserName())) {
				return connection;
			}
		}
		return null;
	}


}