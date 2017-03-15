package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequest;
import com.softgroup.messenger.api.message.DeleteConversationResponse;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequest;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class UpdateConversationSettingsRequestHandler extends AbstractRequestHandler<UpdateConversationSettingsRequest,UpdateConversationSettingsResponse> implements MessengerRequestHandler {

    public String getName(){
        return "update_conversation_settings";
    }

    @Override
    public Response<UpdateConversationSettingsResponse> processRequest(Request<UpdateConversationSettingsRequest> msg){
        return null;
    }
}
