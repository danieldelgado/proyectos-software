package com.autentia.tutorial.websockets.messages;

import java.util.List;

public class ConnectionInfo {

    private final String user;

    private final List<String> activeUsers;

    public ConnectionInfo(String user, List<String> activeUsers) {
    	System.out.println("new ConnectionInfo user:"+user+" activeUsers:"+activeUsers);
        this.user = user;
        this.activeUsers = activeUsers;
    }

    public String getUser() {
        return user;
    }

    public List<String> getActiveUsers() {
        return activeUsers;
    }
}
