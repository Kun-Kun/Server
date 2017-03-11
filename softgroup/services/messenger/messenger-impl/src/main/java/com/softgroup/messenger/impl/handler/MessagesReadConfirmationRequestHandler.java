package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequest;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class MessagesReadConfirmationRequestHandler extends AbstractRequestHandler<MessagesReadConfirmationRequest,MessagesReadConfirmationResponse> implements MessengerRequestHandler {

    public String getName(){
        return "messages_read_confirmation";
    }

}