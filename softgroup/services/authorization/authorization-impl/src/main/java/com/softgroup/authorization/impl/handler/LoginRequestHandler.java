package com.softgroup.authorization.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.*;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 24.02.2017.
 */
@Component
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequest,LoginResponse>  implements AuthorizationRequestHandler{

    public String getName(){
        return "login";
    }


}
