package com.vst.hsd.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vst.chatsocket.ChatConnection;
import com.vst.util.Constantes;


@Component
@SuppressWarnings("serial")
@WebServlet("/chat")
public class WebSocketCharServlet extends WebSocketServlet {
	
	private static final Logger log = LoggerFactory.getLogger(WebSocketCharServlet.class);
	private String origin = null;

	@Override
	protected boolean verifyOrigin(String origin) {
		this.origin = origin;
		return true;
	}

	@Override
	protected StreamInbound createWebSocketInbound(String subProtocol, HttpServletRequest request) {
		System.out.println("createWebSocketInbound");
		System.out.println(request.getSession().getAttribute(Constantes.SESION_USUARIO));
		final String connectionId = request.getSession().getId();
		final String userName = request.getParameter("userName");
		log.info("createWebSocketInbound userName:" + userName + " connectionId:" + connectionId);
		return new ChatConnection(connectionId, userName, origin);
	}

}
