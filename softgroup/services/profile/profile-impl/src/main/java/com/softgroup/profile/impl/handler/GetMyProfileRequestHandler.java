package com.softgroup.profile.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class GetMyProfileRequestHandler extends AbstractRequestHandler<GetMyProfileRequest,GetMyProfileResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_my_profile";
    }
}
