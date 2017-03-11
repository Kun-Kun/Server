package com.softgroup.common.protocol.DTO;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class DTOConversationDetails {
    // Conversation
    private String id ;
    //member list
    private ArrayList<DTOProfile> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<DTOProfile> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<DTOProfile> members) {
        this.members = members;
    }
}
