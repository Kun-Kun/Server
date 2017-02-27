package com.softgroup.profile.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.SetMyProfileRequest;
import com.softgroup.profile.api.message.SetMyProfileResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class SetProfileSettingsRequestHandler extends AbstractRequestHandler<SetMyProfileRequest,SetMyProfileResponse>  implements ProfileRequestHandler {
    public String getName(){
        return "set_profile_settings";
    }
}
