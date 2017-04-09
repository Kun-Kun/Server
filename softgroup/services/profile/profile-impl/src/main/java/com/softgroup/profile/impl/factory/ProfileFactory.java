package com.softgroup.profile.impl.factory;

import com.softgroup.common.factory.CommandHandlerFactory;
import com.softgroup.profile.api.factory.ProfileHandlerFactory;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 06.03.2017.
 */
@Component
public class ProfileFactory extends CommandHandlerFactory<ProfileRequestHandler> implements ProfileHandlerFactory {
}
