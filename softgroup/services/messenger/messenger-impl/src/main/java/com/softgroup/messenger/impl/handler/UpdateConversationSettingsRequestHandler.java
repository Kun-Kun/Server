package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.*;
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
    public Class<UpdateConversationSettingsRequest> getRequestDataClass() {
        return UpdateConversationSettingsRequest.class;
    }

    @Override
    public Response<UpdateConversationSettingsResponse> processRequest(Request<UpdateConversationSettingsRequest> msg){
        return null;
    }
}
