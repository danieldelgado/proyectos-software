package com.vst.ChatWebsocket.messages;

public class MessageInfoMessage {

    private final MessageInfo messageInfo;

    public MessageInfoMessage(String from, String to, String message) {
        this.messageInfo = new MessageInfo(from, to, message);
    }

    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

   

}
