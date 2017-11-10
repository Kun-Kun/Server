package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dto.DTOProfile;
import com.softgroup.common.mapper.ProfileMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.GetOtherProfilesRequest;
import com.softgroup.profile.api.message.GetOtherProfilesResponse;
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
public class GetOtherProfilesRequestHandler extends AbstractRequestHandler<GetOtherProfilesRequest,GetOtherProfilesResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public String getName(){
        return "get_other_profiles";
    }

    @Override
    public Class<GetOtherProfilesRequest> getRequestDataClass() {
        return GetOtherProfilesRequest.class;
    }

    public Response<GetOtherProfilesResponse> processRequest(Request<GetOtherProfilesRequest> msg){
        List<String> profileIds = msg.getData().getUserId();
        List<ProfileEntity> profileEntities = profileService.getProfiles(profileIds);
        List<DTOProfile> dtoProfiles = profileEntities.stream().map(entity ->
            profileMapper.mapProfileDtoFromEntity(entity)
        ).collect(Collectors.toList());
        GetOtherProfilesResponse response = new GetOtherProfilesResponse();
        response.setProfiles(dtoProfiles);
        return ResponseUtils.createOKResponse(msg,response);
    }
}
