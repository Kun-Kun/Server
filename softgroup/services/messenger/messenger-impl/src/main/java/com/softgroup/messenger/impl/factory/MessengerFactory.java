package com.softgroup.messenger.impl.factory;

import com.softgroup.common.factory.CommandHandlerFactory;
import com.softgroup.messenger.api.factory.MessengerHandlerFactory;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 06.03.2017.
 */
@Component
public class MessengerFactory extends CommandHandlerFactory<MessengerRequestHandler> implements MessengerHandlerFactory {
}
