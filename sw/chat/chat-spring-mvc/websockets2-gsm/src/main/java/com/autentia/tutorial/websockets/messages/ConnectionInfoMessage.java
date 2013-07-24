package com.autentia.tutorial.websockets.messages;

import java.util.List;

public class ConnectionInfoMessage {

    private final ConnectionInfo connectionInfo;

    public ConnectionInfoMessage(String user, List<String> activeUsers) {
    	System.out.println("new ConnectionInfoMessage user:"+user+" activeUsers:"+activeUsers);
        this.connectionInfo = new ConnectionInfo(user, activeUsers);
    }

    public ConnectionInfo getConnectionInfo() {
        return connectionInfo;
    }


}
