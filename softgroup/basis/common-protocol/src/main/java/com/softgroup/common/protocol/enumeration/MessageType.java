package com.softgroup.common.protocol.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by user on 26.03.2017.
 */
public enum  MessageType {
    TEXT(0),
    IMAGE(1),
    LINK(2),
    SERVICE(3);

    private Integer value;

    @JsonValue
    public Integer getValue() {
        return value;
    }

    MessageType (Integer value){
        this.value = value;
    }

    @JsonCreator
    public static MessageType fromValue(final Integer value) {
        for (MessageType messageType : MessageType.values()) {
            if(messageType.getValue().equals(value)){
                return messageType;
            }
        }
        return null;
    }

}
