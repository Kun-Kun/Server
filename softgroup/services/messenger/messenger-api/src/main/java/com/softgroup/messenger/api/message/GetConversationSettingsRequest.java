package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationSettingsRequest implements RequestData {

    private static final long serialVersionUID = -3611055172145740940L;

    private String conversationId;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
