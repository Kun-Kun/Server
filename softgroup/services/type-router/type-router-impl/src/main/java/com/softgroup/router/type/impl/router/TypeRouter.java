package com.softgroup.router.type.impl.router;

import com.sofrgroup.router.type.api.TypeRouterHandler;
import com.softgroup.common.router.api.AbstractTypeRouterHandler;
import com.softgroup.common.router.api.CommandRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 26.02.2017.
 */
@Component
public class TypeRouter extends AbstractTypeRouterHandler<CommandRouterHandler>  implements TypeRouterHandler{
    @Override
    public String getName(){
        return "common";
    }
}
