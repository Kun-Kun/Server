package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetProfileSettingsRequest;
import com.softgroup.profile.api.message.GetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetProfileSettingsRequestHandler extends AbstractRequestHandler<GetProfileSettingsRequest,GetProfileSettingsResponse>  implements ProfileRequestHandler {
    public String getName(){
        return " get_profile_settings";
    }

    @Override
    public Class<GetProfileSettingsRequest> getRequestDataClass() {
        return GetProfileSettingsRequest.class;
    }

    public Response<GetProfileSettingsResponse> processRequest(Request<GetProfileSettingsRequest> msg){
        return null;
    }
}
