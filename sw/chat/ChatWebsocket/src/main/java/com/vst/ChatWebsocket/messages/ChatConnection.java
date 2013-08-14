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

	public ChatConnection(String connectionId, String userName, String origin) {
		this.jsonProcessor = new Gson();
		chatService = InstanstBeans.getChatService();
		if (!chatService.existeUsuario(userName)) {
			usuario = new Usuario(chatService.listaUsuarios().size() + 1, userName, userName, userName, userName);
		} else {
			usuario = chatService.getUsuario(userName);
		}
		List<Conexion> l = usuario.getListaConexionsid();
		if (l == null) {
			l = new ArrayList<Conexion>();
		}
		c = new Conexion(connectionId, origin);
		l.add(c);
		usuario.setListaConexionsid(l);
		chatService.guardarUsuario(usuario);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		sendConnectionInfo(outbound);
		StatusInfoMessage statusInfoMessage = new StatusInfoMessage(usuario, STATUS.CONNECTED);
		sendStatusInfoToOtherUsers(statusInfoMessage);
		chatService.guardarStatusInfo(statusInfoMessage.getStatusInfo());
		connections.put(c.getConnectionId(), this);
	}

	@Override
	protected void onClose(int status) {
		StatusInfoMessage statusInfoMessage = new StatusInfoMessage(usuario, STATUS.DISCONNECTED);
		sendStatusInfoToOtherUsers(statusInfoMessage);
		chatService.guardarStatusInfo(statusInfoMessage.getStatusInfo());
		connections.remove(c.getConnectionId());
	}

	@Override
	protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
		System.out.println("onBinaryMessage:"+byteBuffer);
		throw new UnsupportedOperationException("Binary messages not supported");
	}

	@Override
	protected void onTextMessage(CharBuffer charBuffer) throws IOException {
//		final MessageInfoMessage message = jsonProcessor.fromJson(charBuffer.toString(), MessageInfoMessage.class);
		final MessageInfoMessage message = (MessageInfoMessage)obtenerObjetoJson(charBuffer,MessageInfoMessage.class);
		final ChatConnection destinationConnection = getDestinationUserConnection(message.getMessageInfo().getTo());
		if (destinationConnection != null) {
//			final CharBuffer jsonMessage = CharBuffer.wrap(jsonProcessor.toJson(message));
//			final CharBuffer jsonMessage = CharBufferwrap(message);
//			destinationConnection.getWsOutbound().writeTextMessage(jsonMessage);			
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
		final List<Usuario> activeUsers = getActiveUsers();
		final ConnectionInfoMessage connectionInfoMessage = new ConnectionInfoMessage(usuario, activeUsers);
		try {
//			outbound.writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(connectionInfoMessage)));
			sendMensaje(outbound, connectionInfoMessage);
			chatService.guardarConnectionInfo(connectionInfoMessage.getConnectionInfo());
		} catch (IOException e) {
			log.error("No se pudo enviar el mensaje", e);
		}
	}

	public List<Usuario> getActiveUsers() {
		final List<Usuario> activeUsers = new ArrayList<Usuario>();
		for (ChatConnection connection : connections.values()) {
			activeUsers.add(connection.getUser());
		}
		return activeUsers;
	}

	public void sendStatusInfoToOtherUsers(StatusInfoMessage message) {
		chatService.guardarStatusInfo(message.getStatusInfo());
		final Collection<ChatConnection> otherUsersConnections = getAllChatConnectionsExceptThis();
		for (ChatConnection connection : otherUsersConnections) {
			try {
//				connection.getWsOutbound().writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(message)));
				sendMensaje(connection.getWsOutbound(), message);
				chatService.guardarStatusInfo(message.getStatusInfo());
			} catch (IOException e) {
				log.error("No se pudo enviar el mensaje", e);
			}
		}
	}

	public void sendMensaje(WsOutbound  wsOutbound, Object object) throws IOException{
		wsOutbound.writeTextMessage(CharBufferwrap(object));		
	}
	
	public String toJson(Object obj){
		return jsonProcessor.toJson(obj);		
	}
	
	public CharBuffer CharBufferwrap(Object message){
		return CharBuffer.wrap(toJson(message));
	}
	
	public Collection<ChatConnection> getAllChatConnectionsExceptThis() {
		final Collection<ChatConnection> allConnections = connections.values();
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