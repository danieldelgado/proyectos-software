package com.vst.ChatWebsocket.messages;

import com.vst.ChatWebsocket.Entitys.MessageInfo;
import com.vst.ChatWebsocket.Entitys.Usuario;


public class MessageInfoMessage {

	private MessageInfo messageInfo;

	public MessageInfoMessage(Usuario from, Usuario to, String message) {
		this.messageInfo = new MessageInfo(from, to, message);
	}

	public MessageInfo getMessageInfo() {
		return messageInfo;
	}

}
