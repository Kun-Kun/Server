package com.softgroup.messenger.api.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class DTOConversationDetails implements Serializable {

    private static final long serialVersionUID = 5123808540773839864L;
    // Conversation
    private String id ;
    //member list
    private List<DTOProfile> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<DTOProfile> getMembers() {
        return members;
    }

    public void setMembers(List<DTOProfile> members) {
        this.members = members;
    }
}
