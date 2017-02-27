package com.softgroup.common.protocol.entry;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class ConversationDetails {
    // Conversation
    private String id ;
    //список учасников
    private ArrayList<Profile> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Profile> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Profile> members) {
        this.members = members;
    }
}
