package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsDetailsResponse implements ResponseData {
    private ArrayList<DTOConversationDetails> conversationDetailss;

    public ArrayList<DTOConversationDetails> getConversationDetailss() {
        return conversationDetailss;
    }

    public void setConversationDetailss(ArrayList<DTOConversationDetails> conversationDetailss) {
        this.conversationDetailss = conversationDetailss;
    }
}
