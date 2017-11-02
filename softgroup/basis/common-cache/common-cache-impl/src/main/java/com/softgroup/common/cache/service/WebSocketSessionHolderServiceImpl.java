package com.softgroup.common.cache.service;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import com.softgroup.common.cache.ConversationWebSocketSessionSubscriber;
import com.softgroup.common.data.SocketUserRegistration;
import com.softgroup.common.cache.socket.SocketExpirationDatabase;
import com.softgroup.token.api.JwtUserIdentifierExtended;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 29.09.2017.
 */
@Service
public class WebSocketSessionHolderServiceImpl {

    @Autowired
    private ConversationWebSocketSessionSubscriber subscriber;

    private Log log = LogFactory.getLog(WebSocketSessionHolderServiceImpl.class);

    private SocketExpirationDatabase parkingSessions = new SocketExpirationDatabase(5000,10, TimeUnit.MINUTES);

    private HashMap<String, SocketUserRegistration> registeredSessions = new HashMap<>();

    private Multimap<String, WebSocketSession> userIdSessionMap = HashMultimap.create();

    public void registerSession(WebSocketSession session){
        parkingSessions.put(session.getId(),session);
        log.info(session.getId()+" session added to parking database");
    }

    public void registerUser(WebSocketSession session, JwtUserIdentifierExtended user){
        log.info(session.getId()+" session moved from parking to registered list for user "+user.getUserId());
        SocketUserRegistration registration = new SocketUserRegistration(user,session);
        registeredSessions.put(session.getId(),registration);
        subscriber.subscribe(registration);
        userIdSessionMap.put(user.getUserId(),session);
        parkingSessions.invalidate(session.getId());
    }

    public List<WebSocketSession> getUserSessions(String userId){
        return new ArrayList<>(userIdSessionMap.get(userId));
    }

    public void invalidateAll(WebSocketSession session){
        String sessionId = session.getId();
        SocketUserRegistration socketUserRegistration = registeredSessions.get(sessionId);
        if(socketUserRegistration!=null) {
            String userId = socketUserRegistration.getUserIdentifier().getUserId();
            userIdSessionMap.remove(userId, session);
        }
        registeredSessions.remove(sessionId);
        parkingSessions.invalidate(sessionId);
        log.info(session.getId()+" session removed from all lists");
    }

    public JwtUserIdentifierExtended getUser(WebSocketSession session){
        SocketUserRegistration registration = registeredSessions.get(session.getId());
        if(registration!=null){
            return registration.getUserIdentifier();
        }
        return null;

    }

    //Check registration, return null when session expired
    public JwtUserIdentifierExtended validateSessionRegistration(WebSocketSession session, JwtUserIdentifierExtended userIdentifier){
        if (userIdentifier!=null){
            log.info("Validate expiration for registration "+session.getId()+" session and user "+userIdentifier.getUserId());
            Date userRegistrationExpirationTime = userIdentifier.getExpiration();
            Date currentTime = new Date();
            if (currentTime.after(userRegistrationExpirationTime)){
                log.info("Registration "+session.getId()+" session expired. Current time: "+currentTime+"; > ET: "+userRegistrationExpirationTime);
                deregisterUser(session,userIdentifier);
                return null;
            }else {
                log.info("Registration "+session.getId()+" session not expired. Current time: "+currentTime+"; < ET: "+userRegistrationExpirationTime);
            }
        }else{
            log.info("Session "+session.getId()+" is anonymous");
        }
        return userIdentifier;
    }

    //move session to parking
    public void deregisterUser(WebSocketSession session, JwtUserIdentifierExtended user){
        log.info("Move "+session.getId()+" session to parking list");
        registeredSessions.remove(session.getId());
        subscriber.unsubscribe(session,user);
        userIdSessionMap.remove(user.getUserId(),session);
        registerSession(session);
    }

    //TODO configure scheduler to process inactive session
    public void sessionValidatorScheduler(){
        log.info("Start session validation scheduler");
        registeredSessions.forEach((s, userIdentifierExtended) ->
            validateSessionRegistration(userIdentifierExtended.getSession(),userIdentifierExtended.getUserIdentifier())
        );
    }
}
