package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class CreateConversationResponse implements ResponseData {

    private DTOConversation conversation;

    public DTOConversation getConversation() {
        return conversation;
    }

    public void setConversation(DTOConversation conversation) {
        this.conversation = conversation;
    }
}
