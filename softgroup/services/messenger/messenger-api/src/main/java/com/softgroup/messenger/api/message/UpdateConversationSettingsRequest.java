package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.ConversationSettings;

/**
 * Created by user on 26.02.2017.
 */
public class UpdateConversationSettingsRequest implements RequestData {
    private ConversationSettings conversationSettings;

    public ConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(ConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
