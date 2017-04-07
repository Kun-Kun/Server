package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by user on 26.03.2017.
 */
public enum  MessageType {
    @JsonProperty("0")
    TEXT,
    @JsonProperty("1")
    IMAGE,
    @JsonProperty("2")
    LINK,
    @JsonProperty("3")
    SERVICE

}
