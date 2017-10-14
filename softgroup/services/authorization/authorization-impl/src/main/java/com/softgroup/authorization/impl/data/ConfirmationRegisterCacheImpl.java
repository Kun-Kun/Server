package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.common.cache.SimpleExpirationDatabase;


import java.util.concurrent.TimeUnit;

/**
 * Created by user on 13.04.2017.
 */

public class ConfirmationRegisterCacheImpl extends SimpleExpirationDatabase<String,ConfirmationRegisterData> implements ConfirmationRegisterCache {

    public ConfirmationRegisterCacheImpl() {
        super(10000, 10, TimeUnit.MINUTES);
    }
}
