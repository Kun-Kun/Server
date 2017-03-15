package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsResponse implements ResponseData {
    private DTOConversationDetails conversationDetails;

    public DTOConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(DTOConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
