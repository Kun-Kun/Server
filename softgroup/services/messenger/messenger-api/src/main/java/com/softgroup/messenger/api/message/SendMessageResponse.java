package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.DTOMessage;

/**
 * Created by user on 26.02.2017.
 */
public class SendMessageResponse implements ResponseData {

    private static final long serialVersionUID = -523593534179485266L;

    private DTOMessage message;

    public DTOMessage getMessage() {
        return message;
    }

    public void setMessage(DTOMessage message) {
        this.message = message;
    }
}
