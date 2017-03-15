package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesResponse implements ResponseData {
    private ArrayList<DTOMessage> messages;
    private int totalUnread;
    private DTOCursorResponse cursor;

    public ArrayList<DTOMessage> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<DTOMessage> messages) {
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
