package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseBuilder;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.notification.IsTypeInChatNotification;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class IsTypingInChatRequestHandler extends AbstractRequestHandler<IsTypingInChatRequest,IsTypingInChatResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService service;

    public String getName(){
        return "is_typing_in_chat";
    }

    @Override
    public Class<IsTypingInChatRequest> getRequestDataClass() {
        return IsTypingInChatRequest.class;
    }

    @Override
    public Response<IsTypingInChatResponse> processRequest(Request<IsTypingInChatRequest> msg){
        String conversationId = msg.getData().getConversationId();
        String userId = msg.getRoutingData().getUserId();

        if(service.isUserInConversation(userId,conversationId)){
            IsTypeInChatNotification notification = new IsTypeInChatNotification();
            notification.setConversationId(conversationId);
            notification.setUserId(userId);
            ActionHeader header = new ActionHeader();
            header.setCommand("is_typing_in_chat");
            header.setType("messenger");
            Response notificationResponse = new  ResponseBuilder<IsTypeInChatNotification>().setData(notification).setHeader(header).build();
            service.notifyConversation(conversationId,notificationResponse);
            return ResponseUtils.createOKResponse(msg, new IsTypingInChatResponse());
        }else{
            return ResponseUtils.createCustomResponse(msg, ResponseStatusCode.FORBIDDEN,"You are not member of this conversation");
        }
    }
}
