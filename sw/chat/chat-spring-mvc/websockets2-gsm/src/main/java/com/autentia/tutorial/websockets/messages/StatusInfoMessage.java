package com.autentia.tutorial.websockets.messages;

public class StatusInfoMessage {

	private final StatusInfo statusInfo;

    public StatusInfoMessage(String user, STATUS status) {
      	System.out.println("new StatusInfoMessage user:"+user+" status:"+status);
        this.statusInfo = new StatusInfo(user, status);
    }

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }   

}
