package com.softgroup.profile.impl.router;
import com.softgroup.common.router.api.AbstractCommandRouterHandler;

import com.softgroup.common.router.api.CommandTypeRouter;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;


/**
 * Created by user on 26.02.2017.
 */
@Component
public class ProfileRouter extends AbstractCommandRouterHandler<ProfileRequestHandler> implements CommandTypeRouter {

    @Override
    public String getName(){
        return "profile";
    }

}
