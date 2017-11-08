package com.softgroup.messenger.api.message;

import com.softgroup.common.dto.DTOCursorResponse;
import com.softgroup.common.dto.DTOMessage;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesResponse implements ResponseData {

    private static final long serialVersionUID = 1724108710604498423L;

    private List<DTOMessage> messages;

    private int totalUnread;

    private DTOCursorResponse cursor;

    public List<DTOMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<DTOMessage> messages) {
        this.messages = messages;
    }

    public int getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(int totalUnread) {
        this.totalUnread = totalUnread;
    }

    public DTOCursorResponse getCursor() {
        return cursor;
    }

    public void setCursor(DTOCursorResponse cursor) {
        this.cursor = cursor;
    }
}
