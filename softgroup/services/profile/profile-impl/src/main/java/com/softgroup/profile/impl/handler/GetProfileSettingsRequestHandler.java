package com.softgroup.profile.impl.handler;

import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import com.softgroup.common.dto.DTOProfileSettings;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.GetProfileSettingsRequest;
import com.softgroup.profile.api.message.GetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetProfileSettingsRequestHandler extends AbstractRequestHandler<GetProfileSettingsRequest,GetProfileSettingsResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Override
    public String getName(){
        return "get_profile_settings";
    }

    @Override
    public Class<GetProfileSettingsRequest> getRequestDataClass() {
        return GetProfileSettingsRequest.class;
    }

    public Response<GetProfileSettingsResponse> processRequest(Request<GetProfileSettingsRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        ProfileSettingsEntity profileSettingsEntity = profileService.loadSettings(userId);
        DTOProfileSettings profileSettings = new DTOProfileSettings();
        if(profileSettingsEntity==null){
            profileSettings.setSettings("");
        }else {
            profileSettings.setSettings(profileSettingsEntity.getSetting());
        }
        GetProfileSettingsResponse response = new GetProfileSettingsResponse();
        response.setSettings(profileSettings);
        return ResponseUtils.createOKResponse(msg,response);
    }
}
