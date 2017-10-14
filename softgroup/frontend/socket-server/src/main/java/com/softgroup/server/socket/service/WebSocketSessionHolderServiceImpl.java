package com.softgroup.server.socket.service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.softgroup.server.socket.socket.SocketExpirationDatabase;
import com.softgroup.token.api.JwtUserIdentifierExtended;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 29.09.2017.
 */
@Service
public class WebSocketSessionHolderServiceImpl {

    private SocketExpirationDatabase parkingSessions = new SocketExpirationDatabase(5000,10, TimeUnit.MINUTES);

    private HashMap<String, JwtUserIdentifierExtended> registeredSessions = new HashMap<String, JwtUserIdentifierExtended>();

    private Multimap<String, WebSocketSession> userIdSessionMap = ArrayListMultimap.create();

    public void registerSession(WebSocketSession session){
        parkingSessions.put(session.getId(),session);
    }

    public void registerUser(WebSocketSession session, JwtUserIdentifierExtended user){
        registeredSessions.put(session.getId(),user);
        userIdSessionMap.put(user.getUserId(),session);
        parkingSessions.invalidate(session.getId());
    }

    public List<WebSocketSession> getUserSessions(String userId){
        return new ArrayList<WebSocketSession>(userIdSessionMap.get(userId));
    }

    public void invalidateAll(WebSocketSession session){
        String sessionId = session.getId();
        JwtUserIdentifierExtended identifier = registeredSessions.get(sessionId);
        if(identifier!=null) {
            String userId = identifier.getUserId();
            userIdSessionMap.remove(userId, session);
        }
        registeredSessions.remove(sessionId);
        parkingSessions.invalidate(sessionId);
    }

    public JwtUserIdentifierExtended getUser(WebSocketSession session){
        return registeredSessions.get(session.getId());
    }
}
