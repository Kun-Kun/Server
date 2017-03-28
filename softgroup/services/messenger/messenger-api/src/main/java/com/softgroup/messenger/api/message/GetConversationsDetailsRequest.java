package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationsDetailsRequest implements RequestData {

    private static final long serialVersionUID = -6964069150491095267L;

    private List<String> conversationsIds;

    public List<String> getConversationsIds() {
        return conversationsIds;
    }

    public void setConversationsIds(List<String> conversationsIds) {
        this.conversationsIds = conversationsIds;
    }
}
