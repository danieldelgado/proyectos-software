package com.vst.ChatWebsocket.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.websocket.MessageInbound;

import com.vst.ChatWebsocket.messages.ConnectionChat;

public class InstanceConnectChat {

	private static final Map<String, ConnectionChat> connections = new HashMap<String, ConnectionChat>();	
	private InstanceConnectChat(){}	
	public static void addConexion(String connectionId, ConnectionChat conexion){
		connections.put(connectionId, conexion);		
	}
	
	public static void removeConexion(String connectionId,MessageInbound conexion){
		connections.remove(connectionId);		
	}
	
	public static List<String> getActiveUsers(String connectionId) {
		List<String> activeUsers = new ArrayList<String>();
		for (ConnectionChat connection : connections.values()) {
			activeUsers.add( connectionId );
		}
		return activeUsers;
	}

	
}
