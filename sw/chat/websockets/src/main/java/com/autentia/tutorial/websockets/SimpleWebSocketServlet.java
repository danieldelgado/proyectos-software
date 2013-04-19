package com.autentia.tutorial.websockets;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class SimpleWebSocketServlet extends WebSocketServlet {
// funcional hasta la version de chrome de Versión 26.0.1410.43
    private static final Logger log = LoggerFactory.getLogger(SimpleWebSocketServlet.class);

    @Override
    protected boolean verifyOrigin(String origin) {
    	System.out.println("origin:"+origin);
        log.trace("Origin: {}", origin);
        return true;
    }

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
    	System.out.println("subProtocol:"+subProtocol);
        return new WebSocketConnection();
    }

    private static class WebSocketConnection extends MessageInbound {
    	
    	public WebSocketConnection() {
        	System.out.println("create WebSocketConnection:");
		}
    	
        @Override
        protected void onOpen(WsOutbound outbound) {
        	System.out.println("Conexion abierta:"+outbound);
            log.info("Conexion abierta");
        }

        @Override
        protected void onClose(int status) {
            log.info("Conexion cerrada");
        	System.out.println("onClose status:"+status);
        }

        @Override
        protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
        	System.out.println("onBinaryMessage byteBuffer:"+byteBuffer);
            log.warn("No se soportan mensajes binarios");
            throw new UnsupportedOperationException("No se soportan mensajes binarios");
        }

        @Override
        protected void onTextMessage(CharBuffer charBuffer) throws IOException {
            final String user = charBuffer.toString();
        	System.out.println("onTextMessage user:"+user);
            log.debug("Mensaje recibido: {}", user);
            getWsOutbound().writeTextMessage(CharBuffer.wrap("Hola " + user + " desde WebSocket"));
        }
    }
}
