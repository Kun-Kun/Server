package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.message.SendMessageRequest;
import com.softgroup.messenger.api.message.SendMessageResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class SendMessageRequestHandler extends AbstractRequestHandler<SendMessageRequest,SendMessageResponse> implements MessengerRequestHandler {

    public String getName(){
        return "send_message";
    }

    @Override
    public Response<SendMessageResponse> processRequest(Request<SendMessageRequest> msg){
        return null;
    }
}
