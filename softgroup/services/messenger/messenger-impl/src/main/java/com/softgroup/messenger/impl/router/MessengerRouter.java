package com.softgroup.messenger.impl.router;

import com.softgroup.common.router.api.AbstractCommandRouterHandler;

import com.softgroup.common.router.api.CommandTypeRouter;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class MessengerRouter extends AbstractCommandRouterHandler<MessengerRequestHandler> implements CommandTypeRouter {

    @Override
    public String getName(){
        return "messenger";
    }

}
