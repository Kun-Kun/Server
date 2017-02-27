package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class MessagesReadConfirmationRequest implements RequestData {
    private String conversation_id;
    private ArrayList<String> messages_ids;

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public ArrayList<String> getMessages_ids() {
        return messages_ids;
    }

    public void setMessages_ids(ArrayList<String> messages_ids) {
        this.messages_ids = messages_ids;
    }
}
