package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationDetails;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsDetailsResponse implements ResponseData {
    private ArrayList<ConversationDetails> conversations_details;

    public ArrayList<ConversationDetails> getConversations_details() {
        return conversations_details;
    }

    public void setConversations_details(ArrayList<ConversationDetails> conversations_details) {
        this.conversations_details = conversations_details;
    }
}
