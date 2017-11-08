package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.repositories.ProfileRepository;
import com.softgroup.common.dto.DTOProfile;
import com.softgroup.common.mapper.ProfileMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetMyProfileRequestHandler extends AbstractRequestHandler<GetMyProfileRequest,GetMyProfileResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public String getName(){
        return "get_my_profile";
    }

    @Override
    public Class<GetMyProfileRequest> getRequestDataClass() {
        return GetMyProfileRequest.class;
    }

    public Response<GetMyProfileResponse> processRequest(Request<GetMyProfileRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        ProfileEntity profile = profileRepository.findOne(userId);
        DTOProfile dtoProfile = profileMapper.mapProfileDtoFromEntity(profile);
        GetMyProfileResponse response = new GetMyProfileResponse();
        response.setProfile(dtoProfile);
        return ResponseUtils.createOKResponse(msg,response);
    }
}
