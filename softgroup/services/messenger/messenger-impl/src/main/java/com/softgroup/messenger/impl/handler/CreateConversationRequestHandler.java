package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ConversationEntity;
import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.enumeration.ConversationType;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOConversation;
import com.softgroup.messenger.api.message.CreateConversationRequest;
import com.softgroup.messenger.api.message.CreateConversationResponse;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.mapper.ConversationMapper;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class CreateConversationRequestHandler extends AbstractRequestHandler<CreateConversationRequest,CreateConversationResponse> implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private ConversationMapper conversationMapper;

    @Override
    public String getName(){
        return "create_conversation";
    }

    @Override
    public Class<CreateConversationRequest> getRequestDataClass() {
        return CreateConversationRequest.class;
    }

    @Override
    public Response<CreateConversationResponse> processRequest(Request<CreateConversationRequest> msg){

        CreateConversationRequest request = msg.getData();
        String userId = msg.getRoutingData().getUserId();

        List<ProfileEntity> profiles;
        if(ConversationType.INDIVIDUAL.equals(request.getType())){
            profiles = messengerService.loadIndividualConversationMemberProfiles(userId,request.getMembersIds());
        }else{
            profiles = messengerService.loadGroupConversationMemberProfiles(userId,request.getMembersIds());
        }
        ConversationEntity conversation = messengerService.getConversationByProfiles(profiles);
        String conversationId;
        if(conversation == null){
            conversation = messengerService.createConversation(profiles,request.getType(),userId);
            conversationId = conversation.getId();
            messengerService.addMembersToConversation(conversationId,profiles);
        }else{
            conversationId = conversation.getId();
        }
        //ToDo add returning lastMessageIndex
        DTOConversation dtoConversation = conversationMapper.mapConversationDtoFromEntity(conversation);
        CreateConversationResponse response = new CreateConversationResponse();
        response.setConversation(dtoConversation);
        return ResponseUtils.createOKResponse(msg, response);
    }

}
