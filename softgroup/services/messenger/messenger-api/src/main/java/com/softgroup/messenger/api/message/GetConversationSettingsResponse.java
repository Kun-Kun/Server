package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.DTOConversationSettings;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationSettingsResponse implements ResponseData {

    private static final long serialVersionUID = -7585521225820826359L;

    private DTOConversationSettings conversationSettings;

    public DTOConversationSettings getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(DTOConversationSettings conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
