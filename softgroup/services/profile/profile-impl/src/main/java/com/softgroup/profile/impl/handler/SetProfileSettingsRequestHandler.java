package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetProfileSettingsRequest;
import com.softgroup.profile.api.message.SetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class SetProfileSettingsRequestHandler extends AbstractRequestHandler<SetProfileSettingsRequest,SetProfileSettingsResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "set_profile_settings";
    }

    @Override
    public Class<SetProfileSettingsRequest> getRequestDataClass() {
        return SetProfileSettingsRequest.class;
    }

    public Response<SetProfileSettingsResponse> processRequest(Request<SetProfileSettingsRequest> msg){
        return null;
    }
}
