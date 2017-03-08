package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationDetails;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsDetailsResponse implements ResponseData {
    private ArrayList<ConversationDetails> conversationDetailss;

    public ArrayList<ConversationDetails> getConversationDetailss() {
        return conversationDetailss;
    }

    public void setConversationDetailss(ArrayList<ConversationDetails> conversationDetailss) {
        this.conversationDetailss = conversationDetailss;
    }
}
