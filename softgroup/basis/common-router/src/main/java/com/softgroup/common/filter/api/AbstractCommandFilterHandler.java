package com.softgroup.common.filter.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

/**
 * Created by user on 10.04.2017.
 */
public abstract class AbstractCommandFilterHandler<T extends Handler> extends AbstractFilterHandler<T> {

    String getFilteredValue(Request<?> msg){
        return msg.getHeader().getCommand();
    }
}
