package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetMessagesRequest;
import com.softgroup.messenger.api.message.GetMessagesResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetMessagesRequestHandler extends AbstractRequestHandler<GetMessagesRequest,GetMessagesResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_messages";
    }

}
