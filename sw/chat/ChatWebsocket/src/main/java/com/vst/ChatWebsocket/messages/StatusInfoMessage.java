package com.vst.ChatWebsocket.messages;

public class StatusInfoMessage {

   

    private final StatusInfo statusInfo;

    public StatusInfoMessage(String user, STATUS status) {
        this.statusInfo = new StatusInfo(user, status);
    }

    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    

}
