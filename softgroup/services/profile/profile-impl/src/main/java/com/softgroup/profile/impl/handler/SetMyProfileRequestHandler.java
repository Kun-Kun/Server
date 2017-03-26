package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class SetMyProfileRequestHandler extends AbstractRequestHandler<SetMyProfileRequest,SetMyProfileResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "set_my_profile";
    }

    public Response<SetMyProfileResponse> processRequest(Request<SetMyProfileRequest> msg){
        return null;
    }
}
