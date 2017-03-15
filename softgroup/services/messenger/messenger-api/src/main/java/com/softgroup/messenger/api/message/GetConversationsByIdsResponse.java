package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsByIdsResponse implements ResponseData {
    private ArrayList<DTOConversation> conversations;

    public ArrayList<DTOConversation> getConversations() {
        return conversations;
    }

    public void setConversations(ArrayList<DTOConversation> conversations) {
        this.conversations = conversations;
    }
}
