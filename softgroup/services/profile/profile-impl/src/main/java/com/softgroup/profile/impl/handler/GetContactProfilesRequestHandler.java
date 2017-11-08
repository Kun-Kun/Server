package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dto.DTOProfile;
import com.softgroup.common.mapper.ProfileMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.GetContactProfilesRequest;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetContactProfilesRequestHandler extends AbstractRequestHandler<GetContactProfilesRequest,GetContactProfilesResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public String getName(){
        return "get_contact_profiles";
    }

    @Override
    public Class<GetContactProfilesRequest> getRequestDataClass() {
        return GetContactProfilesRequest.class;
    }

    public Response<GetContactProfilesResponse> processRequest(Request<GetContactProfilesRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        List<ProfileEntity> profileEntityList = profileService.getContactProfiles(userId);
        List<DTOProfile> dtoProfiles =profileEntityList.stream().map(profileEntity -> profileMapper.mapProfileDtoFromEntity(profileEntity)).collect(Collectors.toList());
        GetContactProfilesResponse response = new GetContactProfilesResponse();
        response.setProfiles(dtoProfiles);
        return ResponseUtils.createOKResponse(msg,response);
    }
}
