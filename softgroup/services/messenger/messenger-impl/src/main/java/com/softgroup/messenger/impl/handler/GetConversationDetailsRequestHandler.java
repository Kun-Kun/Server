package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOConversationDetails;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationDetailsRequestHandler extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>  implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Override
    public String getName(){
        return "get_conversation_details";
    }

    @Override
    public Class<GetConversationDetailsRequest> getRequestDataClass() {
        return GetConversationDetailsRequest.class;
    }

    @Override
    public Response<GetConversationDetailsResponse> processRequest(Request<GetConversationDetailsRequest> msg){
        String conversationId = msg.getData().getConversationId();
        DTOConversationDetails dtoConversationDetails = messengerService.getConversationDetails(conversationId);

        GetConversationDetailsResponse response = new GetConversationDetailsResponse();
        response.setConversationDetails(dtoConversationDetails);
        return ResponseUtils.createOKResponse(msg, response);
    }
}
