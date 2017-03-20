package com.softgroup.router.type.impl.router;

import com.softgroup.common.router.api.AbstractTypeRouterHandler;
import com.softgroup.common.router.api.CommandTypeRouter;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class TypeRouter extends AbstractTypeRouterHandler<CommandTypeRouter>  {
    @Override
    public String getName(){
        return "common";
    }
}
