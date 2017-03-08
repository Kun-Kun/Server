package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.ConversationSettings;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsSettingsResponse implements ResponseData {
    private ArrayList<ConversationSettings> conversationSettingss;

    public ArrayList<ConversationSettings> getConversationSettingss() {
        return conversationSettingss;
    }

    public void setConversationSettingss(ArrayList<ConversationSettings> conversationSettingss) {
        this.conversationSettingss = conversationSettingss;
    }
}
