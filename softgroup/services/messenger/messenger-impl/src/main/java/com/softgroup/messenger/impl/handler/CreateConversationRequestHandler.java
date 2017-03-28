package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class CreateConversationRequestHandler extends AbstractRequestHandler<CreateConversationRequest,CreateConversationResponse> implements MessengerRequestHandler {

    public String getName(){
        return "create_conversation";
    }

    @Override
    public Response<CreateConversationResponse> processRequest(Request<CreateConversationRequest> msg){
        return null;
    }

}
