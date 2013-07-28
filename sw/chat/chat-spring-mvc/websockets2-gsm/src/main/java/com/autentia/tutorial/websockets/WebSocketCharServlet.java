package com.autentia.tutorial.websockets;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.tutorial.websockets.messages.ConnectionInfoMessage;
import com.autentia.tutorial.websockets.messages.MessageInfoMessage;
import com.autentia.tutorial.websockets.messages.STATUS;
import com.autentia.tutorial.websockets.messages.StatusInfoMessage;
import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/chat")
public class WebSocketCharServlet extends WebSocketServlet {

    private static final Logger log = LoggerFactory.getLogger(WebSocketCharServlet.class);

    public static final Map<String, ChatConnection> connections = new HashMap<String, ChatConnection>();

    public WebSocketCharServlet() {
//		System.out.println("WebSocketCharServlet connections");
//		System.out.println(connections);
	}    
    
    @Override
    protected boolean verifyOrigin(String origin) {
		System.out.println("WebSocketCharServlet verifyOrigin origin  http://localhost:8080 : "+origin);
        return true;
    }

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
//		System.out.println("WebSocketCharServlet createWebSocketInbound subProtocol:"+subProtocol);
        final String connectionId = request.getSession().getId();
        final String userName = request.getParameter("userName");
//		System.out.println("WebSocketCharServlet createWebSocketInbound connectionId:"+connectionId+"userName:"+userName);
        return new ChatConnection(connectionId, userName);
    }

    private static class ChatConnection extends MessageInbound {

        private final String connectionId;

        private final String userName;

        private final Gson jsonProcessor;

        private ChatConnection(String connectionId, String userName) {
//    		System.out.println("new ChatConnection  connectionId:"+connectionId+"userName:"+userName);
            this.connectionId = connectionId;
            this.userName = userName;
            this.jsonProcessor = new Gson();
        }

        @Override
        protected void onOpen(WsOutbound outbound) {
//    		System.out.println("ChatConnection onOpen outbound:"+outbound );
            sendConnectionInfo(outbound);
            sendStatusInfoToOtherUsers(new StatusInfoMessage(userName, STATUS.CONNECTED));
            connections.put(connectionId, this);
        }

        @Override
        protected void onClose(int status) {
//    		System.out.println("ChatConnection onClose status:"+status+" userName:"+userName+" connectionId:"+connectionId );
            sendStatusInfoToOtherUsers(new StatusInfoMessage(userName, STATUS.DISCONNECTED));
            connections.remove(connectionId);
        }

        @Override
        protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
//    		System.out.println("ChatConnection onBinaryMessage byteBuffer:"+byteBuffer+" userName:"+userName+" connectionId:"+connectionId );
            throw new UnsupportedOperationException("Binary messages not supported");
        }

        @Override
        protected void onTextMessage(CharBuffer charBuffer) throws IOException {
        	String str = null;
//        	System.out.println("onTextMessage charBuffer:"+charBuffer);
            final MessageInfoMessage message = jsonProcessor.fromJson(charBuffer.toString(), MessageInfoMessage.class);
//        	System.out.println("onTextMessage message:"+message);
            final ChatConnection destinationConnection = getDestinationUserConnection(message.getMessageInfo().getTo());
//        	System.out.println("onTextMessage destinationConnection:"+destinationConnection);
            if (destinationConnection != null) {
            	str = jsonProcessor.toJson(message);
//            	System.out.println(" str:"+str);
                final CharBuffer jsonMessage = CharBuffer.wrap(str);
//                System.out.println(" jsonMessage:"+jsonMessage);
                destinationConnection.getWsOutbound().writeTextMessage(jsonMessage);
            } else {
                log.warn("Se esta  intentando enviar un mensaje a un usuario no conectado");
            }
        }

        public String getUserName() {
            return userName;
        }

        private void sendConnectionInfo(WsOutbound outbound) {
//            System.out.println(" sendConnectionInfo :"+outbound);
            final List<String> activeUsers = getActiveUsers();
            final ConnectionInfoMessage connectionInfoMessage = new ConnectionInfoMessage(userName, activeUsers);
            String str = null;
            try {
            	str = jsonProcessor.toJson(connectionInfoMessage);
//            	System.out.println(" str:"+str);
                outbound.writeTextMessage(CharBuffer.wrap(str));
            } catch (IOException e) {
                log.error("No se pudo enviar el mensaje", e);
            }
        }

        private List<String> getActiveUsers() {
            final List<String> activeUsers = new ArrayList<String>();
            for (ChatConnection connection : connections.values()) {
                activeUsers.add(connection.getUserName());
            }
//        	System.out.println(" getActiveUsers:"+activeUsers);
            return activeUsers;
        }

        private void sendStatusInfoToOtherUsers(StatusInfoMessage message) {
//        	System.out.println(" sendStatusInfoToOtherUsers message: "+message);
            final Collection<ChatConnection> otherUsersConnections = getAllChatConnectionsExceptThis();
            String str = null;
            for (ChatConnection connection : otherUsersConnections) {
                try {
                	str = jsonProcessor.toJson(message);
//                	System.out.println(" str:"+str);
                    connection.getWsOutbound().writeTextMessage(CharBuffer.wrap(str));
                } catch (IOException e) {
                    log.error("No se pudo enviar el mensaje", e);
                }
            }
        }

        private Collection<ChatConnection> getAllChatConnectionsExceptThis() {
            final Collection<ChatConnection> allConnections = connections.values();
            allConnections.remove(this);
//            System.out.println(" getAllChatConnectionsExceptThis :"+allConnections);
            return allConnections;
        }

        private ChatConnection getDestinationUserConnection(String destinationUser) {
//        	System.out.println("getDestinationUserConnection onBinaryMessage destinationUser:"+destinationUser+" userName:"+userName+" connectionId:"+connectionId );
            for (ChatConnection connection : connections.values()) {
                if (destinationUser.equals(connection.getUserName())) {
//                	System.out.println("  destinationUser connectionId : " + connectionId );
                    return connection;
                }
            }
//            System.out.println("return null");
            return null;
        }

    }

}
