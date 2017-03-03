package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationSettings;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsSettingsResponse implements ResponseData {
    private ArrayList<ConversationSettings> conversations_settings;

    public ArrayList<ConversationSettings> getConversations_settings() {
        return conversations_settings;
    }

    public void setConversations_settings(ArrayList<ConversationSettings> conversations_settings) {
        this.conversations_settings = conversations_settings;
    }
}
