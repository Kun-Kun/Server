package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.dto.DTOCursorRequest;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class GetMessagesRequestHandler extends AbstractRequestHandler<GetMessagesRequest,GetMessagesResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService service;

    public String getName(){
        return "get_messages";
    }

    @Override
    public Class<GetMessagesRequest> getRequestDataClass() {
        return GetMessagesRequest.class;
    }

    @Override
    public Response<GetMessagesResponse> processRequest(Request<GetMessagesRequest> msg){
        String conversationId = msg.getData().getConversationsId();
        DTOCursorRequest cursorRequest = msg.getData().getCursor();

        return null;
    }
}
