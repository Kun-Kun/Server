package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utilites.ResponseUtils;
import com.softgroup.profile.api.message.SetProfileSettingsRequest;
import com.softgroup.profile.api.message.SetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class SetProfileSettingsRequestHandler extends AbstractRequestHandler<SetProfileSettingsRequest,SetProfileSettingsResponse>  implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Override
    public String getName(){
        return "set_profile_settings";
    }

    @Override
    public Class<SetProfileSettingsRequest> getRequestDataClass() {
        return SetProfileSettingsRequest.class;
    }

    public Response<SetProfileSettingsResponse> processRequest(Request<SetProfileSettingsRequest> msg){
        String userId = msg.getRoutingData().getUserId();
        String settings = msg.getData().getSettings().getSettings();
        profileService.saveProfileSettings(userId, settings);
        return ResponseUtils.createOKResponse(msg,new SetProfileSettingsResponse());
    }
}
