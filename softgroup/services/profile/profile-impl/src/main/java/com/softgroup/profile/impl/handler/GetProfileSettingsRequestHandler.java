package com.softgroup.profile.impl.handler;

import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.GetProfileSettingsRequest;
import com.softgroup.profile.api.message.GetProfileSettingsResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;

/**
 * Created by user on 26.02.2017.
 */
public class GetProfileSettingsRequestHandler extends AbstractRequestHandler<GetProfileSettingsRequest,GetProfileSettingsResponse>  implements ProfileRequestHandler {
    public String getName(){
        return " get_profile_settings";
    }
}
