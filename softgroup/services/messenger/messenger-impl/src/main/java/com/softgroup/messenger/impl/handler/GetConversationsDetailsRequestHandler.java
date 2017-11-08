package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dto.DTOConversationDetails;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationsDetailsRequestHandler extends AbstractRequestHandler<GetConversationsDetailsRequest,GetConversationsDetailsResponse>implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Override
    public String getName(){
        return "get_conversations_details";
    }

    @Override
    public Class<GetConversationsDetailsRequest> getRequestDataClass() {
        return GetConversationsDetailsRequest.class;
    }

    @Override
    public Response<GetConversationsDetailsResponse> processRequest(Request<GetConversationsDetailsRequest> msg){
        List<String> conversationIds =  msg.getData().getConversationsIds();
        List<DTOConversationDetails> conversationDetails = conversationIds.parallelStream().map(s ->
            messengerService.getConversationDetails(s)
        ).collect(Collectors.toList());

        GetConversationsDetailsResponse response = new GetConversationsDetailsResponse();
        response.setConversationDetails(conversationDetails);
        return ResponseUtils.createOKResponse(msg, response);
    }
}
