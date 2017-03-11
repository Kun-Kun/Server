package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsSettingsRequest implements RequestData {
    private ArrayList<String> conversationsIds;

    public ArrayList<String> getConversationsIds() {
        return conversationsIds;
    }

    public void setConversationsIds(ArrayList<String> conversationsIds) {
        this.conversationsIds = conversationsIds;
    }
}
