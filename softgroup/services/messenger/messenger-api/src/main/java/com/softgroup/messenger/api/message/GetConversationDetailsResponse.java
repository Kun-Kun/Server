package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationDetails;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsResponse implements ResponseData {
    private ConversationDetails conversationDetails;

    public ConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(ConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
