package com.vst.ChatWebsocket.messages;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

import com.vst.ChatWebsocket.bean.Usuario;
import com.vst.ChatWebsocket.service.ChatService;
import com.vst.ChatWebsocket.util.InstanceConnectChat;
import com.vst.ChatWebsocket.util.InstanstBeans;

public class ConnectionChat extends MessageInbound {
	private ChatService chatService = null;
	private Usuario usuario ;
	
	public ConnectionChat(String connectionId, String userName, String origin) {
		chatService = InstanstBeans.getChatService();
		if(chatService.existeUsuario(userName)){
			usuario = chatService.getUsuario(userName);
		}else{
			usuario = new Usuario(chatService.getLastID(), userName, userName, userName, userName);
			chatService.guardar(usuario);
		}
		chatService.addUsuarioConectado(connectionId, origin, usuario);
		InstanceConnectChat.addConexion(connectionId, this);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		System.out.println("onOpen");
		System.out.println(outbound);
	}
	
	@Override
	protected void onClose(int status) {
		System.out.println("onClose status");
		System.out.println(status);
		
	}
	
	
	
	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		System.out.println("ByteBuffer");
		System.out.println(arg0);
	}

	@Override
	protected void onTextMessage(CharBuffer arg0) throws IOException {
		System.out.println("onTextMessage");
		System.out.println(arg0);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
	

}