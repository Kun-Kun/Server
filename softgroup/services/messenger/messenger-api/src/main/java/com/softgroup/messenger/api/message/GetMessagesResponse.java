package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.common.protocol.entry.CursorResponse;
import com.softgroup.common.protocol.entry.Message;

import java.util.ArrayList;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesResponse implements ResponseData {
    private ArrayList<Message> messages;
    private int totalUnread;
    private CursorResponse cursor;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public int getTotalUnread() {
        return totalUnread;
    }

    public void setTotalUnread(int totalUnread) {
        this.totalUnread = totalUnread;
    }

    public CursorResponse getCursor() {
        return cursor;
    }

    public void setCursor(CursorResponse cursor) {
        this.cursor = cursor;
    }
}
