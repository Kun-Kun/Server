package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.PhoneNumberUUIDCache;
import com.softgroup.common.cache.SimpleExpirationDatabase;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 13.04.2017.
 */

public class PhoneNumberUUIDCacheImpl extends SimpleExpirationDatabase<String,String> implements PhoneNumberUUIDCache {

    public PhoneNumberUUIDCacheImpl() {
        super(10000, 10, TimeUnit.MINUTES);
    }
}
