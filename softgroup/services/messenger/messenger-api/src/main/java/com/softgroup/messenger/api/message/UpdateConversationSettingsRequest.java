package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversationSettings;
import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 26.02.2017.
 */
public class UpdateConversationSettingsRequest implements RequestData {

    private static final long serialVersionUID = -3599857631478125977L;

    private DTOConversationSettings conversationSettings;

    public DTOConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(DTOConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
