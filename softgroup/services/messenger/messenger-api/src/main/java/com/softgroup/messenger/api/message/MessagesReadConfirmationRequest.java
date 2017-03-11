package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class MessagesReadConfirmationRequest implements RequestData {
    private String conversationId;
    private ArrayList<String> messagesIds;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public ArrayList<String> getMessagesIds() {
        return messagesIds;
    }

    public void setMessagesIds(ArrayList<String> messagesIds) {
        this.messagesIds = messagesIds;
    }
}
