package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversation;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsResponse implements ResponseData {

    private static final long serialVersionUID = -3998491134102562595L;

    private List<DTOConversation> conversations;

    public List<DTOConversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<DTOConversation> conversations) {
        this.conversations = conversations;
    }
}
