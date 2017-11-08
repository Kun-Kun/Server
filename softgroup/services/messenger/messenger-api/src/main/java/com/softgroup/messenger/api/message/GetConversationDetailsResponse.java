package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversationDetails;
import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationDetailsResponse implements ResponseData {

    private static final long serialVersionUID = 5802746224355563456L;

    private DTOConversationDetails conversationDetails;

    public DTOConversationDetails getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(DTOConversationDetails conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
