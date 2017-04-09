package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.factory.AuthorizationHandlerFactory;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommandRouterHandler;
import org.springframework.stereotype.Component;


/**
 * Created by user on 24.02.2017.
 */
@Component
public class AuthorizationRouter extends AbstractRouterHandler<AuthorizationHandlerFactory> implements CommandRouterHandler {

    @Override
    public String getName(){
        return "authorization";
    }

}