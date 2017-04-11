package com.softgroup.router.type.impl.router;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.sofrgroup.router.type.api.factory.TypeRouterFactory;
import com.softgroup.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class TypeRouter extends AbstractRouterHandler<TypeRouterFactory> implements TypeRouterHandler{
    @Override
    public String getName(){
        return "common";
    }
}
