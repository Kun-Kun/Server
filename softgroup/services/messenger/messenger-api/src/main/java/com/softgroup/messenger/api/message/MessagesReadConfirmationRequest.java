package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public class MessagesReadConfirmationRequest implements RequestData {

    private static final long serialVersionUID = -3281474044682410285L;

    private String conversationId;

    private List<String> messagesIds;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public List<String> getMessagesIds() {
        return messagesIds;
    }

    public void setMessagesIds(List<String> messagesIds) {
        this.messagesIds = messagesIds;
    }
}
