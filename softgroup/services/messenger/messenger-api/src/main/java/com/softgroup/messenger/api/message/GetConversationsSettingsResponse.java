package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.DTO.DTOConversationSettings;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsSettingsResponse implements ResponseData {
    private ArrayList<DTOConversationSettings> conversationSettingss;

    public ArrayList<DTOConversationSettings> getConversationSettingss() {
        return conversationSettingss;
    }

    public void setConversationSettingss(ArrayList<DTOConversationSettings> conversationSettingss) {
        this.conversationSettingss = conversationSettingss;
    }
}
