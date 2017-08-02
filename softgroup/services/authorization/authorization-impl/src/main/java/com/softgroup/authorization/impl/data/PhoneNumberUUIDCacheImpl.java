package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.api.cache.ConfirmationRegisterData;
import com.softgroup.authorization.api.cache.PhoneNumberUUIDCache;
import com.softgroup.common.cache.ExpirationDatabaseService;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 13.04.2017.
 */

public class PhoneNumberUUIDCacheImpl extends ExpirationDatabaseService<String,String> implements PhoneNumberUUIDCache {

    public PhoneNumberUUIDCacheImpl() {
        super(10000, 10, TimeUnit.MINUTES);
    }
}
