package com.softgroup.messenger.api.notification;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 28.10.2017.
 */
public class IsTypeInChatNotification implements ResponseData {

    private static final long serialVersionUID = -7544636974758081516L;

    private String userId;

    private String conversationId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
