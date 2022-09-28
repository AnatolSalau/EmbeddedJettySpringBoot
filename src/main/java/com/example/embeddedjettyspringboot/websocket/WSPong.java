package com.example.embeddedjettyspringboot.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WSPong extends TextWebSocketHandler {
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        session.sendMessage(new TextMessage("connection established"));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        session.sendMessage(new TextMessage("Pong"));
    }
}
