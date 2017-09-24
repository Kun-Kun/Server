package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.messenger.api.dto.DTOConversationDetails;
import com.softgroup.messenger.api.dto.DTOProfile;
import com.softgroup.messenger.api.message.*;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import com.softgroup.messenger.impl.mapper.ProfileMapper;
import com.softgroup.messenger.impl.service.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetConversationDetailsRequestHandler extends AbstractRequestHandler<GetConversationDetailsRequest,GetConversationDetailsResponse>  implements MessengerRequestHandler {

    @Autowired
    private MessengerService messengerService;

    @Autowired
    private ProfileMapper profileMapper;

    public String getName(){
        return "get_conversation_details";
    }

    @Override
    public Class<GetConversationDetailsRequest> getRequestDataClass() {
        return GetConversationDetailsRequest.class;
    }

    @Override
    public Response<GetConversationDetailsResponse> processRequest(Request<GetConversationDetailsRequest> msg){
        String conversationId = msg.getData().getConversationId();

        List<ProfileEntity> profileEntities = messengerService.getConversationDetails(conversationId);
        List<DTOProfile> dtoProfiles = profileEntities.parallelStream().map(profileEntity -> {
            return profileMapper.mapProfileDtoFromEntity(profileEntity);
        }).collect(Collectors.toList());

        DTOConversationDetails dtoConversationDetails = new DTOConversationDetails();
        dtoConversationDetails.setId(conversationId);
        dtoConversationDetails.setMembers(dtoProfiles);

        GetConversationDetailsResponse response = new GetConversationDetailsResponse();
        response.setConversationDetails(dtoConversationDetails);
        return ResponseUtils.createOKResponse(msg, response);
    }
}
