package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.bean.Usuario;

public class MessageInfoMessage {

	private final MessageInfo messageInfo;

	public MessageInfoMessage(Usuario from, Usuario to, String message) {
		this.messageInfo = new MessageInfo(from, to, message);
	}

	public MessageInfo getMessageInfo() {
		return messageInfo;
	}

}
