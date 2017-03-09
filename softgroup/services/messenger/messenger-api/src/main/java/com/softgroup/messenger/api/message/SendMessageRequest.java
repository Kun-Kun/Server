package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;
import com.softgroup.common.protocol.DTO.DTOMessageRequest;

/**
 * Created by user on 26.02.2017.
 */
public class SendMessageRequest implements RequestData {

    private DTOMessageRequest message;

    public DTOMessageRequest getMessage() {
        return message;
    }

    public void setMessage(DTOMessageRequest message) {
        this.message = message;
    }
}
