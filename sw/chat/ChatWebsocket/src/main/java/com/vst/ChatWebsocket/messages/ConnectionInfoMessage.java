package com.vst.ChatWebsocket.messages;

import java.util.List;

public class ConnectionInfoMessage {

    private final ConnectionInfo connectionInfo;

    public ConnectionInfoMessage(String user, List<String> activeUsers) {
        this.connectionInfo = new ConnectionInfo(user, activeUsers);
    }

    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }

    

}
