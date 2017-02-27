package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.Conversation;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsByIdsResponse implements ResponseData {
    private ArrayList<Conversation> conversations;

    public ArrayList<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(ArrayList<Conversation> conversations) {
        this.conversations = conversations;
    }
}
