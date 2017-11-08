package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dto.DTOProfile;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class SetMyProfileRequestHandler extends AbstractRequestHandler<SetMyProfileRequest,SetMyProfileResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    public String getName(){
        return "set_my_profile";
    }

    @Override
    public Class<SetMyProfileRequest> getRequestDataClass() {
        return SetMyProfileRequest.class;
    }

    public Response<SetMyProfileResponse> processRequest(Request<SetMyProfileRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        DTOProfile profileRequest = msg.getData().getProfile();

        ProfileEntity databaseProfileEntity = profileService.getUserProfile(userId);
        String name = profileRequest.getName();
        if(name!=null&&!name.isEmpty()) {
            databaseProfileEntity.setName(name);
        }else {
            databaseProfileEntity.setName(databaseProfileEntity.getPhoneNumber());
        }
        databaseProfileEntity.setStatus(profileRequest.getStatus());
        databaseProfileEntity.setUpdateDateTime(new Date().getTime());
        profileService.saveUserProfile(databaseProfileEntity);
        return ResponseUtils.createOKResponse(msg,new SetMyProfileResponse());
    }
}
