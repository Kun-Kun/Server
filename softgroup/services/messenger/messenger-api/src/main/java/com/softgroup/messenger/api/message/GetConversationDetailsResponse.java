package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationDetails;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsResponse implements ResponseData {
    private ConversationDetails conversation_details;

    public ConversationDetails getConversation_details() {
        return conversation_details;
    }

    public void setConversation_details(ConversationDetails conversation_details) {
        this.conversation_details = conversation_details;
    }
}
