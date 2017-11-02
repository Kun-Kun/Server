package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOConversation;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.mapper.ConversationMapper;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationsByIdsRequestHandler extends AbstractRequestHandler<GetConversationsByIdsRequest,GetConversationsByIdsResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private ConversationMapper conversationMapper;

    public String getName(){
        return "get_conversations_by_ids";
    }

    @Override
    public Class<GetConversationsByIdsRequest> getRequestDataClass() {
        return GetConversationsByIdsRequest.class;
    }

    @Override
    public Response<GetConversationsByIdsResponse> processRequest(Request<GetConversationsByIdsRequest> msg){

        List<String> conversationIds = msg.getData().getConversationsIds();
        List<ConversationEntity> conversationEntities = messengerService.findConversationByIds(conversationIds);
        List<DTOConversation> dtoConversations = conversationEntities.parallelStream().map(conversationEntity ->
             conversationMapper.mapConversationDtoFromEntity(conversationEntity)
        ).collect(Collectors.toList());

        GetConversationsByIdsResponse response = new GetConversationsByIdsResponse();
        response.setConversations(dtoConversations);
        return ResponseUtils.createOKResponse(msg, response);
    }

}
