package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;

import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.message.GetConversationsRequest;
import com.softgroup.messenger.api.message.GetConversationsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationsRequestHandler extends AbstractRequestHandler<GetConversationsRequest,GetConversationsResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_conversations";
    }

    @Override
    public Response<GetConversationsResponse> processRequest(Request<GetConversationsRequest> msg){
        return null;
    }
}
