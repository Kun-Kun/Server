package com.softgroup.messenger.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.IsTypingInChatRequest;
import com.softgroup.messenger.api.message.IsTypingInChatResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class IsTypingInChatRequestHandler extends AbstractRequestHandler<IsTypingInChatRequest,IsTypingInChatResponse> implements MessengerRequestHandler {

    public String getName(){
        return " is_typing_in_chat";
    }

}
