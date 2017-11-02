package com.softgroup.common.cache.socket;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.softgroup.common.cache.ExpirationDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Created by user on 11.04.2017.
 */

public class SocketExpirationDatabase implements ExpirationDatabase<String,WebSocketSession> {

    private Log log = LogFactory.getLog(SocketExpirationDatabase.class);

    private Cache<String,WebSocketSession> cache;

    private final Long timeoutTime;

    public SocketExpirationDatabase(Integer size, long time, TimeUnit unit) {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .maximumSize(size)
                .expireAfterWrite(time, unit).removalListener(new SocketRemovalListener())
                .build();
        timeoutTime = unit.toMillis(time);
        log.info("Cache initialized ");
    }

    public Cache<String,WebSocketSession> getCache() {
        return cache;
    }

    public boolean isInDatabase(String key){
        return cache.getIfPresent(key)!=null;
    }

    public WebSocketSession get(String key){
        log.info("Get "+key);
        return cache.getIfPresent(key);
    }

    @Override
    public WebSocketSession getIfPresent(String key) {
        return get(key);
    }

    public void put(String key,WebSocketSession value){
        cache.put(key,value);
        log.info("Put "+key+" with "+value);
    }

    public void invalidate(String key){
        log.info("Invalidate "+key);
        cache.invalidate(key);
    }

    public WebSocketSession pop(String key){
        log.info("Pop "+key);
        WebSocketSession value = cache.getIfPresent(key);
        log.info("Cache contains "+value);
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

        private Log log = LogFactory.getLog(SocketRemovalListener.class);

        @Override
        public void onRemoval(RemovalNotification<String, WebSocketSession> notification) {
            WebSocketSession webSocketSession = notification.getValue();
            switch (notification.getCause()){
                case EXPIRED:
                    log.info("Session "+webSocketSession.getId()+" expired");
                    if (webSocketSession.isOpen()){
                        try {
                            webSocketSession.close();
                        } catch (IOException e) {
                            log.error("Error occurred when close session",e);
                        }
                    }
                    break;
                    //we delete this object by invalidate
                case EXPLICIT:
                    log.info("Session "+webSocketSession.getId()+" explicit");
                    //cache overhead
                    break;
                case SIZE:
                    log.info("Session "+webSocketSession.getId()+" dropped(cache overhead)");
                    if (webSocketSession.isOpen()){
                        try {
                            webSocketSession.close();
                        } catch (IOException e) {
                            log.error("Error occurred when close session",e);
                        }
                    }
                    break;
                case REPLACED:
                    log.info("Session "+webSocketSession.getId()+" replaced");
                    break;
                case COLLECTED:
                    log.info("Session "+webSocketSession.getId()+" collected");
            }
        }
    }
}
