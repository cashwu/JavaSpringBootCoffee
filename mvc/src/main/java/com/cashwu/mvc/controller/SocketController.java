package com.cashwu.mvc.controller;

import com.cashwu.mvc.WebSocketHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * @author cash.wu
 * @since 2024/07/09
 */
@RestController
public class SocketController {

    private final WebSocketHandler handler;

    public SocketController(WebSocketHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/send")
    public void sendMessage(@RequestParam String text) {

        System.out.println("send to ws : " + text);

        for (WebSocketSession webSocketSession : handler.getWebSocketSessions()) {
            try {
                webSocketSession.sendMessage(new TextMessage(text));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
