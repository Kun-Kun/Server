package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 26.03.2017.
 */
public enum MessageStatus {
    GENERATED(0),
    SENT(1),
    DELIVERED(2),
    VIEWED(3),
    DELETED(4);

    private Integer value;

    private static final Map<Integer,MessageStatus> STATUS_MAP;

    static {
        Map<Integer,MessageStatus> map = new HashMap<>();
        for (MessageStatus messageStatus : MessageStatus.values()) {
            map.put(messageStatus.getValue(), messageStatus);
        }
        STATUS_MAP = Collections.unmodifiableMap(map);
    }


    @JsonValue
    public Integer getValue() {
        return value;
    }

    MessageStatus (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static MessageStatus fromValue(final Integer value) {
        return STATUS_MAP.get(value);
    }
}
