package com.softgroup.common.cache;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;

/**
 * Created by user on 28.10.2017.
 */
public interface ConversationWebSocketCache extends ExpirationDatabase<String,HashSet<WebSocketSession>> {
}
