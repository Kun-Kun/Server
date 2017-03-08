package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.CursorRequest;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesRequest implements RequestData {
    private String conversationsId;
    private CursorRequest cursor;

    public String getConversationsId() {
        return conversationsId;
    }

    public void setConversationsId(String conversationsId) {
        this.conversationsId = conversationsId;
    }

    public CursorRequest getCursor() {
        return cursor;
    }

    public void setCursor(CursorRequest cursor) {
        this.cursor = cursor;
    }
}
