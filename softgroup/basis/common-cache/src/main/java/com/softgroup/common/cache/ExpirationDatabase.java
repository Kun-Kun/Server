package com.softgroup.common.cache;

/**
 * Created by user on 13.04.2017.
 */
public interface ExpirationDatabase<K,V> {
    V get(K key);

    void put(K key,V value);

    void invalidate(K key);

    V pop(K key);

    Long size();
}
