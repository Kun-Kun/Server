package com.softgroup.multicast.notifier;

import com.softgroup.common.cache.ConversationWebSocketCache;
import com.softgroup.common.datamapper.DataMapper;
import com.softgroup.common.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 28.10.2017.
 */
@Component
public class WebSocketMulticastNotifier implements MulticastNotifier {

    @Autowired
    private ConversationWebSocketCache webSocketCache;

    @Autowired
    private DataMapper dataMapper;

    private void sendMessage(WebSocketSession session, String message){
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException|IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void sendMessages(Set<WebSocketSession> sessions, String message){
        sessions.forEach(session -> sendMessage(session,message));
    }

    private void sendMessageToConversationMembers(String conversationId, String message){
        Set<WebSocketSession> sessions = webSocketCache.get(conversationId);
        if(sessions!=null) {
            sendMessages(sessions, message);
        }
    }
    // TODO make method async
    public void sendResponseToConversationMembers(String conversationId, Response response){
        String message = dataMapper.dataToString(response);
        sendMessageToConversationMembers(conversationId,message);
    }

}
