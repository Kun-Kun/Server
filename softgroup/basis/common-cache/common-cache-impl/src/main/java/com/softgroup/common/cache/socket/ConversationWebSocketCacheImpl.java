package com.softgroup.common.cache.socket;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.softgroup.common.cache.ExpirationDatabase;
import com.softgroup.common.cache.ConversationWebSocketCache;
import com.softgroup.common.cache.service.WebSocketSessionCacheLoaderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 28.10.2017.
 */
@Component
public class ConversationWebSocketCacheImpl implements ExpirationDatabase<String,HashSet<WebSocketSession>>, ConversationWebSocketCache {

    private LoadingCache<String,HashSet<WebSocketSession>> cache;

    private Long timeoutTime;

    @Autowired
    private WebSocketSessionCacheLoaderImpl cacheLoader;

    public Cache<String, HashSet<WebSocketSession>> getCache() {
        return cache;
    }

    public boolean isInDatabase(String key){
        return cache.getUnchecked(key)!=null;
    }

    public HashSet<WebSocketSession> get(String key){
        return cache.getUnchecked(key);
    }

    public HashSet<WebSocketSession> getIfPresent(String key) {
        return cache.getIfPresent(key);
    }

    public void put(String key,HashSet<WebSocketSession> value){
        cache.put(key,value);
    }

    public void invalidate(String key){
        cache.invalidate(key);
    }

    public HashSet<WebSocketSession> pop(String key){
        HashSet<WebSocketSession> value = cache.getUnchecked(key);
        cache.invalidate(key);
        return value;
    }

    public Long size(){
        return cache.size();
    }

    public Long getTimeoutTime() {
        return timeoutTime;
    }

    @PostConstruct
    private void init(){
        Integer time = 5;
        TimeUnit unit = TimeUnit.MINUTES;

        cache = CacheBuilder.newBuilder()
                .maximumSize(1000000)
                .concurrencyLevel(4)
                .expireAfterWrite(time, unit)
                .build(cacheLoader);
        timeoutTime = unit.toMillis(time);
    }
}
