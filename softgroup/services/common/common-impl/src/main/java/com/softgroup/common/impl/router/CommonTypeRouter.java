package com.softgroup.common.impl.router;

import com.softgroup.common.router.api.AbstractCommandRouterHandler;
import com.softgroup.common.router.api.AbstractTypeRouterHandler;
import com.softgroup.common.router.api.CommandTypeRouter;
import com.softgroup.common.router.api.CommonRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class CommonTypeRouter extends AbstractTypeRouterHandler<CommandTypeRouter>  {
    @Override
    public String getName(){
        return "common";
    }
}
