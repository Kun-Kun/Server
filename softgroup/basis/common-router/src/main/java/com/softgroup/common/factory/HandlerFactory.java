package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

/**
 * Created by maxim on 06.03.17.
 */
public interface HandlerFactory {
    Handler getHandler(Request<?> msg);
}
