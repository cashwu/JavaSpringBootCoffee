package com.cashwu.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.server.WebSocketService;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cash.wu
 * @since 2024/07/09
 */
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> webSocketSessions = new ArrayList<>();

    public List<WebSocketSession> getWebSocketSessions() {
        return webSocketSessions;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessions.add(session);
        System.out.println("connection afterConnectionEstablished : " + session + " @ " + Instant.now().toString());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        System.out.println("message received : " + message + " , from " + session);

        for (WebSocketSession socketSession : webSocketSessions) {

            if (socketSession != null) {
                socketSession.sendMessage(message);

                System.out.println("--> send message : " + message + " , to " + session);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus status) throws Exception {
        webSocketSessions.remove(session);

        System.out.println("connection afterConnectionClosed : " + session + " @ " + Instant.now().toString());
    }
}
