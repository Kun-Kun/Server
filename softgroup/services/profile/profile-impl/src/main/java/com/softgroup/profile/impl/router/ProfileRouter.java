package com.softgroup.profile.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommandRouterHandler;
import com.softgroup.profile.api.factory.ProfileHandlerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by user on 26.02.2017.
 */
@Component
public class ProfileRouter extends AbstractRouterHandler<ProfileHandlerFactory> implements CommandRouterHandler {

    @Override
    public String getName(){
        return "profile";
    }

}
