package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationSettings;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationSettingsResponse implements ResponseData {
    private ConversationSettings conversation_settings;

    public ConversationSettings getConversation_settings() {
        return conversation_settings;
    }

    public void setConversation_settings(ConversationSettings conversation_settings) {
        this.conversation_settings = conversation_settings;
    }
}
