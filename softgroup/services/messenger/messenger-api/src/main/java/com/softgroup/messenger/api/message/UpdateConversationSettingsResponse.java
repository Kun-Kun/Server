package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class UpdateConversationSettingsResponse implements ResponseData {
    private DTOConversationSettings conversationSettings;

    public DTOConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(DTOConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
