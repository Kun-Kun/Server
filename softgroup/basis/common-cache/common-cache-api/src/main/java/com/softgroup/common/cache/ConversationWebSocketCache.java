package com.softgroup.common.cache;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 28.10.2017.
 */
public interface ConversationWebSocketCache extends ExpirationDatabase<String,Set<WebSocketSession>> {
}
