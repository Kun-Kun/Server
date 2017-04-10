package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 26.03.2017.
 */
public enum  MessageType {
    TEXT(0),
    IMAGE(1),
    LINK(2),
    SERVICE(3);

    private Integer value;

    private static final Map<Integer,MessageType> TYPE_MAP;

    static {
        Map<Integer,MessageType> map = new HashMap<>();
        for (MessageType messageType : MessageType.values()) {
            map.put(messageType.getValue(), messageType);
        }
        TYPE_MAP = Collections.unmodifiableMap(map);
    }


    @JsonValue
    public Integer getValue() {
        return value;
    }

    MessageType (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static MessageType fromValue(final Integer value) {
        return TYPE_MAP.get(value);
    }

}
