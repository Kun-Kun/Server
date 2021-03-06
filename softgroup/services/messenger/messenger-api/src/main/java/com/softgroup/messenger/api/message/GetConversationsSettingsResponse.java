package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOConversationSettings;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsSettingsResponse implements ResponseData {

    private static final long serialVersionUID = 2217800981750069894L;

    private List<DTOConversationSettings> conversationSettings;

    public List<DTOConversationSettings> getConversationSettings() {
        return conversationSettings;
    }

    public void setConversationSettings(List<DTOConversationSettings> conversationSettings) {
        this.conversationSettings = conversationSettings;
    }
}
