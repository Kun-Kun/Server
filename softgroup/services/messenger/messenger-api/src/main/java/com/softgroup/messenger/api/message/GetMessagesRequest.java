package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.CursorRequest;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesRequest implements RequestData {
    private String conversations_id;
    private CursorRequest cursor;

    public String getConversations_id() {
        return conversations_id;
    }

    public void setConversations_id(String conversations_id) {
        this.conversations_id = conversations_id;
    }

    public CursorRequest getCursor() {
        return cursor;
    }

    public void setCursor(CursorRequest cursor) {
        this.cursor = cursor;
    }
}
