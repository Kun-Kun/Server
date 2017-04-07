package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by user on 26.03.2017.
 */
public enum MessageStatus {
    @JsonProperty("0")
    GENERATED,
    @JsonProperty("1")
    SENT,
    @JsonProperty("2")
    DELIVERED,
    @JsonProperty("3")
    VIEWED,
    @JsonProperty("4")
    DELETED
}
