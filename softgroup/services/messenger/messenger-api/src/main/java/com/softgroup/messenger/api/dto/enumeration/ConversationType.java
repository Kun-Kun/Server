package com.softgroup.messenger.api.dto.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by user on 26.03.2017.
 */
public enum ConversationType {
    @JsonProperty("0")
    INDIVIDUAL,
    @JsonProperty("1")
    GROUP;
}

