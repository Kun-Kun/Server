package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOCursorRequest;
import com.softgroup.common.protocol.RequestData;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesRequest implements RequestData {

    private static final long serialVersionUID = 79682569157940855L;

    private String conversationId;

    private DTOCursorRequest cursor;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationsId) {
        this.conversationId = conversationsId;
    }

    public DTOCursorRequest getCursor() {
        return cursor;
    }

    public void setCursor(DTOCursorRequest cursor) {
        this.cursor = cursor;
    }
}
