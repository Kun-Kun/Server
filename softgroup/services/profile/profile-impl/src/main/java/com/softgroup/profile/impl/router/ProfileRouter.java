package com.softgroup.profile.impl.router;
import com.softgroup.common.router.api.AbstractCommandRouterHandler;

import com.softgroup.common.router.api.CommandRouterHandler;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;


/**
 * Created by user on 26.02.2017.
 */
@Component
public class ProfileRouter extends AbstractCommandRouterHandler<ProfileRequestHandler> implements CommandRouterHandler {

    @Override
    public String getName(){
        return "profile";
    }

}
