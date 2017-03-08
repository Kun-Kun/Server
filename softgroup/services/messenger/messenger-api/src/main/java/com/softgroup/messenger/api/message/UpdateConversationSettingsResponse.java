package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationSettings;

/**
 * Created by user on 26.02.2017.
 */
public class UpdateConversationSettingsResponse implements ResponseData {
    private ConversationSettings conversationSettings;

    public ConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
