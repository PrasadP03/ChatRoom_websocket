package com.chatroom.websocket;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebsocketHandler extends TextWebSocketHandler {
	
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());
      
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
	sessions.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session,TextMessage message) throws Exception
	{
		System.out.println("here");
		for(WebSocketSession session1 : sessions)
		{
			if(session1.isOpen())
			{
				session1.sendMessage(new TextMessage(message.getPayload()));
			}
		}
	}
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session,CloseStatus  status) throws Exception{
		System.out.println("there");
		sessions.remove(session);
		
	}
	
}
