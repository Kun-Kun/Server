package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.cache.ConfirmationRegisterDataCache;
import com.softgroup.common.cache.ExpirationDatabaseService;


import java.util.concurrent.TimeUnit;

/**
 * Created by user on 13.04.2017.
 */

public class ConfirmationRegisterCache extends ExpirationDatabaseService<String,ConfirmationRegisterData> implements ConfirmationRegisterDataCache {

    public ConfirmationRegisterCache() {
        super(10000, 10, TimeUnit.MINUTES);
    }
}
