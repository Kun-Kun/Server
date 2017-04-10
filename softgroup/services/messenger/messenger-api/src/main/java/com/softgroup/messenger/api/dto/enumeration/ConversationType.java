package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 26.03.2017.
 */
public enum ConversationType {

    INDIVIDUAL(0),
    GROUP(1);

    private Integer value;

    private static final Map<Integer,ConversationType> TYPE_MAP ;

    static {
        Map<Integer,ConversationType> map = new HashMap<>();
        for (ConversationType conversationType : ConversationType.values()) {
            map.put(conversationType.getValue(), conversationType);
        }
        TYPE_MAP = Collections.unmodifiableMap(map);
    }


    @JsonValue
    public Integer getValue() {
        return value;
    }

    ConversationType (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static ConversationType fromValue(final Integer value) {
        return TYPE_MAP.get(value);
    }
}

