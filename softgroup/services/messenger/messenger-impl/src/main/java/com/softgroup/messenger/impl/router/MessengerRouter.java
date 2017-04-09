package com.softgroup.messenger.impl.router;

import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommandRouterHandler;
import com.softgroup.messenger.api.factory.MessengerHandlerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */

@Component
public class MessengerRouter extends AbstractRouterHandler<MessengerHandlerFactory> implements CommandRouterHandler {

    @Override
    public String getName(){
        return "messenger";
    }

}
