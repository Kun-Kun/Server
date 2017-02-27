package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationSettingsRequest;
import com.softgroup.messenger.api.message.GetConversationSettingsResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetConversationSettingsRequestHandler extends AbstractRequestHandler<GetConversationSettingsRequest,GetConversationSettingsResponse> implements MessengerRequestHandler {

    public String getName(){
        return "get_conversation_settings";
    }

}
