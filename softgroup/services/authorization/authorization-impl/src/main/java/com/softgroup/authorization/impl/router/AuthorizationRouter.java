package com.softgroup.authorization.impl.router;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.router.api.AbstractCommandRouterHandler;
import com.softgroup.common.router.api.CommandRouterHandler;
import org.springframework.stereotype.Component;


/**
 * Created by user on 24.02.2017.
 */
@Component
public class AuthorizationRouter extends AbstractCommandRouterHandler<AuthorizationRequestHandler> implements CommandRouterHandler {

    @Override
    public String getName(){
        return "authorization";
    }

}