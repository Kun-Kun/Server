package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.message.GetConversationDetailsRequest;
import com.softgroup.messenger.api.message.GetConversationDetailsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationDetailsRequestHandler extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>  implements MessengerRequestHandler {

    public String getName(){
        return "get_conversation_details";
    }

    @Override
    public Response<GetConversationDetailsResponse> processRequest(Request<GetConversationDetailsRequest> msg){
        return null;
    }
}
