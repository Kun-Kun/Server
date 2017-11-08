package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversation;
import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class CreateConversationResponse implements ResponseData {

    private static final long serialVersionUID = -4948057662288991895L;

    private DTOConversation conversation;

    public DTOConversation getConversation() {
        return conversation;
    }

    public void setConversation(DTOConversation conversation) {
        this.conversation = conversation;
    }
}
