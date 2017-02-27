package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsRequest implements RequestData {
    private String conversation_id;

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }
}
