package com.softgroup.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;


/**
 * Created by user on 11.04.2017.
 */

public class SimpleExpirationDatabase<K,V> implements ExpirationDatabase<K,V> {

    private Cache<K,V> cache;

    private final Long timeoutTime;

    public SimpleExpirationDatabase(Integer size, long time, TimeUnit unit) {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(4)
                .maximumSize(size)
                .expireAfterWrite(time, unit)
                .build();
        timeoutTime = unit.toMillis(time);
    }

    public Cache<K, V> getCache() {
        return cache;
    }

    public boolean isInDatabase(K key){
        return cache.getIfPresent(key)!=null;
    }

    public V get(K key){
        return cache.getIfPresent(key);
    }

    public void put(K key,V value){
        cache.put(key,value);
    }

    public void invalidate(K key){
        cache.invalidate(key);
    }

    public V pop(K key){
        V value = cache.getIfPresent(key);
        cache.invalidate(key);
        return value;
    }

    public Long size(){
        return cache.size();
    }

    public Long getTimeoutTime() {
        return timeoutTime;
    }
}
