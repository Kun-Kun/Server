package com.softgroup.common.protocol.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonValue
    public Integer getValue() {
        return value;
    }

    MessageStatus (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static MessageStatus fromValue(final Integer value) {
        for (MessageStatus messageType : MessageStatus.values()) {
            if(messageType.getValue().equals(value)){
                return messageType;
            }
        }
        return null;
    }
}
