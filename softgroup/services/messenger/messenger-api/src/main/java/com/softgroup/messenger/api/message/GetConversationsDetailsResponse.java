package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversationDetails;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsDetailsResponse implements ResponseData {

    private static final long serialVersionUID = -5260520479959572755L;

    private List<DTOConversationDetails> conversationDetails;

    public List<DTOConversationDetails> getConversationDetails() {
        return conversationDetails;
    }

    public void setConversationDetails(List<DTOConversationDetails> conversationDetails) {
        this.conversationDetails = conversationDetails;
    }
}
