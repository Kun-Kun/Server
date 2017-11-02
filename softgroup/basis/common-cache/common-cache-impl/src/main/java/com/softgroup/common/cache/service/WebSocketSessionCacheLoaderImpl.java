package com.softgroup.common.cache.service;

import com.google.common.cache.CacheLoader;
import com.softgroup.common.dao.api.entities.ConversationMemberEntity;
import com.softgroup.common.dao.impl.repositories.ConversationMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by user on 28.10.2017.
 */

@Component
public class WebSocketSessionCacheLoaderImpl extends CacheLoader<String, Set<WebSocketSession>>  {

    @Autowired
    private ConversationMemberRepository repository;

    @Autowired
    private WebSocketSessionHolderServiceImpl sessionHolderService;

    @Override
    public Set<WebSocketSession> load(String key) throws Exception {
        List<ConversationMemberEntity> conversationMemberEntities = repository.findByConversationIdAndAndDeletedIsFalse(key);
        HashSet<WebSocketSession> sessions = new HashSet<>();
        conversationMemberEntities.forEach(conversationMemberEntity ->
            sessions.addAll(sessionHolderService.getUserSessions(conversationMemberEntity.getMemberId()))
        );
        return sessions;
    }
}
