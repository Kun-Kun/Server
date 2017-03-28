package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.messenger.api.dto.DTOCursorRequest;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesRequest implements RequestData {

    private static final long serialVersionUID = 79682569157940855L;

    private String conversationsId;

    private DTOCursorRequest cursor;

    public String getConversationsId() {
        return conversationsId;
    }

    public void setConversationsId(String conversationsId) {
        this.conversationsId = conversationsId;
    }

    public DTOCursorRequest getCursor() {
        return cursor;
    }

    public void setCursor(DTOCursorRequest cursor) {
        this.cursor = cursor;
    }
}
