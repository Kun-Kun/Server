package com.softgroup.common.cache.service;

import com.softgroup.common.cache.ConversationWebSocketCache;
import com.softgroup.common.cache.ConversationWebSocketSessionSubscriber;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.repositories.ConversationMemberRepository;
import com.softgroup.common.data.SocketUserRegistration;
import com.softgroup.token.api.JwtUserIdentifierExtended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 31.10.2017.
 */
@Service
public class ConversationWebSocketSessionSubscriberImpl implements ConversationWebSocketSessionSubscriber {

    @Autowired
    private ConversationMemberRepository repository;

    @Autowired
    private ConversationWebSocketCache conversationWebSocketCache;

    @Override
    public void subscribe(SocketUserRegistration registration){
        String userId = registration.getUserIdentifier().getUserId();
        WebSocketSession session = registration.getSession();

        List<ConversationMemberEntity> conversationMemberEntities = repository.findByMemberIdAndDeletedIsFalse(userId);
        conversationMemberEntities.forEach(conversationMemberEntity -> {
            String conversationId = conversationMemberEntity.getConversationId();
            subscribeIfActive(conversationId,session);
        });
    }

    @Override
    public void unsubscribe(SocketUserRegistration registration){
        JwtUserIdentifierExtended userIdentifier = registration.getUserIdentifier();
        WebSocketSession session = registration.getSession();
        unsubscribe(session,userIdentifier);
    }

    @Override
    public void unsubscribe(WebSocketSession session, JwtUserIdentifierExtended jwtUserIdentifierExtended) {
        List<ConversationMemberEntity> conversationMemberEntities = repository.findByMemberIdAndDeletedIsFalse(jwtUserIdentifierExtended.getUserId());
        conversationMemberEntities.forEach(conversationMemberEntity -> {
            String conversationId = conversationMemberEntity.getConversationId();
            unsubscribeIfActive(conversationId,session);
        });
    }

    @Override
    public void conversationMembersChanged(String conversationId){
        conversationWebSocketCache.invalidate(conversationId);
    }


    private void subscribeIfActive(String conversationId, WebSocketSession session){
        Set<WebSocketSession> sessionsSet = conversationWebSocketCache.getIfPresent(conversationId);
        if(sessionsSet!=null){
            sessionsSet.add(session);
        }
    }

    private void unsubscribeIfActive(String conversationId, WebSocketSession session){
        Set<WebSocketSession> sessionsSet = conversationWebSocketCache.getIfPresent(conversationId);
        if(sessionsSet!=null){
            sessionsSet.remove(session);
        }
    }

}
