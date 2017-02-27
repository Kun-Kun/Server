package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.entry.DTO.MessageRequestDTO;
import com.softgroup.common.protocol.entry.Message;

/**
 * Created by user on 26.02.2017.
 */
public class SendMessageRequest implements RequestData {

    private MessageRequestDTO message;

    public MessageRequestDTO getMessage() {
        return message;
    }

    public void setMessage(MessageRequestDTO message) {
        this.message = message;
    }
}
