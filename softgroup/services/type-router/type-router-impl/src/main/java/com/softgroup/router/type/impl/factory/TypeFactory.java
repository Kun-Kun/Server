package com.softgroup.router.type.impl.factory;

import com.sofrgroup.router.type.api.factory.TypeRouterFactory;
import com.softgroup.common.factory.TypeHandlerFactory;
import com.softgroup.common.router.api.CommandRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 06.03.2017.
 */
@Component
public class TypeFactory extends TypeHandlerFactory<CommandRouterHandler> implements TypeRouterFactory {
}
