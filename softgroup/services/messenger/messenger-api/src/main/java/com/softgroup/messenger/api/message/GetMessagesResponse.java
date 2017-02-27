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
    private int total_unread;
    private CursorResponse cursor;

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public int getTotal_unread() {
        return total_unread;
    }

    public void setTotal_unread(int total_unread) {
        this.total_unread = total_unread;
    }

    public CursorResponse getCursor() {
        return cursor;
    }

    public void setCursor(CursorResponse cursor) {
        this.cursor = cursor;
    }
}
