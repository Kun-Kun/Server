package com.softgroup.messenger.api.dto;

import com.softgroup.common.protocol.enumeration.ConversationType;

import java.io.Serializable;

/**
 * Created by user on 26.02.2017.
 */
public class DTOConversation implements Serializable{

    private static final long serialVersionUID = 6160947423785685929L;
    //key
    private String id;
    //Conversation name
    private String name;
    //Logo
    private String logoImageUri;
    //type (0-individual, 1-group)
    private ConversationType type;
    //last message index
    private Long lastMessageIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public ConversationType getType() {
        return type;
    }

    public void setType(ConversationType type) {
        this.type = type;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }
}
