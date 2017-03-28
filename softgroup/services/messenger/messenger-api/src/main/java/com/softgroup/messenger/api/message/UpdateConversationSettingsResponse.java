package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.DTOConversationSettings;

/**
 * Created by user on 26.02.2017.
 */
public class UpdateConversationSettingsResponse implements ResponseData {

    private static final long serialVersionUID = 8259961927879763638L;

    private DTOConversationSettings conversationSettings;

    public DTOConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(DTOConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
