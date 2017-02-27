package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsByIdsRequest implements RequestData {
    private ArrayList<String> conversations_ids;

    public ArrayList<String> getConversations_ids() {
        return conversations_ids;
    }

    public void setConversations_ids(ArrayList<String> conversations_ids) {
        this.conversations_ids = conversations_ids;
    }
}
