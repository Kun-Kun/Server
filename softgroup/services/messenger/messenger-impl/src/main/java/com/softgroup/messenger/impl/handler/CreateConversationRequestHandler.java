package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.enumeration.ConversationType;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class CreateConversationRequestHandler extends AbstractRequestHandler<CreateConversationRequest,CreateConversationResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Override
    public String getName(){
        return "create_conversation";
    }

    @Override
    public Class<CreateConversationRequest> getRequestDataClass() {
        return CreateConversationRequest.class;
    }

    @Override
    public Response<CreateConversationResponse> processRequest(Request<CreateConversationRequest> msg){

        CreateConversationRequest request = msg.getData();
        String userId = msg.getRoutingData().getUserId();

        if(ConversationType.INDIVIDUAL.equals(request.getType())){

        }else{

        }
        return null;
    }

}
