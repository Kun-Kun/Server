package com.softgroup.server.socket.socket;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.softgroup.common.cache.ExpirationDatabase;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by user on 11.04.2017.
 */

public class SocketExpirationDatabase implements ExpirationDatabase<String,WebSocketSession> {

    private Cache<String,WebSocketSession> cache;

    private final Long timeoutTime;

    public SocketExpirationDatabase(Integer size, long time, TimeUnit unit) {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .maximumSize(size)
                .expireAfterWrite(time, unit).removalListener(new SocketRemovalListener())
                .build();
        timeoutTime = unit.toMillis(time);
    }

    public Cache<String,WebSocketSession> getCache() {
        return cache;
    }

    public boolean isInDatabase(String key){
        return cache.getIfPresent(key)!=null;
    }

    public WebSocketSession get(String key){
        return cache.getIfPresent(key);
    }

    public void put(String key,WebSocketSession value){
        cache.put(key,value);
    }

    public void invalidate(String key){
        cache.invalidate(key);
    }

    public WebSocketSession pop(String key){
        WebSocketSession value = cache.getIfPresent(key);
        cache.invalidate(key);
        return value;
    }

    public Long size(){
        return cache.size();
    }

    public Long getTimeoutTime() {
        return timeoutTime;
    }

    private static class SocketRemovalListener implements RemovalListener<String , WebSocketSession>{

        @Override
        public void onRemoval(RemovalNotification<String, WebSocketSession> notification) {
            switch (notification.getCause()){
                case EXPIRED:
                    WebSocketSession webSocketSession = notification.getValue();
                    if (webSocketSession.isOpen()){
                        try {
                            webSocketSession.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    //we delete this object by invalidate
                case EXPLICIT:
                    //cache overhead
                case SIZE:

            }
        }
    }
}
