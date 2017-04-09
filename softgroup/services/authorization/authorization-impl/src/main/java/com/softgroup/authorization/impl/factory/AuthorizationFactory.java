package com.softgroup.authorization.impl.factory;

import com.softgroup.authorization.api.factory.AuthorizationHandlerFactory;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.factory.CommandHandlerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by maxim on 06.03.17.
 */
@Component
public class AuthorizationFactory extends CommandHandlerFactory<AuthorizationRequestHandler> implements AuthorizationHandlerFactory {

}
