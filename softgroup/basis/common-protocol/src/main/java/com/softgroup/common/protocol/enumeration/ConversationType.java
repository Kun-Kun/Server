package com.softgroup.common.protocol.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by user on 26.03.2017.
 */
public enum ConversationType {

    INDIVIDUAL(0),
    GROUP(1);

    private Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    ConversationType (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static ConversationType fromValue(final Integer value) {
        for (ConversationType messageType : ConversationType.values()) {
            if(messageType.getValue().equals(value)){
                return messageType;
            }
        }
        return null;
    }
}

