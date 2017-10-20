package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.MessageEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseStatusCode;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOMessage;
import com.softgroup.messenger.api.dto.DTOMessageRequest;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.mapper.MessageMapper;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class SendMessageRequestHandler extends AbstractRequestHandler<SendMessageRequest,SendMessageResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private MessageMapper messageMapper;

    public String getName(){
        return "send_message";
    }

    @Override
    public Class<SendMessageRequest> getRequestDataClass() {
        return SendMessageRequest.class;
    }

    @Override
    public Response<SendMessageResponse> processRequest(Request<SendMessageRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        DTOMessageRequest messageRequest = msg.getData().getMessage();
        if(messengerService.isUserInConversation(userId,messageRequest.getConversationId())){
            MessageEntity message = messengerService.saveMessage(messageRequest,userId);
            messengerService.saveMessageStatus(messageRequest,userId,message.getId());
            DTOMessage dtoMessage = messageMapper.mapMessageDtoFromEntity(message);
            SendMessageResponse response = new SendMessageResponse();
            response.setMessage(dtoMessage);
            return ResponseUtils.createOKResponse(msg,response);
        }else{
            return ResponseUtils.createCustomResponse(msg,ResponseStatusCode.FORBIDDEN,"You are not member of this conversation");
        }
    }
}
