package com.autentia.tutorial.websockets.messages;

public class MessageInfoMessage {

    private final MessageInfo messageInfo;

    public MessageInfoMessage(String from, String to, String message) {
    	System.out.println("new MessageInfoMessage from:"+from+" to:"+to+" message:"+message);
        this.messageInfo = new MessageInfo(from, to, message);
    }

    public MessageInfo getMessageInfo() {
        return messageInfo;
    }

   

}
