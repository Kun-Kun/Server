package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class MessagesReadConfirmationRequestHandler extends AbstractRequestHandler<MessagesReadConfirmationRequest,MessagesReadConfirmationResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService service;

    public String getName(){
        return "messages_read_confirmation";
    }

    @Override
    public Class<MessagesReadConfirmationRequest> getRequestDataClass() {
        return MessagesReadConfirmationRequest.class;
    }

    @Override
    public Response<MessagesReadConfirmationResponse> processRequest(Request<MessagesReadConfirmationRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        String conversationId = msg.getData().getConversationId();
        List<String> messageIds = msg.getData().getMessagesIds();
        if(service.isUserInConversation(userId,conversationId)){
            service.markMessagesAsViewed(conversationId,userId,messageIds);
            return ResponseUtils.createOKResponse(msg, new MessagesReadConfirmationResponse());
        }else{
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.FORBIDDEN,"You are not member of this conversation");
        }
    }
}
