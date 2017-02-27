package com.softgroup.profile.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.api.message.GetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetOtherProfilesRequestHandler extends AbstractRequestHandler<GetMyProfileRequest,GetMyProfileResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "get_other_profiles";
    }
}
