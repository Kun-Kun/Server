package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by user on 26.02.2017.
 */
public class SendMessageResponse implements ResponseData {
    private DTOMessage message;

    public DTOMessage getMessage() {
        return message;
    }

    public void setMessage(DTOMessage message) {
        this.message = message;
    }
}
