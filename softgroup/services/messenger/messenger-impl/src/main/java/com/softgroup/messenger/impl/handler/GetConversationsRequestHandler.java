package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dto.DTOConversation;
import com.softgroup.common.mapper.ConversationMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.enumeration.ConversationType;
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
public class GetConversationsRequestHandler extends AbstractRequestHandler<GetConversationsRequest,GetConversationsResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private ConversationMapper conversationMapper;


    public String getName(){
        return "get_conversations";
    }

    @Override
    public Class<GetConversationsRequest> getRequestDataClass() {
        return GetConversationsRequest.class;
    }

    @Override
    public Response<GetConversationsResponse> processRequest(Request<GetConversationsRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        ConversationType type = msg.getData().getType();
        List<ConversationEntity> conversationEntities;

        if(ConversationType.INDIVIDUAL.equals(type)){
            conversationEntities = messengerService.getIndividualConversationForUser(userId);
        }else if(ConversationType.GROUP.equals(type)) {
            conversationEntities = messengerService.getGroupConversationForUser(userId);
        }else {
            conversationEntities = messengerService.getAllConversationForUser(userId);
        }

         List<DTOConversation> conversations = conversationEntities.parallelStream().map(conversationEntity ->
            conversationMapper.mapConversationDtoFromEntity(conversationEntity)
        ).collect(Collectors.toList());

        GetConversationsResponse response = new GetConversationsResponse();
        response.setConversations(conversations);
        return ResponseUtils.createOKResponse(msg,response);
    }
}
